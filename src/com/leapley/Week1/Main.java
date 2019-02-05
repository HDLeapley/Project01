package com.leapley.Week1;

import java.util.Scanner;

/*
Hudson Leapley 2/4/2019
If the user chooses to add a task, the program should prompt for a
description of the task and add it to the collection of tasks. If the
user chooses to remove a task, the program should ask the user which
item to remove and remove it from the collection of tasks. If the
user chooses to update a task, the program should ask which task will
be updated and for a new description of the task.  The program should
loop until the user chooses to exit.
 */
public class Main {

    static Scanner scan = new Scanner(System.in);
    static int currentTasks = 0;
    static int maxTasks = 100;

    static String[] desc = new String[maxTasks];
    static String[] tasks = new String[maxTasks];//Create string with a max of 100 tasks.

    static boolean displayMenu(){ //Display menu and ask which method to use.
        System.out.println("-------");
        System.out.println("Please choose an option:" + System.lineSeparator() +
                "(1) Add a task." + System.lineSeparator() +
                "(2) Remove a task." + System.lineSeparator() +
                "(3) Update a task." + System.lineSeparator() +
                "(4) List all tasks." + System.lineSeparator() +
                "(0) Exit."
        );

        int option = scan.nextInt();
        scan.nextLine();
        switch(option){
            case 1:
                addTask();
                break;

            case 2:
                remTask();
                break;

            case 3:
                updTask();
                break;

            case 4:
                lstTask();
                break;

            case 0:
                return false;
            default:
                System.out.println("Input invalid.");
                return true;
        }
        return true;
    }

    static void addTask(){//Add a task
        currentTasks++;
        System.out.println("Enter the task: ");
        tasks[currentTasks] = scan.nextLine();

        System.out.println("Enter the task description: ");
        desc[currentTasks] = scan.nextLine();
    }

    static void remTask(){//Remove a task
        System.out.println("Enter the task number: ");
        int taskNum = scan.nextInt();
        scan.nextLine();
        for (int i = taskNum; i<currentTasks; i++){
            tasks[i] = tasks[i+1];
        }
        for (int i = taskNum; i<currentTasks; i++){
            desc[i] = desc[i+1];
        }
        currentTasks--;
    }

    static void updTask(){//Update a task
        System.out.println("Enter the task number: ");
        int taskNum = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter the updated task: ");
        tasks[taskNum] = scan.nextLine();
        System.out.println("Enter the updated task description: ");
        desc[taskNum] = scan.nextLine();
    }

    static void lstTask(){//List tasks
        for (int i = 1; i<currentTasks+1;i++){
            System.out.println(i + ") " + tasks[i] + ": " + desc[i]);
        }
    }

    public static void main(String[] args) {
        boolean option = true;

        do {
            option = displayMenu();
        }while(option);
    }
}
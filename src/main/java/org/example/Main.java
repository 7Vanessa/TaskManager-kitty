package org.example;

import java.util.Scanner;

public class Main {

    private static int findInteger(String input) {
        StringBuilder intBuilder = new StringBuilder();
        boolean foundDigit = false;

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                intBuilder.append(c);
                foundDigit = true;
            } else if (foundDigit) {
                break;
            }
        }

        if (intBuilder.length() > 0) {
            try {
                return Integer.parseInt(intBuilder.toString());
            } catch (NumberFormatException e) {
                System.out.println("Error: The string contains an invalid integer.");
            }
        }

        return Integer.MIN_VALUE;
    }
    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager();
        Scanner myObj = new Scanner(System.in);
        String action;

        do {
            if(taskManager.isEmpty()) {
                System.out.println("No task yet");
            } else {
                System.out.println(taskManager.getTaskList());
            }

            System.out.println("Do an action: \n" +
                    "    + description> Add a task\n" +
                    "    - <id> Remove the task matching the given id\n" +
                    "    x <id> Set the status of the task matching the id to \"done\"\n" +
                    "    o <id> Set the status of the task matching the id to \"to do\"\n" +
                    "    q Exit the interaction loop\n");
            action = myObj.nextLine();

            switch (action.trim().charAt(0)) {
                case '+':
                    taskManager.addTask(action.substring(1).trim());
                    break;
                case '-':
                    taskManager.removeTask(findInteger(action));
                    break;
                case 'x':
                    taskManager.taskDone(findInteger(action));
                    break;
                case 'o':
                    taskManager.taskToDo(findInteger(action));
                    break;
                default:
                    System.out.println("Retry");
                    break;
            }
        } while (!(action.equals("q") || action.equals("Q")));

    }
}
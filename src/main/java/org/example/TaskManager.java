package org.example;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Task> taskList;

    public TaskManager() {
        taskList = new ArrayList<>();
    }

    public void parseAction(String action) {
        switch (action.trim().charAt(0)) {
            case '+':
                addTask(action.substring(1).trim());
                break;
            case '-':
                removeTask(findInteger(action));
                break;
            case 'x':
                taskToDo(findInteger(action));
                break;
        }
    }

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

    public List<Task> getTaskList() {
        return taskList;
    }

    public Task getTaskbyIndex(int index) {
        return taskList.get(index);
    }

    public void addTask(String description) {
        Task newTask = new Task(description, taskList.size() + 1);
        taskList.add(newTask);
    }

    public void removeTask(int id) {
        taskList.removeIf(task -> task.getId() == id);
    }

    public void taskDone(int id) {
        for (Task task: taskList) {
            if(task.getId() == id)
                task.setStatus(Status.DONE);
        }
    }

    public void taskToDo(int id) {
        for (Task task: taskList) {
            if(task.getId() == id)
                task.setStatus(Status.TODO);
        }
    }

    public Boolean isEmpty() {
        return taskList.size() == 0;
    }
}

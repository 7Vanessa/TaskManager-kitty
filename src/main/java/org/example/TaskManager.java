package org.example;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Task> taskList;

    public TaskManager() {
        taskList = new ArrayList<>();
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

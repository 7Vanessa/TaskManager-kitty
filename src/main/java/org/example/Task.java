package org.example;

public class Task {
    private String description;
    private int id;
    private Status status;

    public Task(String description, int id) {
        this.description = description;
        this.id = id;
        status = Status.TODO;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "" + id + " : " + description;
    }
}
package ru.rikabc.generate.model;

import java.util.Objects;

/**
 * @author Roman Khayrullin on 20.09.2018
 * @version 1.0
 */
public class Task {
    private String task;
    private String result;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task1 = (Task) o;
        return Objects.equals(task, task1.task) &&
                Objects.equals(result, task1.result);
    }

    @Override
    public int hashCode() {

        return Objects.hash(task, result);
    }
}

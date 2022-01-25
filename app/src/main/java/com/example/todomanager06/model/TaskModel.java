package com.example.todomanager06.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task_model")
public class TaskModel {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String task;
    public String date;
    public String repeat;

    public TaskModel(String task, String date, String repeat) {
        this.task = task;
        this.date = date;
        this.repeat = repeat;
    }

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRepeat() {
        return repeat;
    }

    public void setRepeat(String repeat) {
        this.repeat = repeat;
    }
}

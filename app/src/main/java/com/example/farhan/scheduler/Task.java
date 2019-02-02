package com.example.farhan.scheduler;

public class Task {
    private String title,time,date;

    public Task(String title, String time, String date) {
        this.title = title;
        this.time = time;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }
}

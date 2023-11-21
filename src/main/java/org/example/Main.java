package org.example;

public class Main {
    public static void main(String[] args) {
        CustomTimer customTimer = new CustomTimer();
        Runnable task = () -> System.out.println("Task is running");
        long interval = 3000L;
        customTimer.start(interval, task);
    }
}
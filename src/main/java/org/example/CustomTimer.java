package org.example;

public class CustomTimer {
    private Thread thread;
    private volatile boolean running = false;

    public synchronized void start(long interval, Runnable task) {
        running = true;
        thread = new Thread(() -> {
            while (running) {
                try {
                    task.run();
                    Thread.sleep(interval);
                }
                catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            }
        });
        thread.start();
    }

    public synchronized void stop() {
        running = false;
        if (thread != null) {
            thread.interrupt();
        }
    }
}

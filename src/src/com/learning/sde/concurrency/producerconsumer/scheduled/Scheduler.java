package com.learning.sde.concurrency.producerconsumer.scheduled;

public class Scheduler {

    public void schedule(Runnable command, long delay) {
        Thread prodThread = new Thread(() -> {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            command.run();
        });
        prodThread.start();
    }

    public void scheduleAtFixedRate(Runnable command, long initialDelay, long period) {
        Thread thread = new Thread(() -> {
           try {
               Thread.sleep(initialDelay);
           } catch (InterruptedException ex) {
               System.out.println("Got exception.");
           }
           while (true) {
               command.run();
               try {
                   Thread.sleep(period);
               } catch (InterruptedException ex) {
                   System.out.println("Got exception.");
               }
           }
        });
        thread.start();
    }
}

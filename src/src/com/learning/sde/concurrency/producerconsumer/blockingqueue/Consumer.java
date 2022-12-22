package com.learning.sde.concurrency.producerconsumer.blockingqueue;

public class Consumer implements Runnable {

    private MyBlockingQ queue;

    public Consumer(MyBlockingQ queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            String t = queue.take();
            System.out.println("Time consumed: " + t);
        }
    }
}

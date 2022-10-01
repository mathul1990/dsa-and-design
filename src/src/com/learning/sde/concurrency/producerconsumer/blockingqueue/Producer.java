package com.learning.sde.concurrency.producerconsumer.blockingqueue;

public class Producer implements Runnable {

    private MyBlockingQ queue;

    public Producer(MyBlockingQ queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            queue.put("" + System.currentTimeMillis());
        }
    }
}

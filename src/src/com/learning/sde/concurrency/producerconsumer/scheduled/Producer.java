package com.learning.sde.concurrency.producerconsumer.scheduled;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            long t = System.currentTimeMillis();
            try {
                queue.put("" + t);
            } catch (InterruptedException e) {
                System.out.println("Interrupted exception");
            }
        }
    }
}

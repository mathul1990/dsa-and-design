package com.learning.sde.concurrency.producerconsumer.basic;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String t = queue.take();
                System.out.println("consumed t: " + t);
            } catch (InterruptedException e) {
                System.out.println("Interrupted exception");
            }
        }
    }
}

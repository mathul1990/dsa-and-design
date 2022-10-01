package com.learning.sde.concurrency.basic;

public class BasicConcurrencyTask implements Runnable {

    private int count;

    @Override
    public void run() {
        count++;
        System.out.println("\nThread count: " + count + ", time: " + System.currentTimeMillis());
    }
}

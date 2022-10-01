package com.learning.sde.concurrency.producerconsumer.scheduled;

public class Command implements Runnable{
    @Override
    public void run() {
        System.out.println("Command executed: " + System.currentTimeMillis());
    }
}

package com.learning.sde.concurrency.producerconsumer.blockingqueue;

public class ProducerConsumer {

    public static void main(String[] args) {
        MyBlockingQ myBlockingQ = new MyBlockingQ(5);
        Thread prodThread = new Thread(new Producer(myBlockingQ));
        Thread consThread = new Thread(new Producer(myBlockingQ));
        prodThread.start();
        consThread.start();
    }
}

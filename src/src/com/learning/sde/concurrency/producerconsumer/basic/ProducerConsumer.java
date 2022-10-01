package com.learning.sde.concurrency.producerconsumer.basic;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        Thread threadProducer = new Thread(producer);
        Thread threadConsumer = new Thread(consumer);
        threadConsumer.start();
        threadProducer.start();
    }
}

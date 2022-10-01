package com.learning.sde.concurrency.producerconsumer.scheduled;

import java.util.Scanner;

public class ScheduleTaskClient {
    public static void main(String[] args) {
//        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
//        Producer producer = new Producer(queue);
//        Consumer consumer = new Consumer(queue);
//
//        Thread threadProducer = new Thread(producer);
//        Thread threadConsumer = new Thread(consumer);
//        threadConsumer.start();
//        threadProducer.start();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(line);
        Scheduler scheduler = new Scheduler();
        System.out.println("Invoking schedule: " + System.currentTimeMillis());
//        scheduler.schedule(new Command(), 10000);
        scheduler.scheduleAtFixedRate(new Command(), 10000, 5000);
    }
}

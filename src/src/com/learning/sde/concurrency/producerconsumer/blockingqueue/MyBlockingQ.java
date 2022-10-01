package com.learning.sde.concurrency.producerconsumer.blockingqueue;

import java.util.LinkedList;
import java.util.Queue;

public class MyBlockingQ {

    private Queue<String> queue;
    private Object notEmpty = new Object();
    private Object notFull = new Object();
    private int size;

    public MyBlockingQ(int size) {
        this.queue = new LinkedList<>();
        this.size = size;
    }

    public synchronized void put(String s) {
        System.out.println("Thread: " + Thread.currentThread().getName());
        try{
            while (queue.size() == size) {
                synchronized (notFull) {
                    notFull.wait();
                }
            }
            queue.add(s);
            synchronized (notEmpty) {
                notEmpty.notifyAll();
            }
        } catch (InterruptedException ex){
            System.out.println("Interrupted Exception put.");
        }
    }

    public synchronized void take() {
        System.out.println("Thread: " + Thread.currentThread().getName());
        try {
            synchronized (notEmpty) {
                while (queue.isEmpty()) {
                    notEmpty.wait();
                }
            }
            String t = queue.remove();
            System.out.println("Consumed: " + t);
            synchronized (notFull) {
                notFull.notifyAll();
            }
        } catch (InterruptedException ex) {
            System.out.println("Interrupted Exception put.");
        }
    }
}

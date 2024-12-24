package com.learning.sde.concurrency.printoddeven;

public class PrintOddEven implements Runnable {
    static int counter = 1;
    int N;

    int remainder;

    final Object lock;
    public PrintOddEven(int N, int remainder, Object lock) {
        this.N = N;
        this.remainder = remainder;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (counter < N) {
            synchronized (lock) {
                if (counter % 2 != remainder) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread().getName() + ": " + counter);
                counter++;
                lock.notify();
            }
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        PrintOddEven obj1 = new PrintOddEven(20, 1, lock);
        PrintOddEven obj2 = new PrintOddEven(20, 0, lock);

        Thread odd = new Thread(obj1, "odd");
        Thread even = new Thread(obj2, "even");

        odd.start();
        even.start();
    }
}

package com.learning.sde.concurrency.lc.printinorder;

import java.util.concurrent.Semaphore;

/**
 * Suppose we have a class:
 *
 * public class Foo {
 *   public void first() { print("first"); }
 *   public void second() { print("second"); }
 *   public void third() { print("third"); }
 * }
 * The same instance of Foo will be passed to three different threads. Thread A will call first(), thread B will call second(), and thread C will call third(). Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second().
 *
 * Note:
 *
 * We do not know how the threads will be scheduled in the operating system, even though the numbers in the input seem to imply the ordering. The input format you see is mainly to ensure our tests' comprehensiveness.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: "firstsecondthird"
 * Explanation: There are three threads being fired asynchronously. The input [1,2,3] means thread A calls first(), thread B calls second(), and thread C calls third(). "firstsecondthird" is the correct output.
 * Example 2:
 *
 * Input: nums = [1,3,2]
 * Output: "firstsecondthird"
 * Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(), and thread C calls second(). "firstsecondthird" is the correct output.
 *
 *
 * Constraints:
 *
 * nums is a permutation of [1, 2, 3].
 *
 */

public class PrintInOrder {

    private final Semaphore[] semaphores;
    private final int threadCount = 3;

    public PrintInOrder() {
        semaphores = new Semaphore[threadCount];
        try {
            for (int i = 0; i < threadCount; i++) {
                semaphores[i] = new Semaphore(1, true);
                semaphores[i].acquire();
            }
            semaphores[0].release();
        } catch (InterruptedException ex) {
            System.out.println("InterruptedException while acquiring semaphores.");
        }
    }

    public void first(Runnable printFirst) throws InterruptedException {
        semaphores[0].acquire();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        semaphores[1].release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphores[1].acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        semaphores[2].release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphores[2].acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        semaphores[0].release();
    }


    public static void main(String[] args) throws InterruptedException {
        PrintInOrder obj1 = new PrintInOrder();
        Thread threadC = new Thread(() -> {
            try {
                obj1.third(() -> {
                    System.out.println("third");
                });
            } catch (InterruptedException ex) {
                //
            }
        });

        Thread threadA = new Thread(() -> {
            try {
                obj1.first(() -> {
                    System.out.println("first");
                });
            } catch (InterruptedException ex) {
                //
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                obj1.second(() -> {
                    System.out.println("second");
                });
            } catch (InterruptedException ex) {
                //
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }
}

package com.learning.sde.sdesheet.recursion;

public class BackTracking {

    public void print1toNNoBackTracking(int i, int n) {
        if (i > n) {
            return;
        }
        System.out.print(i + " ");
        print1toNNoBackTracking(i+1, n);
    }

    /**
     * With backtracking for 1 to N we are not allowed to use + for printing 1 to N. This means that execution of the
     * actual operation (printing in this case) is invoked after recursion. First we will construct entire call stack.
     * Then operation is executed, starting from base case. ie in the reverse order.
     */
    public void print1toNBackTracking(int i, int n) {
        if (i < 1) {
            return;
        }
        print1toNBackTracking(i-1 , n);
        System.out.print(i + " ");
    }

    public void printNto1BackTracking(int i, int n) {
        if (i > n) {
            return;
        }
        printNto1BackTracking(i+1 , n);
        System.out.print(i + " ");
    }

    public static void main(String[] args) {
        BackTracking backTracking = new BackTracking();
        backTracking.print1toNNoBackTracking(1, 3);
        System.out.println();
        backTracking.print1toNBackTracking(3, 3);
        System.out.println();
        backTracking.printNto1BackTracking(1, 3);
    }
}

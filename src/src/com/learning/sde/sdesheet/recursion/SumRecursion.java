package com.learning.sde.sdesheet.recursion;

public class SumRecursion {

    public int sum(int n) {
        if (n == 1) return 1;
        return n + sum(n-1);
    }

    public void sumParameter(int i, int sum) {
        if (i < 1) {
            System.out.println(sum);
            return;
        }
        sumParameter(i-1, sum + i);
    }

    public static void main(String[] args) {
        SumRecursion sumRecursion = new SumRecursion();
        int s = sumRecursion.sum(4);
        System.out.println(s);
        sumRecursion.sumParameter(3, 0);
    }
}

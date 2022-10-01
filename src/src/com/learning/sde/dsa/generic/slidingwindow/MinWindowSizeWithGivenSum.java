package com.learning.sde.dsa.generic.slidingwindow;

public class MinWindowSizeWithGivenSum {

    /**
     * Find min window size with sum >= target sum in a sub array.
     */
    int minWindowSize(int[] array, int sum) {
        int len = array.length;
        int end = 0;
        int start = 0;
        int minWindow = Integer.MAX_VALUE;
        int t = 0;
        for (; end<len; end++) {
            t += array[end];

            while (t >= sum) {
                minWindow = Math.min(minWindow, end-start+1);
                t -= array[start];
                start++;
            }
        }
        return minWindow;
    }

    public static void main(String[] args) {
        MinWindowSizeWithGivenSum minWindowSizeWithGivenSum = new MinWindowSizeWithGivenSum();
        System.out.println("\n Min window size: " + minWindowSizeWithGivenSum.minWindowSize(new int[]{1, 2, 3, 4, 5}, 5));
    }
}

package com.learning.sde.dsa.generic.slidingwindow;

public class MaxSumSubArraySizeK {

    /**
     * Find maximum sum in an array with a sub array of size k.
     */
    int maxSumSubArrayOfSizeK(int[] array, int k) {
        int len = array.length;
        int end = 0;
        int start = 0;
        int sum = Integer.MIN_VALUE;
        int tempSum = 0;
        for (; end<len; end++) {
            tempSum += array[end];
            if (end - start == k-1) {
                sum = Math.max(sum, tempSum);
                tempSum -= array[start];
                start++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        MaxSumSubArraySizeK maxSumSubArraySizeK = new MaxSumSubArraySizeK();
        System.out.println("\n Array: " + maxSumSubArraySizeK.maxSumSubArrayOfSizeK(new int[]{1, 2, 3, 4, 5}, 3));
    }
}

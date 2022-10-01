package com.learning.sde.sdesheet.arrays;

import java.util.Scanner;

public class MaxSumContiguousSubArray {

    /**
     * Kadane's algorithm. Find max sum in any contiguous subarray of the given array,
     * minimum subarray length 1.
     *
     * Brute-force approach: 3 for loops - N^3
     *  i = 0 --> n-1
     *    j = i -->  n-1
     *      sum = 0
     *      k = i --> j
     *          sum += num[k]
     *          find max
     * Brute-force approach: 2 for loops - N^2
     *  i = 0 --> n-1
     *    curr_sum = 0
     *    j = i -->  n-1
     *       curr_sum += num[j]
     *       find max
     *
     *
     * Kadane's algo:
     * Use one for loop. Start from index 0. If the sum is found to be negative, ignore the
     * elements till now. ie make the sum till now as 0. So iteration will restart from next
     * index.
     *
     * @param num array.
     * @return max sum in any contiguous subarray of the given array, minimum subarray length 1.
     */
    public int maxSumContiguousSubArray(int[] num) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0;i<num.length; i++) {
            sum += num[i];
            max = Math.max(sum, max);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxSumContiguousSubArray maxSumContiguousSubArray = new MaxSumContiguousSubArray();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();
        int[] num = new int[n];
        System.out.println("Enter elements: ");
        for (int i = 0;i<n; i++) {
            num[i] = sc.nextInt();
        }
        int res = maxSumContiguousSubArray.maxSumContiguousSubArray(num);
        System.out.println("Result: " + res);
    }
}

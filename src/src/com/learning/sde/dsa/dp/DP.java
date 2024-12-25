package com.learning.sde.dsa.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DP Programs. Start with recursion.
 * Memoization - Top --> Bottom (like recursion ie n --> 0).
 * Tabulation - Bottom --> Up (0 --> n)
 */
public class DP {

    public int fibRecursion(int n) {
        if (n<2) {
            return n;
        }
        return fibRecursion(n-1) + fibRecursion(n-2);
    }

    /**
     * There are overlapping sub problems. Once a sub problem is solved, store it somewhere so that
     * it does no have to be computed again.
     */
    public int fibMemoization(int n, int[] dp) {
        if (n<2) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = fibMemoization(n-1, dp) + fibMemoization(n-2, dp);
    }

    public int fibTabulation(int n) {
        int[] dpArray = new int[n+1];
        for (int i = 0; i <= n; i++) {
            if (i<2) {
                dpArray[i] = i;
            } else {
                dpArray[i] = dpArray[i-1] + dpArray[i-2];
            }
        }
        return dpArray[n];
    }

    /**
     * Pick/Non-pick strategy for finding all subsequences. Refer L6. Recursion on Subsequences https://www.youtube.com/watch?v=AxNNVECce8c&t=805s.
     *
     * Subsequences - part of an array in a specific order, does not have to be contiguous.
     * Sub-array - contiguous sub set of an array.
     */
    public void printAllSubsequences(int[] arr, List<Integer> sub, int n, int i) {
        if (i == n) {
            for (int j =0; j<sub.size(); j++) {
                System.out.print(sub.get(j) + " ");
            }
            System.out.println();
            return;
        }

        //pick.
        sub.add(arr[i]);
        printAllSubsequences(arr, sub, n, i+1);
        // non-pick.
        sub.remove(sub.get(sub.size() - 1));

        printAllSubsequences(arr, sub, n, i+1);
    }

    public void printAllSubsequencesWithGivenSum(int[] arr, List<Integer> sub, int n, int i, int sum, int s) {
        if (i == n) {
            if (s == sum) {
                for (int j = 0; j < sub.size(); j++) {
                    System.out.print(sub.get(j) + " ");
                }
            }
            System.out.println();
            return;
        }

        //pick.
        sub.add(arr[i]);
        s += arr[i];
        printAllSubsequencesWithGivenSum(arr, sub, n, i+1, sum, s);
        // non-pick.
        sub.remove(sub.get(sub.size() - 1));
        s -= arr[i];

        printAllSubsequencesWithGivenSum(arr, sub, n, i+1, sum, s);
    }

    /**
     * Largest sum of non-adjacent subsequence in an array.
     * f(n-1) means max sum of nonAdj subsequences from indices 0 to n-1.
     * ie f(1) means max sum of nonAdj subsequences from indices 0 to 1,
     * f(2) means max sum of nonAdj subsequences from indices 0 to 2.
     *
     * The idea is to find the maximum sum among f(0), f(1) .... f(n-1).
     *
     * First thought is to find all subsequences. This is similar to the pick/not-pick problem for subsequences.
     * If an index i is picked, i-1 can't be picked, since adjacent elements are not allowed. So pick i-2.
     * If i is not picked, you can pick i-1.
     *
     * For memoizing check if recursion has overlapping sub problems.
     */
    public int nonAdjacentSum(int[] arr, int[] dp, int i) {
        if (i == 0) {
            return arr[0];
        }
        if (i<0) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int pick = arr[i] + nonAdjacentSum(arr, dp, i-2);
        int nonPick = 0 + nonAdjacentSum(arr, dp, i-1);
        return dp[i] = Math.max(pick, nonPick);
    }

    public int nonAdjacentSumTab(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        dp[0] = arr[0];
        for (int i = 1; i<arr.length; i++) {
            int pick = arr[i];
            if (i > 1) {
                pick += dp[i-2];
            }
            int nonPick = 0 + arr[i-1];
            dp[i] = Math.max(pick, nonPick);
        }
        return dp[arr.length-1];
    }

    /**
     * Ninja can perform one activity per day. Should not do the same activity as previous day.
     * Each activity has a separate score. So there are multiple entry points to score matrix. Greedy algo will not
     * work, since if we select highest score activity on day 0, day 1 we can't perform the same activity. So need
     * to consider all possible combinations to find the max merit point sum.
     *
     * This becomes a 2-D array with rows showing merit points associated with each activity on each day. Columns
     * represent the activities. Merit points on each activity on each day is different. So there is no uniformity
     * in the data set. This is why greedy algo will not work in this case.
     *
     * e.g. data set:
     *  2 1 3  --> day 0
     *  3 4 6  --> day 1
     *  10 1 6 --> day 2
     *  8 3 7   --> day 3
     *
     * For recursion, start from n-1 index and go till 0th index.
     *
     * On the first day of consideration, ninja can perform any of the 3 tasks. So in this case, lastDayTaskIndex
     * is 3, which means any of the 3 tasks can be performed. This is why dpMatrix has a size of 4(3+1).
     *
     *
     *
     * @return Maximum merit points ninja can earn.
     */
    public int ninjaTrainingRecursion(List<List<Integer>> scoreMatrix, int[][] dpMatrix, int lastDayTaskIndex, int day) {
        if (day == 0) {
            int max = 0;
            for (int task = 0; task < 3; task++) {
                if (task != lastDayTaskIndex) {
                    int tempMax = scoreMatrix.get(0).get(task);
                    max = Math.max(tempMax, max);
                }
            }
            return max;
        }

        if (dpMatrix[day][lastDayTaskIndex] != -1) {
            return dpMatrix[day][lastDayTaskIndex];
        }

        int max = 0;
        for (int task = 0; task < 3; task++) {
            if (task != lastDayTaskIndex) {
                int tempMax = scoreMatrix.get(day).get(task) + ninjaTrainingRecursion(scoreMatrix, dpMatrix, task, day-1);
                max = Math.max(tempMax, max);
            }
        }
        return dpMatrix[day][lastDayTaskIndex] = max;
    }

    public int ninjaTrainingTabulation(List<List<Integer>> scoreMatrix, int dayCount, int taskCount) {
        int[][] dpMatrix = new int[dayCount][taskCount];

        /**
         * dpMatrix with day as 0 means, choosing the task with max merit points compared to the task done at day 1.
         * For tabulation, start from index 0 and go till n-1. ie bottom-up approach.
         */

        dpMatrix[0][1] = Math.max(scoreMatrix.get(0).get(0), scoreMatrix.get(0).get(2));
        dpMatrix[0][2] = Math.max(scoreMatrix.get(0).get(1), scoreMatrix.get(0).get(0));
        dpMatrix[0][0] = Math.max(scoreMatrix.get(0).get(1), scoreMatrix.get(0).get(2));
        dpMatrix[0][3] = Math.max(scoreMatrix.get(0).get(1), Math.max(scoreMatrix.get(0).get(0), scoreMatrix.get(0).get(2)));

        for (int day = 1; day < dayCount; day++) {
            for (int lastDayIndex = 0; lastDayIndex < taskCount; lastDayIndex++) {
                dpMatrix[day][lastDayIndex] = 0;

                for (int task = 0; task < taskCount-1; task++) {
                    if (task != lastDayIndex) {
                        int tempMax = scoreMatrix.get(day).get(task) + dpMatrix[day - 1][task];
                        dpMatrix[day][lastDayIndex] = Math.max(tempMax,dpMatrix[day][lastDayIndex]);
                    }
                }
            }
        }

        return dpMatrix[dayCount - 1][taskCount-1];

    }

    public static void main(String[] args) {
        DP dp = new DP();
        int n = 10;
        System.out.println("Fib Recursion " + dp.fibRecursion(n));

        int[] dpArray = new int[n+1];
        Arrays.fill(dpArray, -1);
        System.out.println("Fib Memoization " + dp.fibMemoization(n, dpArray));

        System.out.println("Fib Tabulation " + dp.fibTabulation(n));

        System.out.println("Print all subsequences.");
        int[] array = {3,1,2};
        List<Integer> sub = new ArrayList<>();
        int i = 0;
        dp.printAllSubsequences(array, sub, array.length, i);
        System.out.println("Print all subsequences with given sum 3.");
        dp.printAllSubsequencesWithGivenSum(array, sub, array.length, i, 3, 0);

        int[] adjArray = {2,1,4,9};
        int[] dpArray1 = new int[4];
        Arrays.fill(dpArray1, -1);
        System.out.println("Largest non-adj sum: " + dp.nonAdjacentSum(adjArray, dpArray1, adjArray.length-1));
        System.out.println("Largest non-adj sum tab: " + dp.nonAdjacentSumTab(adjArray));

        List<Integer> dayArray1 = Arrays.asList(2,1,3);
        List<Integer> dayArray2 = Arrays.asList(3,4,6);
        List<Integer> dayArray3 = Arrays.asList(10,1,6);
        List<Integer> dayArray4 = Arrays.asList(8,3,7);
        List<List<Integer>> scoreMatrix = Arrays.asList(dayArray1, dayArray2, dayArray3, dayArray4);
        int[][] dpMatrix = new int[4][4];
        for (i = 0; i<4; i++) {
            for (int j =0; j<4; j++) {
                dpMatrix[i][j] = -1;
            }
        }
        int max = dp.ninjaTrainingRecursion(scoreMatrix, dpMatrix, 3, 3);
        System.out.println("Ninja score recursion: " + max);

        max = dp.ninjaTrainingTabulation(scoreMatrix, 4, 4);
        System.out.println("Ninja score tabulation: " + max);
    }
}

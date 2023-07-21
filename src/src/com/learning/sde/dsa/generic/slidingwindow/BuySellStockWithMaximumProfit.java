package com.learning.sde.dsa.generic.slidingwindow;

public class BuySellStockWithMaximumProfit {

    /**
     * Find maximum sum in an array with a sub array of size k.
     */
    int maxProfit(int[] array) {
        int len = array.length;
        int end = 0;
        int start = 0;
        int maxProfit = Integer.MIN_VALUE;
        int tempProfit = 0;
        for (end = 1; end < len; end++) {
            tempProfit = array[end] - array[start];
            if (tempProfit <= 0) {
                start = end;
            }
            maxProfit = Math.max(tempProfit, maxProfit);
        }
        return Math.max(maxProfit, 0);
    }

    public static void main(String[] args) {
        BuySellStockWithMaximumProfit buySellStockWithMaximumProfit = new BuySellStockWithMaximumProfit();
        System.out.println("\n Profit: " + buySellStockWithMaximumProfit.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}

package com.learning.sde.sdesheet.arrays;

public class StocksBuySell {

    public int maxProfit(int[] prices) {
        int s = 0;
        int e = 1;
        int max = Integer.MIN_VALUE;
        for (; e<prices.length;e++) {
            int d = prices[e] - prices[s];
            max = Math.max(max, d);
            if (d<0) {
                s = e;
            }
        }
        return max > 0 ? max : 0;
    }

    public static void main(String[] args) {
        StocksBuySell stocksBuySell = new StocksBuySell();
        int[] nums = new int[]{7,1,5,3,6,4};
        System.out.println("Max profit: " + stocksBuySell.maxProfit(nums));
    }
}

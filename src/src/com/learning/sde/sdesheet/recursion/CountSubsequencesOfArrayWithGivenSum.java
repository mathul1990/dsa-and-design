package com.learning.sde.sdesheet.recursion;

import java.util.ArrayList;
import java.util.List;

public class CountSubsequencesOfArrayWithGivenSum {

    /**
     * Pick (add) and not pick (remove) elements in each position.
     * Pattern:
     *  Base case:
     *      Return 1 when condition is satisfied. 0 otherwise.
     *      l = f()
     *      r = f()
     *      return l+r
     *      For n recursion calls use a for loop to iterate over the recursions and give the sum.
     *      Can remove ds used to store the elements, since no need to print subsequences.
     */
    public int subsequences(int index, int[] array, int n, int sum, int s) {
        if (index >= n) {
            if (s == sum) {
                return 1;
            }
            return 0;
        }
        sum += array[index];
        int l = (subsequences(index + 1, array, n, sum, s));

        sum -= array[index];
        int r = subsequences(index + 1, array, n, sum, s);
        return l + r;
    }

    public static void main(String[] args) {
        CountSubsequencesOfArrayWithGivenSum subsequencesOfArray = new CountSubsequencesOfArrayWithGivenSum();
        int[] nums = {1, 2, 1};
        int sum = 0;
        int s = 2;
        System.out.println(subsequencesOfArray.subsequences(0, nums, nums.length, sum, s));
    }
}

package com.learning.sde.sdesheet.recursion;

import java.util.ArrayList;
import java.util.List;

public class OneSubsequenceOfArrayWithGivenSum {

    /**
     * Pick (add) and not pick (remove) elements in each position.
     * Pattern:
     *  Base case:
     *      Return true when case is satisfied. False otherwise.
     *      If recursion returns true, return true from the invocation, so that rest of the recursion is skipped.
     *      Else return false, so that recursion continues till it finds a match.
     */
    public boolean subsequences(int index, List<Integer> ds, int[] array, int n, int sum, int s) {
        if (index >= n) {
            if (s == sum) {
                System.out.println(ds);
                return true;
            }
            return false;
        }
        ds.add(array[index]);
        sum += array[index];
        if (subsequences(index + 1, ds, array, n, sum, s)) {
            return true;
        }

        ds.remove(ds.size()-1);
        sum -= array[index];
        if (subsequences(index + 1, ds, array, n, sum, s)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        OneSubsequenceOfArrayWithGivenSum subsequencesOfArray = new OneSubsequenceOfArrayWithGivenSum();
        int[] nums = {1, 2, 1};
        List<Integer> ds = new ArrayList<>();
        int sum = 0;
        int s = 2;
        subsequencesOfArray.subsequences(0, ds, nums, nums.length, sum, s);
    }
}

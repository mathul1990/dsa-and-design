package com.learning.sde.sdesheet.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequencesOfArrayWithGivenSum {

    /**
     * Pick (add) and not pick (remove) elements in each position.
     */
    public void subsequences(int index, List<Integer> ds, int[] array, int n, int sum, int s) {
        if (index >= n) {
            if (s == sum) {
                System.out.println(ds);
            }
            return;
        }
        ds.add(array[index]);
        sum += array[index];
        subsequences(index+1, ds, array, n, sum, s);

        ds.remove(ds.size()-1);
        sum -= array[index];
        subsequences(index+1, ds, array, n, sum, s);
    }

    public static void main(String[] args) {
        SubsequencesOfArrayWithGivenSum subsequencesOfArray = new SubsequencesOfArrayWithGivenSum();
        int[] nums = {1, 2, 1};
        List<Integer> ds = new ArrayList<>();
        int sum = 0;
        int s = 2;
        subsequencesOfArray.subsequences(0, ds, nums, nums.length, sum, s);
    }
}

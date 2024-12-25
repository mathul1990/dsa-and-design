package com.learning.sde.sdesheet.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsequencesOfArray {

    /**
     * Pick (add) and not pick (remove) elements in each position.
     */
    public void subsequences(int index, List<Integer> ds, int[] array, int n) {
        if (index >= n) {
            System.out.println(ds);
            return;
        }
        ds.add(array[index]);
        subsequences(index+1, ds, array, n);

        ds.remove(ds.size()-1);
        subsequences(index+1, ds, array, n);
    }

    public static void main(String[] args) {
        SubsequencesOfArray subsequencesOfArray = new SubsequencesOfArray();
        int[] nums = {3, 1, 2};
        List<Integer> ds = new ArrayList<>();
        subsequencesOfArray.subsequences(0, ds, nums, nums.length);
    }
}

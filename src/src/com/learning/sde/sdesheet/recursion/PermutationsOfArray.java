package com.learning.sde.sdesheet.recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfArray {

    public void recurPermute(int[] nums, List<Integer> ds, List<List<Integer>> ans, boolean[] freq) {
        if(ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = 0;i<nums.length;i++) {
            if(!freq[i]) {
                freq[i] = true;
                ds.add(nums[i]);
                recurPermute(nums, ds, ans, freq);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }

        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        int[] nums = {1, 2, 3};
        boolean freq[] = new boolean[nums.length];
        PermutationsOfArray permutationsOfArray = new PermutationsOfArray();
        permutationsOfArray.recurPermute(nums, ds, ans, freq);
        System.out.print(ans);
    }
}

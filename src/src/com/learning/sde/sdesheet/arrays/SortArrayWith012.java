package com.learning.sde.sdesheet.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SortArrayWith012 {

    public void sortWithExtraSpaceAndMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0);
            map.put(nums[i], count + 1);
        }
        int c1 = map.getOrDefault(0, 0);
        int c2 = map.getOrDefault(1, 0);
        int c3 = map.getOrDefault(2, 0);
        int i = 0;
        for (; i < c1; i++) {
            nums[i] = 0;
        }
        for (; i < c1+c2; i++) {
            nums[i] = 1;
        }
        for (; i < c1+c2+c3; i++) {
            nums[i] = 2;
        }
    }

    public void sortWithExtraSpaceAndVariables(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        for (int i = 0; i<nums.length; i++) {
            if (nums[i] == 0) {
                c1++;
            } else if (nums[i] == 1) {
                c2++;
            } else if (nums[i] == 2) {
                c3++;
            }
        }
        int i = 0;
        for (; i < c1; i++) {
            nums[i] = 0;
        }
        for (; i < c1+c2; i++) {
            nums[i] = 1;
        }
        for (; i < c1+c2+c3; i++) {
            nums[i] = 2;
        }
    }

    /**
     * Dutch national flag algorithm. - When we need to sort array with only 3 distinct entries.
     * Intention is to move all the 0s to begining of the array and all 2s to end of the array and 1s to middle.
     * 3 pointers, low , mid and high.
     * low = 0, mid = 0, high = n-1.
     * Move 0s to low position and increment low. Move 2s to high position and decrement high. For 1s, increment mid, it
     * will get adjusted to middle part while we arrange 0s and 1s.
     *
     * @param nums Array.
     */
    public void sortWithoutExtraSpace(int[] nums) {
        int l = 0;
        int m = 0;
        int h = nums.length-1;
        while (m <= h) {
            int t;
            if (nums[m] == 0) {
                t = nums[l];
                nums[l] = nums[m];
                nums[m] = t;
                l++;
                m++;
            } else if (nums[m] == 1) {
                m++;
            } else if (nums[m] == 2) {
                t = nums[h];
                nums[h] = nums[m];
                nums[m] = t;
                h--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("N: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Array: ");
        for (int i = 0; i<n; i++) {
            nums[i] = sc.nextInt();
        }
        SortArrayWith012 sortArrayWith012 = new SortArrayWith012();
        sortArrayWith012.sortWithExtraSpaceAndVariables(nums);
        System.out.println("Sorted Array: ");
        for (int i = 0; i<n; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

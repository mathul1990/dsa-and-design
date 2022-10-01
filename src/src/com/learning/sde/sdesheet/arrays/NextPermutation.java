package com.learning.sde.sdesheet.arrays;

import java.util.Arrays;

public class NextPermutation {

    /**
     * Brute force approach: Take all permutations, which will be n!. So total, O(n!*n).
     * For eg: {{1,2,3} {1,3,2} {2,1,3} {2,3,1} {3,1,2} {3,2,1}} will be the combinations for {1,2,3}.
     *
     * Optimal approach O(n): Intuition for this, is dictionary order.
     * From end of array, there will be an increasing sequence till a certain point, even if
     * it is a single element. We need to find this point, and start swapping it from next point.
     *
     * 1,If you start from end, you need to stop at first occurrence where a[i]<a[i+1], name it ind1.
     * 2,Then start from back and find first ind2 such that a[ind2] > a[ind1].
     * 3,Then swap a[ind1] and a[ind2].
     * 4,Reverse from ind1 to last.
     *
     */
    void nextPermutationLexicographically(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int i = array.length - 2;
        // Find first element where a[i] < a[i+1], ie ind1.
        while(i >= 0 && array[i] >= array[i+1]) {
            i--;
        }

        if (i>=0) {
            // Start from end and find the element where a[ind2] > a[ind1]
            int j = array.length - 1;
            while (array[j] <= array[i]) {
                j--;
            }
            // Swap elements at ind1 and ind2.
            swap(array, i, j);
        }
        // Reverse from ind1 to ind2.
        reverse(array, i+1, array.length-1);
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Reverse array from index i to j;
     */
    public void reverse(int[] array, int i , int j) {
        while(i<j) {
            swap(array, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] array = {3,2,1};
        nextPermutation.nextPermutationLexicographically(array);
        System.out.println("\n Next permutation:\n");
        System.out.print(Arrays.toString(array));
    }
}

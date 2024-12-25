package com.learning.sde.sdesheet.recursion;

import java.util.Arrays;

public class ReverseArray {

    public void reverse1(int[] arr, int l, int r) {
        if (l >= r) return;
        swap(arr, l, r);
        reverse1(arr, l+1, r-1);
    }

    public void reverse2(int[] arr, int i, int n) {
        if (i >= n/2) return;
        swap(arr, i, n-i-1);
        reverse2(arr, i+1, n);
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public boolean checkPalindrome(String str, int i, int n) {
        if (i >= n/2) return true;

        if (str.charAt(i) != str.charAt(n-i-1)) {
            return false;
        }
        return checkPalindrome(str, i+1, n);
    }

    public static void main(String[] args) {
        ReverseArray reverseArray = new ReverseArray();
        int[] array = {1, 2, 3, 4, 5};
        reverseArray.reverse1(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
        reverseArray.reverse2(array, 0, array.length);
        System.out.println(Arrays.toString(array));

        String str = "abcca";
        System.out.println(reverseArray.checkPalindrome(str, 0, str.length()));
    }
}

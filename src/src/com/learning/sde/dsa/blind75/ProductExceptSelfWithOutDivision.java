package com.learning.sde.dsa.blind75;

import java.util.Scanner;

public class ProductExceptSelfWithOutDivision {

    static int[] productExceptSelfNoSpace(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];

        int product = 1;
        // Populate prefix product array.
        for (int i = 0; i <n; i++) {
            product *= nums[i];
            res[i] = product;
        }

        product = 1;
        for (int i = n-1; i > 0; i--) {
            res[i] = res[i-1] * product;
            product *= nums[i];
        }
        res[0] = product;
        return res;
    }

    static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        prefix[0] = nums[0];
        postfix[nums.length-1] = nums[nums.length-1];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i] * prefix[i-1];
            postfix[n-i-1] = nums[n-i-1] * postfix[n-i];
        }

        int[] res = new int[n];
        res[0] = postfix[1];
        res[nums.length-1] = prefix[n-2];

        for (int i = 1; i < n-1; i++) {
            res[i] = prefix[i-1] * postfix[i+1];
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("Result:");
        int[] res =  productExceptSelf(array);
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}

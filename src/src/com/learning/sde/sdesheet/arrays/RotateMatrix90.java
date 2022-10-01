package com.learning.sde.sdesheet.arrays;

import java.util.Scanner;

public class RotateMatrix90 {

    /**
     * O(N^2) time. O(N^2) space.
     */
    public int[][] rotateMatrix90ClockWiseExtraSpace(int[][] m, int r, int c) {
        int[][] newMatrix = new int[r][c];
        for (int i = 0; i<r;i++) {
            for (int j = 0; j < c; j++) {
                newMatrix[i][j] = m[r-j-1][i];
            }
        }
        return newMatrix;
    }

    /**
     * 1 2 3
     * 4 5 6
     * 7 8 9
     *
     * Result:
     * 7 4 1
     * 8 5 2
     * 9 6 3
     *
     *  Result is the transpose of each row reversed. So first take transpose of the matrix and reverse row by row.
     *
     *  2 * O(N^2) time. O(1) space.
     *
     */
    public void rotateMatrix90ClockWiseWithOutExtraSpace(int[][] m, int r, int c) {
        System.out.println("Matrix len: " + m.length);
        for (int i = 0; i<r;i++) {
            for (int j = i+1; j < c; j++) {
                int t = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = t;
            }
        }
        /**
         * For reversing 2 pointer method can be used. One pointer starts from start another from end. Reverse
         * elements in each row till middle.
         */

        for(int i = 0; i<r;i++) {
            for (int j = 0;j<c/2;j++) {
                int t = m[i][j];
                m[i][j] = m[i][c-j-1];
                m[i][c-j-1] = t;
            }
        }
    }

    public void rotateMatrix90AntiClockWiseWithOutExtraSpace(int[][] m) {
        int l = m.length;
        System.out.println("Matrix len: " + m.length);
        // Transpose.
        for (int i = 0; i<l;i++) {
            for (int j = i+1; j < l; j++) {
                int t = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = t;
            }
        }
        /**
         * Reverse rows.
         */

        for (int i = 0; i<l/2; i++) {
            for (int j = 0; j<l; j++) {
                int t = m[i][j];
                m[i][j] = m[l-i-1][j];
                m[l-i-1][j] = t;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter row: ");
        int r = scanner.nextInt();
        System.out.println("Enter column: ");
        int c = scanner.nextInt();
        System.out.println("Enter matrix: ");
        int[][] matrix = new int[r][c];
        for (int i = 0; i<r;i++) {
            for (int j = 0; j<c;j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Entered matrix: ");
        for (int i = 0; i<r;i++) {
            for (int j = 0; j<c;j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        RotateMatrix90 rotateMatrix90 = new RotateMatrix90();
//        System.out.println("Rotated 90 Clockwise Matrix: ");
//        int[][] newMatrix = rotateMatrix90.rotateMatrix90ExtraSpace(matrix, r, c);
//        rotateMatrix90.rotateMatrix90ClockWiseWithOutExtraSpace(matrix, r, c);
//        for (int i = 0; i<r;i++) {
//            for (int j = 0; j<c;j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println("Rotated 90 Anti-Clockwise Matrix: ");
        rotateMatrix90.rotateMatrix90AntiClockWiseWithOutExtraSpace(matrix);
        for (int i = 0; i<r;i++) {
            for (int j = 0; j<c;j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

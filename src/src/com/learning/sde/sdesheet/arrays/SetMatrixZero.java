package com.learning.sde.sdesheet.arrays;

import java.util.Arrays;

public class SetMatrixZero {

    /**
     * Create 2 1-D arrays with row and column sizes. Iterate through matrix and update them if
     * a 0 is found in 2-D array. Then iterate through matrix again and update after checking
     * 1-D arrays.
     * @param matrix 2-D Array.
     */
    public void setZeroesWithMplusNSpace(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[] row = new int[r];
        int[] col = new int[c];
        Arrays.fill(row, -1);
        Arrays.fill(col, -1);

        for (int i = 0; i<r; i++) {
            for (int j = 0;j<c;j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 0;
                    col[j] = 0;
                }
            }
        }

        for (int i = 0; i<r; i++) {
            for (int j = 0;j<c;j++) {
                if (row[i] == 0 || col[j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * Use first row and column instead of 2 1-D arrays in above solution.
     * @param matrix 2-D array.
     */
    public void setZeroesWithNoExtraSpace(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        boolean isCol0Zero = false;

        for (int i = 0; i<r; i++) {
            if (matrix[i][0] == 0) isCol0Zero = true;
            for (int j = 1; j < c; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i<r; i++) {
            for (int j = 2; j < c; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
                if (isCol0Zero) matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZero setMatrixZero = new SetMatrixZero();
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setMatrixZero.setZeroesWithMplusNSpace(matrix);
        System.out.println("\nSet Zeroes with Extra Space:");
        int r = matrix.length;
        int c = matrix[0].length;
        for (int i = 0; i<r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nSet Zeroes with No Extra Space:");
        int[][] matrix1 = {{1,1,1},{1,0,1},{1,1,1}};
        r = matrix1.length;
        c = matrix1[0].length;
        setMatrixZero.setZeroesWithNoExtraSpace(matrix1);
        for (int i = 0; i<r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

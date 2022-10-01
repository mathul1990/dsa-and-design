package com.learning.sde.sdesheet.arrays;

import java.util.Scanner;

public class TransposeOfMatrix {

    /**
     * Transpose of a matrix means changing rows to columns. ie A[i][j] --> A[j][i].
     */
    public int[][] transposeWithExtraSpace(int[][] m, int r, int c) {
        int[][] newMatrix = new int[r][c];
        for (int i = 0; i<r;i++) {
            for (int j = 0; j < c; j++) {
                newMatrix[i][j] = m[j][i];
            }
        }
        return newMatrix;
    }

    /**
     * In-place swap without using an extra array. Notice that j starts always from i+1, otherwise swap will happen
     * twice and will negate the first swap.
     */
    public void transposeWithOutExtraSpace(int[][] m, int r, int c) {
        for (int i = 0; i<r;i++) {
            for (int j = i+1; j < c; j++) {
                int t = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = t;
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
        System.out.println("Transpose matrix: ");
        TransposeOfMatrix transposeOfMatrix = new TransposeOfMatrix();
//        int[][] newMatrix = transposeOfMatrix.transposeWithExtraSpace(matrix, r , c);
        transposeOfMatrix.transposeWithOutExtraSpace(matrix, r , c);
        for (int i = 0; i<r;i++) {
            for (int j = 0; j<c;j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}

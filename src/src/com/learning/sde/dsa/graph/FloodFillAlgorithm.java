package com.learning.sde.dsa.graph;

import java.util.Scanner;

public class FloodFillAlgorithm {

    static void dfs(int[][] matrix, int[][] ans, int[] delRow, int[] delCol, int sr, int sc, int newColour, int iniColour) {
//        ans[sr][sc] = newColour;
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i =0; i<4; i++) {
            int r1 = sr + delRow[i];
            int c1 = sc + delCol[i];

            if (r1 >= 0 && r1 <n && c1 >=0 && c1 < m && (matrix[r1][c1] == iniColour) && (ans[r1][c1] != newColour)) {
                ans[r1][c1] = newColour;
                dfs(matrix, ans, delRow, delCol, r1, c1, newColour, iniColour);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Grid row: ");
        int row = scanner.nextInt();
        System.out.println("Grid column: ");
        int col = scanner.nextInt();

        int[][] matrix = new int[row][col];
        for (int i = 0;i<row; i++) {
            for (int j = 0;j<col; j++) {
                int c = scanner.nextInt();
                matrix[i][j] = c;
            }
        }
        int[][] ans = matrix;
        int sr = 0;
        int sc = 0;
        int newColour = 3;
        int iniColour = 2;
        // Question: https://www.youtube.com/watch?v=C-2_uSRli8o&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=9
        for (int i = 0;i<row; i++) {
            for (int j = 0; j < col; j++) {
                /**
                 * These 2 arrays are used to find neighbouring cells in 4 directions for a given cell.
                 * For (r,c) neighbouring cells in 4 directions are (r, c-1), (r-1, c), (r, c+1), (r+1, c).
                 */
                int[] delRow = {0, -1, 0, 1};
                int[] delCol = {-1, 0, 1, 0};
                dfs(matrix, ans, delRow, delCol, sr, sc, newColour, iniColour);
            }
        }

        for (int i = 0;i<row; i++) {
            for (int j = 0;j<col; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}

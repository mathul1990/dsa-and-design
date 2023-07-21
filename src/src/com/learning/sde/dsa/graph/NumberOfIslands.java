package com.learning.sde.dsa.graph;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NumberOfIslands {

    static void bfs(int[][] grid, int[][] visited, int row, int col) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(row, col));
        int n = grid.length;
        int m = grid[0].length;

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.peek();
            int r = pair.getKey();
            int c = pair.getValue();
            queue.remove();

            /***
             * This loop helps to go through neighbours of a given cell. There can be up to 8 possibilities
             * of neighbouring cells. For a given (r,c), neighbours can be (r-1, c-1), (r-1, c), (r-1, c+1),
             * (r, c-1), (r, c+1), (r+1, c-1), (r+1, c), (r+1, c+1). So neighbouring cells range from adding
             * -1 to +1 to (r,c). So below loop can be used to get all neighbouring cells for a given cell.
             *
             */
            for (int delrow = -1; delrow <=1; delrow++) {
                for (int delcol = -1; delcol <=1; delcol++) {
                    int r1 = r + delrow;
                    int c1 = c + delcol;
                    if ((r1 >= 0) && (c1 >=0) && r1 < n && c1 < m && (visited[r1][c1] == 0) && (grid[r1][c1] == 1)) {
                        visited[r1][c1] = 1;
                        queue.add(new Pair<>(r1, c1));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Grid row: ");
        int row = scanner.nextInt();
        System.out.println("Grid column: ");
        int col = scanner.nextInt();

        int[][] grid = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //char c = scanner.next().charAt(0);
                int c = scanner.nextInt();
                grid[i][j] = c;
            }
        }

        System.out.println("Grid: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        int[][] visited = new int[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visited[i][j] == 0 && grid[i][j] == 1) {
                    count++;
                    bfs(grid, visited, i, j);
                }
            }
        }
        System.out.println("No. of islands: " + count);
    }
}

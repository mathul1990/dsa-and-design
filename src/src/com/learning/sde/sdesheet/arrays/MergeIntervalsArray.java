package com.learning.sde.sdesheet.arrays;

import java.util.*;

public class MergeIntervalsArray {

    /**
     * Merge overlapping sub intervals in a matrix.
     *Intuition: Since we have sorted the intervals, the intervals which will be merging are bound to be adjacent.
     * We kept on merging simultaneously as we were traversing through the array and when the element was
     * non-overlapping we simply inserted the element in our data structure.
     */
    public int[][] mergeIntervals(int[][] intervals) {
        List<int[]> res=new ArrayList<>();
        if(intervals.length==0 || intervals==null){
            return new int[0][];
        }
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int[] i:intervals){
            if(i[0]<=end){
                System.out.println("i[0]: " + i[0] + ", start:" + start + ", " + end + ", " + i[1]);
                end=Math.max(end,i[1]);
            }
            else{
                res.add(new int[]{start,end});
                System.out.println(start + ", " + end);
                start=i[0];
                end=i[1];
                System.out.println("new start: " + start + ", new end: " + end);
            }

        }
        res.add(new int[]{start,end});
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {

        int[][] array = new int[][]{{1,3}, {2,6}, {8,10}, {8,9}, {2,4}, {15,18}, {16,17}};
        MergeIntervalsArray mergeIntervalsArray = new MergeIntervalsArray();
        int[][] matrix = mergeIntervalsArray.mergeIntervals(array);
        for (int i = 0; i<matrix.length;i++) {
            for (int j = 0; j<2;j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}

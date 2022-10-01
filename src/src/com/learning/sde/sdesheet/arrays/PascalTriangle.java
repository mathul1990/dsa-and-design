package com.learning.sde.sdesheet.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    /**
     *
     *              1
     *             1 1
     *            1 2 1
     *           1 3 3 1
     *          1 4 6 4 1
     *
     * @param numRows rows number.
     * @return pascal's triangle.
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> temp = new ArrayList();
        temp.add(1);
        result.add(temp);
        for (int i = 1; i < numRows; i++) {
            temp = result.get(i-1);
            List<Integer> temp2 = new ArrayList();
            for (int j = 0; j<=i; j++) {
                if (j == 0 || j == i) {
                    temp2.add(1);
                } else {
                    temp2.add(temp.get(j-1) + temp.get(j));
                }
            }
            result.add(temp2);
        }
        return result;
    }
    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        System.out.println("Pascal's triangle: ");
        List<List<Integer>> res = pascalTriangle.generate(5);
        System.out.print(res);
    }
}

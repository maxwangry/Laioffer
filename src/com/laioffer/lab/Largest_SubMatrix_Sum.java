package com.laioffer.lab;

/**
 * Created by Ruoyu on 2016/10/31.
 */
public class Largest_SubMatrix_Sum {

    public static int largest(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < row; i++) {
            int[] cur = new int[col];
            for (int j = i; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    cur[k] += matrix[j][k];
                }
                result = Math.max(result, max(cur));
            }
        }

        return result;
    }

    private static int max(int[] cur) {
        int result = cur[0];
        int lastMax = cur[0];
        for (int i = 1; i < cur.length; i++) {
            lastMax = Math.max(lastMax + cur[i], cur[i]);
            result = Math.max(result, lastMax);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1, -2, -1, 4}, {1, -1, 1, 1}, {0, -1, -1, 1}, {0, 0, 1, 1}};
        System.out.println(largest(input));
    }
}

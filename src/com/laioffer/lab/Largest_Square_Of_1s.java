package com.laioffer.lab;

/**
 * Created by Ruoyu on 2016/10/29.
 */
public class Largest_Square_Of_1s {

    public static int largest(int[][] matrix) {
        int size = matrix.length;
        int[][] helper = new int[size][size];
        int max = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || j == 0) {
                    helper[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 0) {
                    helper[i][j] = 0;
                } else {
                    helper[i][j] = 1 + Math.min(helper[i - 1][j - 1], Math.min(helper[i - 1][j], helper[i][j - 1]));
                }
                max = Math.max(helper[i][j], max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 0, 0, 0}, {1, 1, 1, 1}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        System.out.print(largest(matrix));
    }
}

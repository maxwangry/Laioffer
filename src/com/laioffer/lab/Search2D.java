package com.laioffer.lab;

import java.util.Arrays;

public class Search2D {
    public static int[] search(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return new int[]{-1, -1};
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            int rows = mid / n;
            int cols = mid % n;
            if (matrix[rows][cols] < target) left = mid + 1;
            else if (matrix[rows][cols] > target) right = mid - 1;
            else return new int[]{rows, cols};
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] matrix = new int[][]{{1, 2, 3, 3, 4}, {4, 5, 6, 7, 10}, {12, 14, 14, 17, 19}, {22, 22, 22, 24, 25}};
        System.out.println(Arrays.toString(search(matrix, 6)));
    }

}

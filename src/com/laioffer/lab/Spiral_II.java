package com.laioffer.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ruoyu on 2016/10/24.
 */
public class Spiral_II {

    public static List<Integer> spiral(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return result;
        }
        int m = matrix[0].length;
        int n = matrix.length;
        spiral(matrix, 0, m, n, result);
        return result;
    }

    private static void spiral(int[][] matrix, int offset, int m, int n, List<Integer> result) {
        if (m == 0 || n == 0) {
            return;
        }
        if (m == 1) {
            for (int i = 0; i < n; i++) {
                result.add(matrix[offset + i][offset]);
            }
            return;
        }
        if (n == 1) {
            for (int i = 0; i < m; i++) {
                result.add(matrix[offset][offset + i]);
            }
            return;
        }
        for (int i = 0; i < m - 1; i++) {
            result.add(matrix[offset][offset + i]);
        }
        for (int i = 0; i < n - 1; i++) {
            result.add(matrix[offset + i][offset + m - 1]);
        }
        for (int i = m - 1; i > 0; i--) {
            result.add(matrix[offset + n - 1][offset + i]);
        }
        for (int i = n - 1; i > 0; i--) {
            result.add(matrix[offset + i][offset]);
        }
        spiral(matrix, offset + 1, m - 2, n - 2, result);
    }

    public static void main(String[] args) {
        int[][] matrix1 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] matrix2 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matrix3 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        System.out.println(Arrays.deepToString(matrix1));
        System.out.println(Arrays.toString(spiral(matrix1).toArray()));
        System.out.println(Arrays.deepToString(matrix2));
        System.out.println(Arrays.toString(spiral(matrix2).toArray()));
        System.out.println(Arrays.deepToString(matrix3));
        System.out.println(Arrays.toString(spiral(matrix3).toArray()));
    }
}

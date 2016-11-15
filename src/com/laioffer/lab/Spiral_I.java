package com.laioffer.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ruoyu on 2016/10/24.
 */
public class Spiral_I {

    public static List<Integer> spiral(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return result;
        }
        spiral(matrix, 0, matrix.length, result);
        return result;
    }

    private static void spiral(int[][] matrix, int offset, int size, List<Integer> result) {
        if (size < 1) {
            return;
        }
        if (size == 1) {
            result.add(matrix[offset][offset]);
            return;
        }
        for (int i = 0; i < size - 1; i++) {
            result.add(matrix[offset][offset + i]);
        }
        for (int i = 0; i < size - 1; i++) {
            result.add(matrix[offset + i][offset + size - 1]);
        }
        for (int i = size - 1; i > 0; i--) {
            result.add(matrix[offset + size - 1][offset + i]);
        }
        for (int i = size - 1; i > 0; i--) {
            result.add(matrix[offset + i][offset]);
        }
        spiral(matrix, offset + 1, size - 2, result);
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println(Arrays.toString(spiral(matrix).toArray()));
        System.out.println(Arrays.deepToString(matrix));
    }
}

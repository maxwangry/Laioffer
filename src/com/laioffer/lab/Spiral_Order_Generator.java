package com.laioffer.lab;

import java.util.Arrays;

/**
 * Created by Ruoyu on 2016/10/26.
 */
public class Spiral_Order_Generator {

    public static int[][] spiralGenerate(int m, int n) {
        int[][] result = new int[m][n];
        int counter = 1;
        spiral(result, 0, m, n, counter);
        return result;
    }

    private static void spiral(int[][] matrix, int offset, int m, int n, int counter) {
        if (m == 0 || n == 0) {
            return;
        }
        if (m == 1) {
            for (int i = 0; i < n; i++) {
                matrix[offset][offset + i] = counter++;
            }
            return;
        }
        if (n == 1) {
            for (int i = 0; i < m; i++) {
                matrix[offset + i][offset] = counter++;
            }
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            matrix[offset][offset + i] = counter++;
        }
        for (int i = 0; i < m - 1; i++) {
            matrix[offset + i][offset + n - 1] = counter++;
        }
        for (int i = n - 1; i > 0; i--) {
            matrix[offset + m - 1][offset + i] = counter++;
        }
        for (int i = m - 1; i > 0; i--) {
            matrix[offset + i][offset] = counter++;
        }
        spiral(matrix, offset + 1, m - 2, n - 2, counter);
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.deepToString(spiralGenerate(3,4)));
        System.out.println(Arrays.deepToString(spiralGenerate(2, 0)));
    }
}

package com.laioffer.lab;

/**
 * Created by Ruoyu on 2016/10/31.
 */
public class Largest_X_Of_1s {

    public static int largest(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int N = matrix.length;
        int M = matrix[0].length;

        // 4 DP matrix with 4 directions
        int[][] leftUp = new int[N][M];
        int[][] leftDown = new int[N][M];
        int[][] rightUp = new int[N][M];
        int[][] rightDown = new int[N][M];

        // Fill these 4 matrix
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 || j == 0) {
                    leftUp[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 0) {
                    leftUp[i][j] = 0;
                } else {
                    leftUp[i][j] = 1 + leftUp[i - 1][j - 1];
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = M - 1; j >= 0; j--) {
                if (i == 0 || j == M - 1) {
                    rightUp[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 0) {
                    rightUp[i][j] = 0;
                } else {
                    rightUp[i][j] = 1 + rightUp[i - 1][j + 1];
                }
            }
        }
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < M; j++) {
                if (i == N - 1 || j == 0) {
                    leftDown[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 0) {
                    leftDown[i][j] = 0;
                } else {
                    leftDown[i][j] = 1 + leftDown[i + 1][j - 1];
                }
            }
        }
        for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                if (i == N - 1 || j == M - 1) {
                    rightDown[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 0) {
                    rightDown[i][j] = 0;
                } else {
                    rightDown[i][j] = 1 + rightDown[i + 1][j + 1];
                }
            }
        }

        // Combine these 4 helper matrix into 1
        int globalMax = 0;
        int localMin;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int min1 = Math.min(leftUp[i][j], rightUp[i][j]);
                int min2 = Math.min(leftDown[i][j], rightDown[i][j]);
                localMin = Math.min(min1, min2);
                globalMax = Math.max(globalMax, localMin);
            }
        }

        return globalMax;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{0, 1, 0, 0}, {1, 1, 1, 1}, {0, 1, 0, 0}, {0, 1, 0, 0}};
        int[][] input1 = new int[][]{{0, 0, 0, 0}, {1, 1, 1, 1}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        System.out.println(largest(input));
        System.out.println(largest(input1));
    }
}

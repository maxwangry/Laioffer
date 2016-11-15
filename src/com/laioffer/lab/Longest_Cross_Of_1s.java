package com.laioffer.lab;

/**
 * Created by Ruoyu on 2016/10/31.
 */
public class Longest_Cross_Of_1s {

    public static int largest(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int N = matrix.length;
        int M = matrix[0].length;

        // 4 DP matrix with 4 directions
        int[][] leftRight = new int[N][M];
        int[][] topDown = new int[N][M];
        int[][] rightLeft = new int[N][M];
        int[][] bottomUp = new int[N][M];

        // Fill these 4 matrix
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j == 0) {
                    leftRight[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 0) {
                    leftRight[i][j] = 0;
                } else {
                    leftRight[i][j] = 1 + leftRight[i][j - 1];
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0) {
                    topDown[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 0) {
                    topDown[i][j] = 0;
                } else {
                    topDown[i][j] = 1 + topDown[i - 1][j];
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = M - 1; j >= 0; j--) {
                if (j == M - 1) {
                    rightLeft[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 0) {
                    rightLeft[i][j] = 0;
                } else {
                    rightLeft[i][j] = 1 + rightLeft[i][j + 1];
                }
            }
        }
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < M; j++) {
                if (i == N - 1) {
                    bottomUp[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 0) {
                    bottomUp[i][j] = 0;
                } else {
                    bottomUp[i][j] = 1 + bottomUp[i + 1][j];
                }
            }
        }

        // Combine these 4 helper matrix into 1
        int globalMax = 0;
        int localMin;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int min1 = Math.min(leftRight[i][j], rightLeft[i][j]);
                int min2 = Math.min(topDown[i][j], bottomUp[i][j]);
                localMin = Math.min(min1, min2);
                globalMax = Math.max(globalMax, localMin);
            }
        }

        return globalMax;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{0, 1, 0, 0}, {1, 1, 1, 1}, {0, 1, 0, 0}, {0, 1, 0, 0}};
        System.out.print(largest(input));
    }
}

package com.laioffer.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ruoyu on 2016/10/24.
 */
public class NQueens {

    public static List<List<Integer>> nqueens(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        nqueens(0, n, new ArrayList<Integer>(), result);
        return result;
    }

    private static void nqueens(int level, int n, List<Integer> solution, List<List<Integer>> result) {
        if (level == n) {
            result.add(new ArrayList<>(solution));
            return;
        }
        for (int i = 0; i < n; i++) {
            solution.add(i);
            if (valid(solution, i, level)) {
                nqueens(level + 1, n, solution, result);
            }
            solution.remove(solution.size() - 1);
        }
    }

    private static boolean valid(List<Integer> solution, int lastX, int lastY) {
        int y = 0;
        double slope;
        for (Integer x : solution) {
            if (y < lastY) {
                slope = (double) (x - lastX) / (double) (y - lastY);
                if (x == lastX || slope == 1 || slope == -1) {
                    return false;
                }
            }
            y++;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = nqueens(8);
        System.out.println(Arrays.toString(result.toArray()));
        System.out.println(result.size());
    }
}

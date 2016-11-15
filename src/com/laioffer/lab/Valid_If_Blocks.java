package com.laioffer.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ruoyu on 2016/11/14.
 */
public class Valid_If_Blocks {

    public static List<List<String>> blocks(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> solution = new ArrayList<>();
        helper(result, solution, 0, 0, n);
        return result;
    }


    private static void helper(List<List<String>> result, List<String> solution, int left, int right, int n) {
        if (left == n && right == n) {
            result.add(new ArrayList<>(solution));
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (left < n) {
            for (int i = 0; i < left - right; i++) {
                sb.append("  ");
            }
            solution.add(sb.append("if {").toString());
            helper(result, solution, left + 1, right, n);
            solution.remove(solution.size() - 1);
        }


        sb = new StringBuilder();
        if (right < left) {
            for (int i = 0; i < left - right - 1; i++) {
                sb.append("  ");
            }
            solution.add(sb.append("}").toString());
            helper(result, solution, left, right + 1, n);
            solution.remove(solution.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(blocks(2).toArray()));
        System.out.println(Arrays.toString(blocks(3).toArray()));
        System.out.println(Arrays.toString(blocks(4).toArray()));
        System.out.println(Arrays.toString(blocks(1).toArray()));
    }
}

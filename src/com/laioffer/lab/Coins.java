package com.laioffer.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ruoyu
 *         <p>
 *         Print all combinations of coins that can sum up to a total value k;
 */
public class Coins {

    public static List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> result = new ArrayList<>();
        if (coins == null || coins.length == 0) {
            return result;
        }
        DFS1(target, coins, 0, new ArrayList<>(), result);
        return result;
    }

    private static void DFS1(int remain, int[] coins, int level, List<Integer> solution, List<List<Integer>> result) {
        if (level == coins.length - 1) {
            if (remain % coins[coins.length - 1] == 0) {
                solution.add(remain / coins[coins.length - 1]);
                result.add(new ArrayList<>(solution));
                solution.remove(solution.size() - 1);
            }
            return;
        }
        for (int i = 0; i <= remain / coins[level]; i++) {
            solution.add(i);
            DFS1(remain - i * coins[level], coins, level + 1, solution, result);
            solution.remove(solution.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(combinations(0, new int[]{2, 1}).toArray()));
    }

}

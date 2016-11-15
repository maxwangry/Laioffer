package com.laioffer.lab;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by Ruoyu on 2016/10/28.
 */
public class Dictionary_Word_I {

    public boolean canBreak(String input, String[] dict) {
        HashSet<String> myDict = new HashSet<>(Arrays.asList(dict));
        int size = input.length();
        int[] dp = new int[size + 1];
        dp[0] = 1;
        for (int i = 1; i <= size; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == 1 && myDict.contains(input.substring(j, i))) {
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[size] == 1;
    }
}

package com.laioffer.lab;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanan on 2016/10/14.
 */
public class Longest_Substring_No_Dup {

    public static int longest(String input) {
        if (input == null) {
            return 0;
        }
        Map<Character, Integer> freq = new HashMap<>();
        char[] chars = input.toCharArray();
        int max = 0;
        int start = 0;

        for (int end = 0; end < chars.length; end++) {
            if (!freq.containsKey(chars[end])) {
                freq.put(chars[end], 1);
                max = end - start + 1 > max ? end - start + 1 : max;
            } else if (freq.get(chars[end]) < 1) {
                freq.put(chars[end], freq.get(chars[end]) + 1);
                max = end - start + 1 > max ? end - start + 1 : max;
            } else {
                int i = start;
                while (chars[i] != chars[end]) {
                    freq.put(chars[i], freq.get(chars[i]) - 1);
                    i++;
                }
                start = i + 1;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(longest("bcdfbd"));
    }
}

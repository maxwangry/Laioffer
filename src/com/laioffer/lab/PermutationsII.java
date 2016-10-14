package com.laioffer.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by yanan on 2016/10/13.
 */
public class PermutationsII {

    public static List<String> permutations(String set) {
        List<String> result = new ArrayList<>();
        if (set == null || set.length() == 0) {
            return result;
        }

        permute(set.toCharArray(), 0, result);

        return result;
    }

    private static void permute(char[] chars, int level, List<String> result) {
        if (level == chars.length) {
            result.add(String.valueOf(chars));
            return;
        }

        HashSet<Character> hashSet = new HashSet<>();
        for (int i = level; i < chars.length; i++) {
            if (!hashSet.contains(chars[i])) {
                hashSet.add(chars[i]);
                swap(chars, i, level);
                permute(chars, level + 1, result);
                swap(chars, i, level);
            }
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(permutations("abc").toArray()));
        System.out.println(Arrays.toString(permutations("").toArray()));
    }
}

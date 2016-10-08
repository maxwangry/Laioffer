package com.laioffer.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static List<String> permutations(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        char[] chars = set.toCharArray();
        DFS(chars, 0, result);
        return result;
    }

    private static void DFS(char[] chars, int level, List<String> result) {
        if (level == chars.length) {
            result.add(new String(chars));
            return;
        }
        for (int i = level; i < chars.length; i++) {
            swap(chars, level, i);
            DFS(chars, level + 1, result);
            swap(chars, level, i);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(permutations("abc").toArray()));
    }

}

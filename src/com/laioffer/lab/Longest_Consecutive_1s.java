package com.laioffer.lab;

/**
 * Created by Ruoyu on 2016/10/29.
 */
public class Longest_Consecutive_1s {

    public static int longest(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int[] counter = new int[array.length];
        // Base case;
        counter[0] = array[0];
        int max = counter[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] == 0) {
                counter[i] = 0;
            } else {
                counter[i] = 1 + counter[i - 1];
                max = Math.max(max, counter[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.print(longest(new int[]{0, 1, 0, 1, 1, 1, 0}));
    }
}

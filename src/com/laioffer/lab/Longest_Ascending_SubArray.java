package com.laioffer.lab;

/**
 * Created by Ruoyu on 2016/10/26.
 */
public class Longest_Ascending_SubArray {

    public static int longest(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int size = array.length;
        int[] helper = new int[size];
        helper[0] = 1;
        int max = 1;

        for (int i = 1; i < size; i++) {
            if (array[i - 1] < array[i]) {
                helper[i] = helper[i - 1] + 1;
                max = Math.max(max, helper[i]);
            } else {
                helper[i] = 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{7, 2, 3, 1, 5, 8, 9, 6};
        int[] a2 = new int[]{1, 2, 3, 3, 4, 4, 5};
        System.out.println(longest(a1));
        System.out.println(longest(a2));
    }
}

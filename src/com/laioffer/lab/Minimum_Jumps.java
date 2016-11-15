package com.laioffer.lab;

import java.util.Arrays;

/**
 * Created by Ruoyu on 2016/10/28.
 */
public class Minimum_Jumps {

    public static int minJump(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int size = array.length;
        int[] steps = new int[size];
        Arrays.fill(steps, -1);
        steps[size - 1] = 0;

        for (int i = size - 2; i >= 0; i--) {
            if (array[i] != 0) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= array[i]; j++) {
                    if (j < size - i && steps[i + j] != -1) {
                        min = Math.min(min, steps[i + j]);
                    }
                }
                if (min != Integer.MAX_VALUE) {
                    steps[i] = 1 + min;
                }
            }
        }

        return steps[0];
    }

    public static int minJump2(int[] array) {
        int size = array.length;
        int[] minStep = new int[size];
        minStep[0] = 0;
        for (int i = 1; i < size; i++) {
            minStep[i] = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (minStep[j] != -1 && array[j] + j >= i) {
                    minStep[i] = Math.min(minStep[i], minStep[j] + 1);
                }
            }
            minStep[i] = minStep[i] == Integer.MAX_VALUE ? -1 : minStep[i];
        }
        return minStep[size - 1];
    }

    public static int minJump3(int[] array) {
        int size = array.length;
        int[] minStep = new int[size];
        minStep[size - 1] = 0;
        for (int i = size - 2; i >= 0; i--) {
            minStep[i] = Integer.MAX_VALUE;
            for (int j = i + 1; j < size; j++) {
                if (minStep[j] != -1 && array[i] + i >= j) {
                    minStep[i] = Math.min(minStep[i], minStep[j] + 1);
                }
            }
            minStep[i] = minStep[i] == Integer.MAX_VALUE ? -1 : minStep[i];
        }
        return minStep[0];
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{3, 3, 1, 0, 4};
        int[] a2 = new int[]{2, 1, 1, 0, 2};
        System.out.println(minJump(a1));
        System.out.println(minJump(a2));
        System.out.println(minJump3(new int[]{1, 2, 0}));
        System.out.println(minJump3(a1));
        System.out.println(minJump3(a2));
    }
}

package com.laioffer.lab;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Ruoyu on 2016/11/9.
 */
public class Shuffling {

    public static void shuffle(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        for (int i = array.length - 1; i > 0; i--) {
            int index = new Random().nextInt(i + 1);
            swap(i, index, array);
        }
    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 2};
        shuffle(array);
        System.out.println(Arrays.toString(array));
    }
}

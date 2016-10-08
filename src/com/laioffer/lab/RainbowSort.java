package com.laioffer.lab;

import java.util.Arrays;

/* 
 * Given an array of balls, where the color of the balls can only be Red, Green or Blue, 
 * sort the balls such that all the Red balls are grouped on the left side,
 * all the Green balls are grouped in the middle
 * and all the Blue balls are grouped on the right side.
 * (Red is denoted by -1, Green is denoted by 0, and Blue is denoted by 1).
 */

public class RainbowSort {

    public static int[] rainbowSort(int[] array) {

        // Corner case
        if (array.length <= 1) return array;

        int red = 0, green = 0, blue = array.length - 1;
        while (green <= blue) {
            if (array[green] == -1) {
                swap(red, green, array);
                red++;
                green++;
            } else if (array[green] == 1) {
                swap(blue, green, array);
                blue--;
            } else {
                green++;
            }
        }
        return array;
    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = new int[]{1, 0, -1, 0, 0, 1};
        array = rainbowSort(array);
        System.out.println(Arrays.toString(array));

    }

}

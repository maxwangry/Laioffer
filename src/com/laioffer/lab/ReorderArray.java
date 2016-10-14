package com.laioffer.lab;

import java.util.Arrays;

/**
 * Created by yanan on 2016/10/12.
 */
public class ReorderArray {

    public static int[] reorder(int[] array) {
        if (array.length % 2 == 0) {
            convert(array, 0, array.length - 1);
        } else {
            convert(array, 0, array.length - 2);
        }

        return array;
    }

    private static void convert(int[] array, int left, int right) {
        if (right - left <= 1) {
            return;
        }

        int size = right - left + 1;
        int mid = left + size / 2;
        int leftMid = left + size / 4;
        int rightMid = left + size * 3 / 4;

        reverse(array, leftMid, mid - 1);
        reverse(array, mid, rightMid - 1);
        reverse(array, leftMid, rightMid - 1);

        convert(array, left, left + 2 * (leftMid - left) - 1);
        convert(array, left + 2 * (leftMid - left), right);
    }

    private static void reverse(int[] array, int start, int end) {
        while (start < end) {
            swap(array, start++, end--);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(reorder(new int[]{0, 1, 2, 3, 4, 5, 6, 7})));
    }
}

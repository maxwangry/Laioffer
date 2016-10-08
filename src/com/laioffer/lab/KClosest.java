package com.laioffer.lab;

import java.util.Arrays;

public class KClosest {
    public static int[] kClosest(int[] array, int target, int k) {
        int[] result = new int[k];
        int left = 0, right = array.length - 1, mid;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (array[mid] < target) left = mid;
            else if (array[mid] > target) right = mid;
            else {
                left = mid;
                right = mid + 1;
                break;
            }
        }
        for (int i = 0; i < k; i++) {
            if (right >= array.length || left >= 0 && target - array[left] < array[right] - target) {
                result[i] = array[left--];
            } else {
                result[i] = array[right++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = new int[]{1, 4, 6, 8};
        int[] result = kClosest(array, 3, 3);
        System.out.println(Arrays.toString(result));
    }

}

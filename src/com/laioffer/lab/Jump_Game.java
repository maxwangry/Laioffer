package com.laioffer.lab;

/**
 * Created by Ruoyu on 2016/10/26.
 */
public class Jump_Game {

    public static boolean canJump(int[] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        int size = array.length;
        int[] helper = new int[size];
        helper[size - 1] = 1;
        for (int i = size - 2; i >= 0; i--) {
            for (int j = 1; j <= array[i]; j++) {
                if (j < size - i && helper[i + j] == 1) {
                    helper[i] = 1;
                    break;
                }
            }
        }
        return helper[0] == 1;
    }

    public static boolean canJump2(int[] array) {
        int size = array.length;
        boolean[] canJump = new boolean[size];
        canJump[0] = true;
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (canJump[j] && j + array[j] >= i) {
                    canJump[i] = true;
                    break;
                }
            }
        }
        return canJump[size - 1];
    }

    public static boolean canJump3(int[] array) {
        if (array.length == 1) {
            return true;
        }
        int cur = 0;
        int next = 0;
        for (int i = 0; i < array.length; i++) {
            if (i > cur) {
                if (cur == next) {
                    return false;
                }
                cur = next;
            }
            next = Math.max(next, i + array[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{1, 3, 2, 0, 3};
        int[] a2 = new int[]{4, 2, 1, 2, 0, 0};
//        System.out.println(canJump(a1));
        System.out.println(canJump3(a1));
    }
}

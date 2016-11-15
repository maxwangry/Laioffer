package com.laioffer.lab;

/**
 * Created by Ruoyu on 2016/11/6.
 */
public class All_Unique_Characters_II {

    public static boolean allUnique(String word) {
        int[] map = new int[8];
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (((1 << (c % 32)) & (map[c / 32])) != 0) {
                return false;
            } else {
                map[c / 32] |= 1 << (c % 32);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(allUnique("abA+\\8"));
        System.out.println(allUnique("abA+\\a88"));
    }
}

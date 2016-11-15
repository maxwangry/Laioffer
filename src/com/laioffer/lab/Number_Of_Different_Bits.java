package com.laioffer.lab;

/**
 * Created by Ruoyu on 2016/11/6.
 */
public class Number_Of_Different_Bits {

    public static int diffBits(int a, int b) {
        int c = a ^ b;
        int count = 0;
        while (c != 0) {
            count += c & 1;
            c >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(diffBits(Integer.MAX_VALUE, Integer.MIN_VALUE));
    }
}

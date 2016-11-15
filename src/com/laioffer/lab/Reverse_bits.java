package com.laioffer.lab;

/**
 * Created by Ruoyu on 2016/11/6.
 */
public class Reverse_bits {

    public int reverse(int n) {
        for (int i = 0; i < 16; i++) {
            n = swap(n, i, 31 - i);
        }
        return n;
    }

    private int swap(int n, int i, int j) {
        int left = ((n >> i) & 1);
        int right = ((n >> j) & 1);
        if ((left & right) != 1) {
            n ^= (1 << i) | (1 << j);
        }
        return n;
    }
}

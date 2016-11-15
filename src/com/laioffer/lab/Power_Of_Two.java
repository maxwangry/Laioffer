package com.laioffer.lab;

/**
 * Created by Ruoyu on 2016/10/26.
 */
public class Power_Of_Two {

    public boolean isPowerOfTwo(int number) {
        if (number <= 0) {
            return false;
        }
        long helper = 1;
        while (helper < number) {
            helper *= 2;
        }
        return helper == number;
    }
}

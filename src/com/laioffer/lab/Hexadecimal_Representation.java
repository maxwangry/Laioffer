package com.laioffer.lab;

/**
 * Created by Ruoyu on 2016/11/6.
 */
public class Hexadecimal_Representation {

    public static String hex(int number) {
        if (number == 0) {
            return "0x0";
        }
        StringBuilder result = new StringBuilder();
        while (number > 0) {
            int remainder = number % 16;
            if (remainder < 10) {
                result.append((char) ('0' + remainder));
            } else {
                result.append((char) ('A' + remainder - 10));
            }
            number >>>= 4;
        }
        result.append("x0");
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(hex(29));
        System.out.println(hex(255));
        System.out.println(hex(0));
    }
}

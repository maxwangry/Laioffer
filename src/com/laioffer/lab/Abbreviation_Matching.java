package com.laioffer.lab;

/**
 * Created by Ruoyu on 2016/10/26.
 */
public class Abbreviation_Matching {

    public static boolean match(String input, String pattern) {
        // Base case
        if (input.length() == 0 && pattern.length() == 0) {
            return true;
        }
        if (input.length() == 0 || pattern.length() == 0) {
            return false;
        }

        if (Character.isDigit(pattern.charAt(0))) {
            int i = 0;
            int offset = 0;
            while (i < pattern.length() && Character.isDigit(pattern.charAt(i))) {
                offset = offset * 10 + pattern.charAt(i) - '0';
                i++;
            }
            if (offset > input.length()) {
                return false;
            } else {
                return match(input.substring(offset), pattern.substring(i));
            }
        } else {
            if (input.charAt(0) != pattern.charAt(0)) {
                return false;
            } else {
                return match(input.substring(1), pattern.substring(1));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(match("sophisticated", "s11d"));
    }
}

package com.laioffer.lab;

public class Remove_Adjacent_Repeated_I {

    public static String deDup(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        int slow = 1;
        char[] chars = input.toCharArray();
        for (int fast = 1; fast < chars.length; fast++) {
            if (chars[fast] != chars[fast - 1]) {
                chars[slow++] = chars[fast];
            }
        }
        return new String(chars, 0, slow);
    }

    public static void main(String[] args) {
        System.out.println(deDup("aaaabbbc"));
    }
}

package com.laioffer.lab;

/**
 * Created by yanan on 2016/10/13.
 */
public class DecompressStringII {

    public static String decompress1(String input) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i += 2) {
            char letter = input.charAt(i);
            int repeat = Character.getNumericValue(input.charAt(i + 1));
            if (repeat != 0) {
                for (int j = 0; j < repeat; j++) {
                    result.append(letter);
                }
            }
        }

        return result.toString();
    }

    public static String decompress2(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] chars = input.toCharArray();
        // Pre calculate the length of the decompressed string
        int size = 0;
        for (int i = 1; i < input.length(); i += 2) {
            size += Character.getNumericValue(chars[i]);
        }

        int index = size - 1;
        for (int i = input.length() - 2; i >= 0; i -= 2) {
            char letter = chars[i];
            int repeat = Character.getNumericValue(chars[i + 1]);
            if (repeat != 0) {
                for (int j = 0; j < repeat; j++) {
                    chars[index--] = letter;
                }
            }
        }

        return chars.toString();
    }

    public static void main(String[] args) {
        //System.out.println(decompress1("a1c0b2c4"));
        System.out.println(decompress2("a1c0b2c1"));
    }
}

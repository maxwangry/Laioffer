package com.laioffer.lab;

/**
 * Created by yanan on 2016/10/11.
 */
public class Reverse_Words {

    public static String reverseWords(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        input = reverse(input, 0, input.length() - 1);
        String[] words = input.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = reverse(words[i], 0, words[i].length() - 1);
        }

        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (result.length() > 0) {
                result.append(' ');
            }
            result.append(word);
        }

        return result.toString();
    }

    private static String reverse(String s, int left, int right) {
        char[] chars = s.toCharArray();
        while (left < right) {
            swap(chars, left++, right--);
        }
        return String.valueOf(chars);
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        System.out.print(reverseWords("I Love Google"));
    }
}

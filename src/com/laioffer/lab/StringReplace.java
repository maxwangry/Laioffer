package com.laioffer.lab;

/**
 * Created by yanan on 2016/10/12.
 */
public class StringReplace {

    public static String replace(String input, String s, String t) {

/*        if (input.length() < s.length()) {
            return input;
        }

        char[] charsInput = input.toCharArray();

        if (s.length() >= t.length()) {
            int slow = 0;
            for (int fast = 0; fast < charsInput.length; fast++) {
                if (charsInput[fast] != s.charAt(0)) {
                    charsInput[slow++] = charsInput[fast];
                } else {
                    int i;
                    for (i = 0; i < s.length(); i++) {
                        if (charsInput[fast + i] != s.charAt(i)) {
                            break;
                        }
                    }
                    if (i == s.length()) {
                        fast += s.length() - 1;
                        for (int j = 0; j < t.length(); j++) {
                            charsInput[slow++] = t.charAt(j);
                        }
                    }
                }
            }
            input = new String(charsInput, 0, slow);
        } else {

        }*/


        if (input.length() < s.length()) {
            return input;
        }

        StringBuilder result = new StringBuilder();
        int i;
        for (i = 0; i <= input.length() - s.length(); i++) {
            if (input.charAt(i) != s.charAt(0)) {
                result.append(input.charAt(i));
            } else {
                int j;
                for (j = 0; j < s.length(); j++) {
                    if (input.charAt(i + j) != s.charAt(j)) {
                        break;
                    }
                }
                if (j == s.length()) {
                    i += s.length() - 1;
                    result.append(t);
                } else {
                    result.append(input.charAt(i));
                }
            }
        }

        while (i < input.length()) {
            result.append(input.charAt(i++));
        }
        return result.toString();
    }

    public static void main(String[] args) {
////        System.out.println(replace("appledogapple", "apple", "cat"));
////        System.out.println(replace("dodododo", "dod", "a"));
//        System.out.println(replace("aaa", "aa", "b"));
        System.out.println(replace("ababacdaba", "aba", "c"));
    }
}

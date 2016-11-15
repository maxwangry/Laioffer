package com.laioffer.lab;

/**
 * Created by Ruoyu on 2016/11/14.
 */
public class Minimum_Cuts_For_Palindromes {

    public static int minCuts(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        char[] chars = input.toCharArray();
        int size = chars.length;

        // isPalindrome[start][end] means subString(start - 1, end - 1) is palindrome or not.
        boolean[][] isPalindrome = new boolean[size + 1][size + 1];
        int[] minCuts = new int[size + 1];

        for (int end = 1; end <= size; end++) {
            minCuts[end] = Integer.MAX_VALUE;
            for (int start = end; start >= 1; start--) {
                if (chars[end - 1] == chars[start - 1]) {
                    isPalindrome[start][end] = end - start <= 1 || isPalindrome[start + 1][end - 1];
                }
                if (isPalindrome[start][end]) {
                    minCuts[end] = Math.min(minCuts[end], 1 + minCuts[start - 1]);
                }
            }
        }
        return minCuts[size] - 1;
    }

    public static int minCut(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        int size = input.length();
        char[] chars = input.toCharArray();

        // isPalindrome[i][j] means whether subString(i, j) is palindrome or not.
        boolean[][] isPalindrome = new boolean[size][size];
        int[] minCut = new int[size];

        for (int i = 0; i < size; i++) {
            minCut[i] = i; // max cuts is cut between each letter
            for (int j = i; j >= 1; j--) {
                if (chars[i] == chars[j]) {
                    if (i - j <= 1) {
                        isPalindrome[j][i] = true;
                    } else {
                        isPalindrome[j][i] = isPalindrome[j + 1][i - 1];
                    }
                }
                if (isPalindrome[j][i]) {
                    minCut[i] = Math.min(minCut[i], 1 + minCut[j - 1]);
                }
            }
        }
        return minCut[size - 1];
    }

    public static int minCut2(String input) {
        int size = input.length();
        char[] chars = input.toCharArray();
        int[] minCuts = new int[size];


        for (int i = 0; i < size; i++) {// Linear scan
            minCuts[i] = i; // At most cut between every adjacent letters;
            if (isValid(chars, 0, i)) {
                minCuts[i] = 0;
                continue;
            }
            for (int j = i - 1; j >= 0; j--) {// 回头看
                if (isValid(chars, j + 1, i)) {// check 右小段
                    minCuts[i] = Math.min(minCuts[i], minCuts[j] + 1);
                }
            }
        }
        return minCuts[size - 1];
    }


    private static boolean isValid(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left++] != chars[right--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.print(minCuts("ababbbabbababa"));
        System.out.print(minCut2("ababbbabbababa"));
    }
}

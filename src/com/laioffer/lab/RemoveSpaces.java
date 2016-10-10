package com.laioffer.lab;

public class RemoveSpaces {

    public static String removeSpaces(String input) {

        char[] chars = input.toCharArray();
        int slow = 0;

        for (int fast = 0; fast < chars.length; fast++) {
            //if (!(chars[fast] == ' ' && (fast == 0 || chars[fast - 1] == ' '))) {
            if (chars[fast] != ' ' || (fast != 0 && chars[fast - 1] != ' ')) {
                chars[slow++] = chars[fast];
            }
        }

        if (slow != 0 && chars[slow - 1] == ' ') {
            slow--;
        }
        return new String(chars, 0, slow);
    }

    public static void main(String[] args) {
        System.out.println(removeSpaces(" a"));
        System.out.println(removeSpaces("   I     love MTV "));
    }
}

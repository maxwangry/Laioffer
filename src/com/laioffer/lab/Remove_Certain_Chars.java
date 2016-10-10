package com.laioffer.lab;

import java.util.HashSet;
import java.util.Set;

public class Remove_Certain_Chars {

    public static String remove(String input, String t) {

        char[] charsToRemove = t.toCharArray();
        char[] origChars = input.toCharArray();
        Set<Character> hashSet = new HashSet<>();
        for (char c : charsToRemove) {
            hashSet.add(c);
        }

        int slow = 0;
        for (int fast = 0; fast < origChars.length; fast++) {
            if (!hashSet.contains(origChars[fast])) {
                origChars[slow] = origChars[fast];
                slow++;
            }
        }

        return new String(origChars,0, slow);
    }

    public static void main(String[] args) {
        System.out.println(remove("aabbcdab", "ab"));
    }
}

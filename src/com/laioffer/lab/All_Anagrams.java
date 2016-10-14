package com.laioffer.lab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanan on 2016/10/14.
 */
public class All_Anagrams {

    public static List<Integer> allAnagrams(String s, String l) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || l == null || l.length() == 0 || s.length() > l.length()) {
            return result;
        }
        Map<Character, Integer> match = new HashMap<>();
        // Initiate the hashmap with the short string
        for (int i = 0; i < s.length(); i++) {
            if (match.get(s.charAt(i)) == null) {
                match.put(s.charAt(i), 1);
            } else {
                match.put(s.charAt(i), match.get(s.charAt(i)) + 1);
            }
        }

        int slow;
        int counter = 0;
        for (int fast = 0; fast < l.length(); fast++) {
            if (match.get(l.charAt(fast)) != null) {
                match.put(l.charAt(fast), match.get(l.charAt(fast)) - 1);
                if (match.get(l.charAt(fast)) == 0) {
                    counter++;
                }
            }
            if (fast >= s.length()) { // Moving the sliding window
                slow = fast - s.length();
                if (match.get(l.charAt(slow)) != null) {
                    match.put(l.charAt(slow), match.get(l.charAt(slow)) + 1);
                    if (match.get(l.charAt(slow)) == 1) {
                        counter--;
                    }
                }
            }
            if (counter == match.size()) { // Match all
                result.add(fast - s.length() + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(allAnagrams("aab", "ababacbbaac"));
    }
}

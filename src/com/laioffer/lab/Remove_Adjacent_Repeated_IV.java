package com.laioffer.lab;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Ruoyu on 2016/10/9.
 */
public class Remove_Adjacent_Repeated_IV {

    public static String deDup(String input) {
        if (input == null) {
            return null;
        }

        char[] chars = input.toCharArray();
        Deque<Character> stack = new LinkedList<>();
        int i = 0;

        while (i < chars.length) {
            if (stack.isEmpty() || chars[i] != stack.peekLast()) {
                stack.offerLast(chars[i]);
                i++;
            } else {
                while (i < chars.length && chars[i] == stack.peekLast()) {
                    i++;
                }
                stack.pollLast();
            }
        }

        StringBuffer result = new StringBuffer(stack.size());
        while (!stack.isEmpty()) {
//            result.insert(0, stack.pollLast());
            result.append(stack.pollFirst());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(deDup("abbbbaac"));
        System.out.println(deDup("aabccdc"));
    }
}

package com.laioffer.lab;

import java.util.*;

public class CommonNums {

    public static List<Integer> common1(List<Integer> A, List<Integer> B) {
        ArrayList result = new ArrayList<>();
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (Integer num : A) {
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            } else {
                hashMap.put(num, hashMap.get(num) + 1);
            }
        }

        for (Integer num : B) {
            if (hashMap.containsKey(num)) {
                result.add(num);
                hashMap.put(num, hashMap.get(num) - 1);
                if (hashMap.get(num) == 0) {
                    hashMap.remove(num);
                }
                if (hashMap.isEmpty()) {
                    break;
                }
            }
        }

        return result;
    }

    public static List<Integer> common2(List<Integer> A, List<Integer> B) {
        ArrayList result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < A.size() && j < B.size()) {
            if (A.get(i) < B.get(j)) {
                i++;
            } else if (A.get(i) > B.get(j)) {
                j++;
            } else {
                result.add(A.get(i));
                i++;
                j++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> A =  Arrays.asList(1, 1, 2, 2, 3);
        List<Integer> B =  Arrays.asList(1, 1, 2, 5, 6);
        System.out.println(Arrays.toString(common1(A, B).toArray()));
        System.out.println(Arrays.toString(common2(A, B).toArray()));
    }
}

package com.laioffer.lab;

import java.util.*;

public class TopKFrequent {
    public static String[] topKFrequent(String[] combo, int k) {
        if (combo == null || combo.length == 0 || k <= 0) {
            return new String[0];
        }

        // Build HashMap with <String, Frequency>
        Map<String, Integer> map = new HashMap<>();
        for (String words : combo) {
            if (!map.containsKey(words)) {
                map.put(words, 1);
            } else {
                map.put(words, map.get(words) + 1);
            }
        }

        // Build a minHeap with size k
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e1.getValue().compareTo(e2.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else if (entry.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }

        // Now all k elements in the minHeap are result;
        String[] result = new String[minHeap.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        String[] combo = new String[] {"a", "a", "b", "b", "b", "b", "c", "c", "c", "d"};
        System.out.println(Arrays.toString(topKFrequent(combo, 2)));
        System.out.println(Arrays.toString(topKFrequent(combo, 4)));
        System.out.println(Arrays.toString(topKFrequent(combo, 5)));
    }
}

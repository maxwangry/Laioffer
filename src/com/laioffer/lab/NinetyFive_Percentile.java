package com.laioffer.lab;

import java.util.List;

/**
 * Created by Ruoyu on 2016/11/9.
 */
public class NinetyFive_Percentile {

    public int percentile95(List<Integer> lengths) {
        if (lengths == null || lengths.size() == 0 || lengths.contains(null)) {
            throw new IllegalArgumentException("Not a valid input.");
        }
        double threshold = 0.05 * lengths.size();
        int[] bucket = new int[4097];
        for (Integer length : lengths) {
            bucket[length]++;
        }
        for (int i = 4096; i > 0; i--) {
            threshold -= bucket[i];
            if (threshold == 0) {
                return i - 1;
            } else if (threshold < 0) {
                return i;
            }
        }
        return -1;
    }
}

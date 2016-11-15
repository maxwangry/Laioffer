package com.laioffer.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ruoyu on 2016/11/10.
 */
public class Largest_And_Second_Largest {

    static class Cell {
        int value;
        List<Integer> hasCompared;

        Cell(int value) {
            this.value = value;
            this.hasCompared = new ArrayList<>();
        }
    }

    public static int[] largestAndSecond(int[] array) {
        int size = array.length;
        // Convert int to Cell
        Cell[] helper = new Cell[size];
        for (int i = 0; i < size; i++) {
            helper[i] = new Cell(array[i]);
        }

        while (size > 1) {
            for (int i = 0; i < size / 2; i++) {
                if (helper[i].value < helper[size - 1 - i].value) {
                    // add the smaller one into the larger one's list;
                    helper[size - 1 - i].hasCompared.add(helper[i].value);

                    // swap larger one to the left half of the helper array;
                    Cell temp = helper[i];
                    helper[i] = helper[size - 1 - i];
                    helper[size - 1 - i] = temp;
                } else {
                    helper[i].hasCompared.add(helper[size - 1 - i].value);
                }
            }
            size = (size + 1) / 2;
        }

        // Now the first element in the helper array is the result we want
        int secondLarge = Integer.MIN_VALUE;
        for (Integer value : helper[0].hasCompared) {
            secondLarge = Math.max(value, secondLarge);
        }

        return new int[]{helper[0].value, secondLarge};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(largestAndSecond(new int[]{2, 1, 5, 4, 3})));
    }
}

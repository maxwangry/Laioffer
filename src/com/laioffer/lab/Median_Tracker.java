package com.laioffer.lab;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by Ruoyu on 2016/11/9.
 */
public class Median_Tracker {

    PriorityQueue<Integer> larger;
    PriorityQueue<Integer> smaller;

    public Median_Tracker() {
        larger = new PriorityQueue<>();
        smaller = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void read(int value) {
        if (smaller.size() == larger.size()) {
            if (smaller.isEmpty() || value < larger.peek()) {
                smaller.offer(value);
            } else {
                larger.offer(value);
            }
        } else if (smaller.size() < larger.size()) {
            if (value < larger.peek()) {
                smaller.offer(value);
            } else {
                smaller.offer(larger.poll());
                larger.offer(value);
            }
        } else {
            if (value > smaller.peek()) {
                larger.offer(value);
            } else {
                larger.offer(smaller.poll());
                smaller.offer(value);
            }
        }
    }

    public Double median() {
        if (larger.isEmpty() && smaller.isEmpty()) {
            return null;
        } else if (larger.isEmpty()) {
            return Double.valueOf(smaller.peek());
        } else if (smaller.isEmpty()) {
            return Double.valueOf(larger.peek());
        }

        Double min = Double.valueOf(smaller.peek());
        Double max = Double.valueOf(larger.peek());
        if (larger.size() < smaller.size()) {
            return min;
        } else if (larger.size() > smaller.size()) {
            return max;
        } else {
            return (min + max) / 2.0;
        }
    }

    public static void main(String[] args) {
        Median_Tracker mt = new Median_Tracker();
//        mt.read(1);
//        mt.read(2);
        System.out.println(mt.median());
    }
}

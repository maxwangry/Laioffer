package com.laioffer.lab;

import java.util.Random;

/**
 * Created by Ruoyu on 2016/11/9.
 */
public class Reservoir_Sampling {

    private int counter;
    private Integer sample;

    public Reservoir_Sampling() {
        this.counter = 0;
        this.sample = null;
    }

    public void read(int value) {
        counter++;
        int prob = new Random().nextInt(counter);
        if (prob == 0) {
            sample = value;
        }
    }

    public Integer sample() {
        return sample;
    }
}

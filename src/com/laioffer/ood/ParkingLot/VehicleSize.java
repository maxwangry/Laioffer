package com.laioffer.ood.ParkingLot;

/**
 * Created by Ruoyu on 2016/11/2.
 */
public enum VehicleSize {

    Compact(1),
    Regular(2),
    Large(3);

    private final int size;

    VehicleSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}

package com.laioffer.ood.ParkingLot;

/**
 * Created by Ruoyu on 2016/11/2.
 */
public class Truck extends Vehicle {

    public Truck(String plateID) {
        super(plateID);
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.Large;
    }
}
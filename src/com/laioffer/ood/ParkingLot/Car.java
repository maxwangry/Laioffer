package com.laioffer.ood.ParkingLot;

/**
 * Created by Ruoyu on 2016/11/2.
 */
public class Car extends Vehicle {

    public Car(String plateID) {
        super(plateID);
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.Compact;
    }
}

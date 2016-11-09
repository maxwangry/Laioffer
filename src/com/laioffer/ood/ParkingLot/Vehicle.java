package com.laioffer.ood.ParkingLot;

/**
 * Created by Ruoyu on 2016/11/2.
 */
public abstract class Vehicle {

    public final String plateID;

    public Vehicle(String plateID) {
        this.plateID = plateID;
    }

    public String getPlateID() {
        return plateID;
    }

    public abstract VehicleSize getSize();
}

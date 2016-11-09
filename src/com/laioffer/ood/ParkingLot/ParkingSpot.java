package com.laioffer.ood.ParkingLot;

/**
 * Created by Ruoyu on 2016/11/2.
 */
class ParkingSpot {
    private final VehicleSize size;
    private Vehicle currentVehicle;
    private final int id;

    ParkingSpot(int id, VehicleSize size) {
        this.id = id;
        this.size = size;
        currentVehicle = null;
    }

    boolean fit(Vehicle vehicle) {
        if (currentVehicle == null) {
            // Check size
            return this.size.ordinal() >= vehicle.getSize().ordinal();
        }
        return false;
    }

    // Record a vehicle is parked in by updating the currentVehicle field
    ParkingSpot park(Vehicle vehicle) {
        currentVehicle = vehicle;
        return this;
    }

    void leave() {
        currentVehicle = null;
    }

    Vehicle getCurrentVehicle() {
        return currentVehicle;
    }

    int getId() {
        return id;
    }
}

package com.laioffer.ood.ParkingLot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ruoyu on 2016/11/2.
 */
class Level {
    private final List<ParkingSpot> spots;
    private final int id;

    Level(int levelID, int capacity) {
        this.id = levelID;
        ArrayList<ParkingSpot> temp = new ArrayList<>(capacity);
        // Initialize all the spots
        for (int i = 0; i < capacity; i++) {
            if (i < capacity / 4) {
                temp.add(new ParkingSpot(i + 1, VehicleSize.Compact));
            } else if (i < capacity * 3 / 4) {
                temp.add(new ParkingSpot(i + 1, VehicleSize.Regular));
            } else {
                temp.add(new ParkingSpot(i + 1, VehicleSize.Large));
            }
        }
        // Mute the spots
        spots = Collections.unmodifiableList(temp);
    }

    int getId() {
        return this.id;
    }

    boolean hasSpot(Vehicle vehicle) {
        for (ParkingSpot s : spots) {
            if (s.fit(vehicle)) {
                return true;
            }
        }
        return false;
    }

    ParkingSpot park(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.fit(vehicle)) {
                return spot.park(vehicle);
            }
        }
        return null;
    }
}

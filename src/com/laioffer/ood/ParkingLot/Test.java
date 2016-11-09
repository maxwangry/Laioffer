package com.laioffer.ood.ParkingLot;

import static java.lang.Thread.sleep;

/**
 * Created by Ruoyu on 2016/11/7.
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        ParkingLot parkingLot = new ParkingLot(10, 2, 10);
        Car car = new Car("CA1");
        Truck truck = new Truck("CA2");

        parkingLot.hasSpot(car);
        parkingLot.hasSpot(truck);

        ParkingTicket ticket1 = parkingLot.park(car);
        ParkingTicket ticket2 = parkingLot.park(truck);

        sleep(1000 * 100);

        parkingLot.leave(ticket1, 100);
        parkingLot.leave(ticket2, 2);
    }
}

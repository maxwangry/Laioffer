package com.laioffer.ood.ParkingLot;

import java.time.LocalTime;
import java.util.HashMap;

import static java.time.temporal.ChronoUnit.MINUTES;

/**
 * Created by Ruoyu on 2016/11/2.
 */
public class ParkingLot {
    private final Level[] levels;
    private final int RATE;
    private final HashMap<String, ParkingSpot> map;

    public ParkingLot(int rate, int totalLevel, int eachLevel) {
        levels = new Level[totalLevel];
        RATE = rate;
        map = new HashMap<>();

        // Initialize each level
        for (int i = 0; i < levels.length; i++) {
            levels[i] = new Level(i, eachLevel);
        }
    }

    public boolean hasSpot(Vehicle vehicle) {
        for (Level l : levels) {
            if (l.hasSpot(vehicle)) {
                System.out.println("Cool, We have a spot for you!");
                return true;
            }
        }
        System.out.println("Oops, Currently we don't have a spot for you. Please come back later!");
        return false;
    }

    public ParkingTicket park(Vehicle vehicle) {
        for (Level level : levels) {
            ParkingSpot spot = level.park(vehicle);
            if (spot != null) {
                map.put(vehicle.getPlateID(), spot);
                ParkingTicket ticket = new ParkingTicket(level.getId(), spot.getId(), vehicle.getPlateID(), LocalTime.now());
                showTicket(ticket);
                return ticket;
            }
        }
        return null;
    }

    public boolean leave(ParkingTicket ticket, double payment) {
        ParkingSpot spot = map.get(ticket.getPlateID());
        if (spot != null) {
            ticket.setLeaveTime(LocalTime.now());
            ticket.setPaid(payTicket(feeCalculator(ticket), payment));
            showTicket(ticket);
            if (ticket.isPaid()) {
                map.remove(ticket.getPlateID());
                spot.leave();
                return true;
            }
        }
        showTicket(ticket);
        return false;
    }

    private double feeCalculator(ParkingTicket ticket) {
        long period = ticket.getEnterTime().until(ticket.getLeaveTime(), MINUTES);
        int hour = period < 60 ? 1 : (int) Math.ceil(period / 60);
        int cost = RATE * hour;
        System.out.println("Dear Customer, your total cost is: " + cost);
        return cost;
    }

    private boolean payTicket(double fee, double payment) {
        return payment >= fee;
    }

    public void showTicket(ParkingTicket ticket) {
        System.out.println("Plate ID: " + ticket.getPlateID() + "; Level#: " + ticket.getLevelID() + "; Spot#: " + ticket.getSpotID() + "; Enter Time: " + ticket.getEnterTime() + "; Leave Time: " + ticket.getLeaveTime() + "; Pay Status: " + ticket.isPaid());
    }
}

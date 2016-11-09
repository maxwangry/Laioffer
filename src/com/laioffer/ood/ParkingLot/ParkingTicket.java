package com.laioffer.ood.ParkingLot;

import java.time.LocalTime;

/**
 * Created by Ruoyu on 2016/11/2.
 */
public class ParkingTicket {
    private final LocalTime enterTime;
    private LocalTime leaveTime;
    private final int levelID;
    private final int spotID;
    private final String plateID;
    private boolean isPaid;

    public ParkingTicket(int levelID, int spotID, String plateID, LocalTime enterTime) {
        this.levelID = levelID;
        this.enterTime = enterTime;
        this.spotID = spotID;
        this.plateID = plateID;
        isPaid = false;
    }

    public LocalTime getEnterTime() {
        return enterTime;
    }

    public LocalTime getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(LocalTime leaveTime) {
        this.leaveTime = leaveTime;
    }

    public int getSpotID() {
        return spotID;
    }

    public String getPlateID() {
        return plateID;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public int getLevelID() {
        return levelID;
    }
}

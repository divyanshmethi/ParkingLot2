package org.parkinglot.model;

import java.util.Date;

public class Ticket {
    public Date getEntryTime() {
        return entryTime;
    }
    private final Date entryTime;

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    private final ParkingSpot parkingSpot;

    public Vehicle getVehicle() {
        return vehicle;
    }

    private final Vehicle vehicle;

    public Ticket(ParkingSpot parkingSpot, Vehicle vehicle) {
        this.entryTime = new Date();
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "entryTime=" + entryTime +
                ", parkingSpot=" + parkingSpot.toString() +
                ", vehicle=" + vehicle.toString() +
                '}';
    }
}

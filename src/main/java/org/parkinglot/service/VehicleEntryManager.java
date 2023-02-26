package org.parkinglot.service;

import org.parkinglot.model.*;

public class VehicleEntryManager {
    private final ParkingSpotManager parkingSpotManager;
    public VehicleEntryManager(final VehicleType vehicleType) {
        ParkingManagerFactory parkingManagerFactory = new ParkingManagerFactory();
        parkingSpotManager = parkingManagerFactory.getParkingManager(vehicleType);
    }
    public Ticket bookParkingSpace(final int gateNumber, final Vehicle vehicle) {
        ParkingSpot parkingSpot = parkingSpotManager.allotSlotToVehicle(gateNumber,vehicle);
        return generateTicket(parkingSpot,vehicle);
    }
    private Ticket generateTicket(final ParkingSpot parkingSpot, final Vehicle vehicle) {
        return new Ticket(parkingSpot,vehicle);
    }
}

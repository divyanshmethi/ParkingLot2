package org.parkinglot.service;

import org.parkinglot.model.Ticket;
import org.parkinglot.strategy.pricingStrategy.IPricingStrategy;
import org.parkinglot.strategy.pricingStrategy.PricingStrategyHourly;

public class VehicleExitManager {
    final Ticket ticket;
    final IPricingStrategy pricingStrategy;
    final ParkingSpotManager parkingSpotManager;
    public VehicleExitManager(final Ticket ticket) {
        this.ticket = ticket;
        this.pricingStrategy = new PricingStrategyHourly();
        try {
            parkingSpotManager = new ParkingManagerFactory().getParkingManager(ticket.getVehicle().getVehicleType());
        } catch (NullPointerException e) {
            throw new RuntimeException("No vehicle inside the ticket");
        }
    }
    public double calculatePrice() {
        return this.pricingStrategy.getFinalPrice(ticket);
    }
    public void removeVehicle() {
        this.parkingSpotManager.deallocateSlot(ticket.getParkingSpot());
    }
}

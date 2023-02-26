package org.parkinglot.strategy.pricingStrategy;

import org.parkinglot.model.Ticket;

import java.util.Date;

public class PricingStrategyHourly implements IPricingStrategy{
    @Override
    public double getFinalPrice(Ticket ticket) {
        Date currentTime = new Date();
        long mills = currentTime.getTime() - ticket.getEntryTime().getTime();
        long hours = mills / (1000 * 60 * 60);
        if(ticket.getParkingSpot() != null)
            return hours * ticket.getParkingSpot().getPrice();
        else
            return hours * 15;
    }
}

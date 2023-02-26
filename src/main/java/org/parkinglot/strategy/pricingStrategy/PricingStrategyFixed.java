package org.parkinglot.strategy.pricingStrategy;

import org.parkinglot.model.Ticket;

public class PricingStrategyFixed implements IPricingStrategy{
    @Override
    public double getFinalPrice(Ticket ticket) {
        if(ticket.getParkingSpot() != null)
            return ticket.getParkingSpot().getPrice();
        else
            return 15;
    }
}

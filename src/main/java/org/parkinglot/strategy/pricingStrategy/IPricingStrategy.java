package org.parkinglot.strategy.pricingStrategy;

import org.parkinglot.model.Ticket;

public interface IPricingStrategy {
    double getFinalPrice(Ticket ticket);
}

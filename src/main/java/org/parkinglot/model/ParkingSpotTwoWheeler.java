package org.parkinglot.model;

import org.parkinglot.utils.IdGenerator;

public class ParkingSpotTwoWheeler extends ParkingSpot{
    private static final int TWO_WHEELER_PRICE = 20;
    public ParkingSpotTwoWheeler() {
        super(IdGenerator.getID(),TWO_WHEELER_PRICE);
    }
}

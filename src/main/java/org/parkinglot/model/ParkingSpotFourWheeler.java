package org.parkinglot.model;

import org.parkinglot.utils.IdGenerator;

public class ParkingSpotFourWheeler extends ParkingSpot{
    private static final int FOUR_WHEELER_PRICE = 40;
    public ParkingSpotFourWheeler() {
        super(IdGenerator.getID(), FOUR_WHEELER_PRICE);
    }
}

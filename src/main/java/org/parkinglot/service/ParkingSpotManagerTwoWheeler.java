package org.parkinglot.service;

import org.parkinglot.model.ParkingSpot;
import org.parkinglot.strategy.parkingStrategy.IParkingStrategy;
import org.parkinglot.strategy.parkingStrategy.ParkingStrategyNearEntrance;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotManagerTwoWheeler extends ParkingSpotManager {
    private static ParkingSpotManager pmTwoWheeler;
    public static ParkingSpotManager getInstance() {
        if (pmTwoWheeler == null) {
            List<ParkingSpot> parkingSpots = new ArrayList<>();
            //Todo: Change the strategy here
            IParkingStrategy parkingStrategy = new ParkingStrategyNearEntrance();
            pmTwoWheeler = new ParkingSpotManager(parkingSpots,parkingStrategy);
        }
        return pmTwoWheeler;
    }
    private ParkingSpotManagerTwoWheeler() {
        super();
    }
}

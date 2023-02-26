package org.parkinglot.service;

import org.parkinglot.model.ParkingSpot;
import org.parkinglot.strategy.parkingStrategy.IParkingStrategy;
import org.parkinglot.strategy.parkingStrategy.ParkingStrategyNearEntrance;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotManagerFourWheeler extends ParkingSpotManager{
    private static ParkingSpotManager pmFourWheeler;
    private ParkingSpotManagerFourWheeler() {
        super();
    }
    public static ParkingSpotManager getInstance() {
        if(pmFourWheeler == null) {
            List<ParkingSpot> parkingSpots = new ArrayList<>();
            //Todo: Can Change the strategy here
            IParkingStrategy parkingStrategy = new ParkingStrategyNearEntrance();
            pmFourWheeler = new ParkingSpotManager(parkingSpots,parkingStrategy);
        }
        return pmFourWheeler;
    }
}

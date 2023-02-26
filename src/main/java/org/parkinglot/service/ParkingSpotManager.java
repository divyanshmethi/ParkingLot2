package org.parkinglot.service;

import org.parkinglot.exception.InvalidVehicleTypeException;
import org.parkinglot.model.ParkingSpot;
import org.parkinglot.model.ParkingSpotFourWheeler;
import org.parkinglot.model.ParkingSpotTwoWheeler;
import org.parkinglot.model.Vehicle;
import org.parkinglot.strategy.parkingStrategy.IParkingStrategy;
import org.parkinglot.strategy.parkingStrategy.ParkingStrategyNearEntrance;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ParkingSpotManager {
    private final List<ParkingSpot> parkingSpots;
    private final IParkingStrategy parkingStrategy;
    public ParkingSpotManager(final List<ParkingSpot> parkingSpots,final IParkingStrategy parkingStrategy) {
        this.parkingSpots = parkingSpots;
        this.parkingStrategy = parkingStrategy;
    }
    public ParkingSpotManager() {
        this.parkingSpots = new ArrayList<>();
        this.parkingStrategy = new ParkingStrategyNearEntrance();
    }
    public void addParkingSpot(final ParkingSpot ps) {
        this.parkingSpots.add(ps);
        this.parkingStrategy.addSlot(ps.getId());
    }
    public void removeParkingSpot(final ParkingSpot ps) {
        this.parkingSpots.remove(ps);
        this.parkingStrategy.removeSlot(ps.getId());
    }
    //Todo: Also think about multiple entrances/gates
    public ParkingSpot allotSlotToVehicle(int gateNumber, Vehicle vehicle) {
        Integer id = this.parkingStrategy.getSlot();
        ParkingSpot parkingSpot;
        switch (vehicle.getVehicleType()) {
            case TWO_WHEELER: parkingSpot = new ParkingSpotTwoWheeler();
            break;
            case FOUR_WHEELER: parkingSpot = new ParkingSpotFourWheeler();
            break;
            default: throw new InvalidVehicleTypeException();
        }
        System.out.println(id);
        for(int i = 0;i<this.parkingSpots.size();i++) {
            if(Objects.equals(parkingSpot.getId(), id)) {
                this.parkingSpots.get(i).parkVehicle(vehicle);
            }
        }
        return parkingSpot;
    }
    public void deallocateSlot(ParkingSpot spot) {
        for(ParkingSpot parkingSpot : parkingSpots) {
            if(Objects.equals(parkingSpot.getId(), spot.getId())) {
                parkingSpot.removeVehicle();
            }
        }
    }
}

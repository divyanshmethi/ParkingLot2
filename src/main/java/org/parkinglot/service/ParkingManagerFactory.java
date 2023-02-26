package org.parkinglot.service;

import org.parkinglot.exception.InvalidVehicleTypeException;
import org.parkinglot.model.VehicleType;

public class ParkingManagerFactory {
    public ParkingSpotManager getParkingManager(VehicleType vehicleType) {
        switch (vehicleType) {
            case TWO_WHEELER: return ParkingSpotManagerTwoWheeler.getInstance();
            case FOUR_WHEELER: return ParkingSpotManagerFourWheeler.getInstance();
            //Can be extended to more vehicle types here
            default: throw new InvalidVehicleTypeException();
        }
    }
}

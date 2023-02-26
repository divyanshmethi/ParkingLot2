package org.parkinglot.model;

public class Vehicle {
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    private final String vehicleNumber;

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    private final VehicleType vehicleType;
    public Vehicle(final String vehicleNumber,final VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }
}

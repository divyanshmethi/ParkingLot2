package org.parkinglot.exception;

public class InvalidVehicleTypeException extends RuntimeException{
    public InvalidVehicleTypeException() {
        super("Invalid Vehicle Type, only two wheeler and four wheeler supported");
    }
}

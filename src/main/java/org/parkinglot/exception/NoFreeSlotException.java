package org.parkinglot.exception;

public class NoFreeSlotException extends RuntimeException{
    public NoFreeSlotException() {
        super("No Free slots available to fill. Please try at a later time.");
    }
}

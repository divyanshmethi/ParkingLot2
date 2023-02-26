package org.parkinglot.strategy.parkingStrategy;

public interface IParkingStrategy {
    void addSlot(int index);
    void removeSlot(int index);
    Integer getSlot();
}

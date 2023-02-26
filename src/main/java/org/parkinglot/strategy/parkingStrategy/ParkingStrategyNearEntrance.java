package org.parkinglot.strategy.parkingStrategy;

import org.parkinglot.exception.NoFreeSlotException;

import java.util.TreeSet;

public class ParkingStrategyNearEntrance implements IParkingStrategy{
    TreeSet<Integer> treeSet;
    public ParkingStrategyNearEntrance() {
        this.treeSet = new TreeSet<>();
    }
    @Override
    public void addSlot(int index) {
        this.treeSet.add(index);
    }

    @Override
    public void removeSlot(int index) {
        this.treeSet.remove(index);
    }

    @Override
    public Integer getSlot() {
        if(this.treeSet.isEmpty()) {
            throw new NoFreeSlotException();
        }
        return this.treeSet.first();
    }
}

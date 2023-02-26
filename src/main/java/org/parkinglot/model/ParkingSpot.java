package org.parkinglot.model;

import org.parkinglot.utils.IdGenerator;

public class ParkingSpot {
    public Integer getId() {
        return id;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    private final Integer id;
    private boolean isEmpty;
    private Vehicle vehicle;

    public int getPrice() {
        return price;
    }

    private final int price;
    public ParkingSpot() {
        this.id = IdGenerator.getID();
        this.vehicle = null;
        this.isEmpty = true;
        this.price = 10;
    }
    public ParkingSpot(final int id, final int price) {
        this.id = IdGenerator.getID();
        this.price = price;
        this.vehicle = null;
        this.isEmpty = true;
    }
    public void parkVehicle(final Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isEmpty = false;
    }
    public void removeVehicle() {
        this.vehicle = null;
        this.isEmpty = true;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "id=" + id +
                '}';
    }
}

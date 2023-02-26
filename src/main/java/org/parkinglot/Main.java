package org.parkinglot;

import org.parkinglot.model.*;
import org.parkinglot.service.ParkingManagerFactory;
import org.parkinglot.service.ParkingSpotManager;
import org.parkinglot.service.VehicleEntryManager;
import org.parkinglot.service.VehicleExitManager;

import java.util.Scanner;

public class Main {
    private static void addSlotsInParking() {
        ParkingManagerFactory parkingManagerFactory = new ParkingManagerFactory();
        ParkingSpotManager parkingSpotManagerTwoWheeler = parkingManagerFactory.getParkingManager(VehicleType.TWO_WHEELER);
        ParkingSpotManager parkingSpotManagerFourWheeler = parkingManagerFactory.getParkingManager(VehicleType.FOUR_WHEELER);
        for(int i = 0;i<4;i++) {
            ParkingSpot ps = new ParkingSpotTwoWheeler();
            parkingSpotManagerTwoWheeler.addParkingSpot(ps);
        }
        for(int i = 0;i<2;i++) {
            ParkingSpot ps = new ParkingSpotFourWheeler();
            parkingSpotManagerFourWheeler.addParkingSpot(ps);
        }
    }
    public static void main(String[] args) {
        addSlotsInParking();
        System.out.println("Welcome to ABC parking lot!");
        System.out.println("Please enter the following details of your vehicle : ");
        Scanner sc = new Scanner(System.in);
        int wheels = 0;
        String vehicleNumber;
        do {
            System.out.print("(Press Enter to exit) Vehicle number : ");
            vehicleNumber = sc.nextLine();
            if(vehicleNumber.isEmpty()) {
                return;
            }
            System.out.print("(Press 0 to exit) Number of wheels (2 or 4) : ");
            wheels = sc.nextInt();
            if(wheels == 0){
                return;
            }
            if(wheels != 2 && wheels != 4) {
                System.out.println("Invalid number of wheels. Please try again.");
            }
        } while(wheels != 2 && wheels != 4);
        VehicleType vehicleType = VehicleType.TWO_WHEELER;
        if(wheels == 4) {
            vehicleType = VehicleType.FOUR_WHEELER;
        }
        Vehicle vehicle = new Vehicle(vehicleNumber,vehicleType);
        VehicleEntryManager vehicleEntryManager = new VehicleEntryManager(vehicleType);
        Ticket ticket = vehicleEntryManager.bookParkingSpace(1,vehicle);
        System.out.println("Here's your ticket");
        System.out.println(ticket);
        VehicleExitManager vehicleExitManager = new VehicleExitManager(ticket);
        System.out.print("You need to pay : ");
        System.out.println(vehicleExitManager.calculatePrice());
        vehicleExitManager.removeVehicle();
        System.out.println();
    }
}
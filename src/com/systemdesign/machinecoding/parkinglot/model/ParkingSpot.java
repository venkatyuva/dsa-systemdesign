package com.systemdesign.machinecoding.parkinglot.model;

import com.systemdesign.machinecoding.parkinglot.enums.ParkingSpotStatus;
import com.systemdesign.machinecoding.parkinglot.enums.VehicleType;

import java.util.List;

public class ParkingSpot extends BaseEntity {
    private List<VehicleType> vehicleType;

    private ParkingSpotStatus parkingSpotStatus;

    private ParkingFloor parkingFloor;

    private int spotNumber;

    public List<VehicleType> getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(List<VehicleType> vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }
}

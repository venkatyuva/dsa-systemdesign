package com.systemdesign.machinecoding.parkinglot.model;

import com.systemdesign.machinecoding.parkinglot.enums.ParkingLotStatus;

import java.util.List;

public class ParkingLot extends BaseEntity {
    private List<ParkingFloor> parkingFloors;

    private List<Gate> gates;

    private ParkingLotStatus parkingLotStatus;

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }
}

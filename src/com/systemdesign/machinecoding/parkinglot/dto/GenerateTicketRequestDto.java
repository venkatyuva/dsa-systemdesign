package com.systemdesign.machinecoding.parkinglot.dto;

import com.systemdesign.machinecoding.parkinglot.enums.VehicleType;

public class GenerateTicketRequestDto {

    private String vehicleNumber;

    private VehicleType vehicleType;

    private String gateNumber;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(String gateNumber) {
        this.gateNumber = gateNumber;
    }
}

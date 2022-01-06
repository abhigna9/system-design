package com.design.example.model;

public enum VehicleEnum {
    CAR(50),
    BIKE(20);

    int pricePerHour;

    VehicleEnum(int price){
        this.pricePerHour = price;
    }

    public int getCostPerHour(){
        return pricePerHour;
    }
}

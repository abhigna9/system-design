package com.design.example.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
public class ParkingLot {
    //private int availableSpots;
    private boolean occupiedSpots[][];
    private List<Vehicle> vehicles;
    private int ROWS = 10;
    private int COLUMNS = 3;
    public ParkingLot(){
        this.occupiedSpots = new boolean[ROWS][COLUMNS];
    }
}

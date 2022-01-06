package com.design.example.service;

import com.design.example.helper.VehicleFactory;
import com.design.example.model.ParkingLot;
import com.design.example.model.Vehicle;
import com.design.example.model.VehicleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ParkingService {

    @Autowired
    private VehicleFactory vehicleFactory;

    public int printSpots(String vehicle){
        int spots;
        Vehicle v = vehicleFactory.getVehicle(vehicle);
        spots = v.getSpots();
        log.info("Occupies {} spots", spots);
        return spots;
    }

    private boolean fitVehicle(boolean[][] spotsOccupied, int row, int column, int space){
        for(int i=row;i<row+space-1;i++){
            if(spotsOccupied[i][column]){
                return false;
            }
        }
        return true;
    }

    private boolean parkingSpotAvailable(Vehicle vehicle){
        // matrix check logic goes in here
        ParkingLot parking = new ParkingLot();
        int spaceRequired = vehicle.getSpots();
        boolean[][] spots = parking.getOccupiedSpots();
        for(int i=0;i<parking.getROWS()-spaceRequired+1;i++){
            for(int j=0;j<parking.getCOLUMNS();j++){
                if(!spots[i][j] && fitVehicle(spots, i, j, spaceRequired)){
                    return true;
                }
            }
        }
        return false;
    }

    public String recordEntry(String vehicle, int entryTime){
        Vehicle v = vehicleFactory.getVehicle(vehicle);
        if(parkingSpotAvailable(v)){
            v.setEntryTime(entryTime);
            log.info("Recorded entry time as {}", entryTime);
            return "entry successful";
        }
        else
            return "Parking lot full";
//        parkingSpotAvailable(vehicle);
    }

    private int calculateTotalCost(String vehicle, int hours){
        return VehicleEnum.valueOf(vehicle.toUpperCase()).getCostPerHour() * hours;
    }

    public String recordExit(String vehicle, int exitTime){
        // empty the spot in parking lot --> reassign the matrix // to be done after db
        int cost = calculateTotalCost(vehicle,exitTime);
        log.info("parking cost of {} is {}", vehicle, cost);
        return "Exited";
    }
}

package com.design.example.controller;

import com.design.example.service.ParkingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ParkingLotController {

    @Autowired
    private ParkingService parkingService;

    @GetMapping(path="/getSpots/{vehicle}", produces = MediaType.APPLICATION_JSON_VALUE)
    public int getParkingSpots(@PathVariable final String vehicle) {
        return parkingService.printSpots(vehicle);
    }

    @PostMapping(path="/recordEntry/{vehicle}/{entryTime}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void recordEntry(@PathVariable final String vehicle, @PathVariable final int entryTime){
        parkingService.recordEntry(vehicle, entryTime);
    }

    @GetMapping(path="/exit/{vehicle}/{exitTime}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String recordExit(@PathVariable final String vehicle, @PathVariable final int exitTime){
        return parkingService.recordExit(vehicle, exitTime);
    }
}

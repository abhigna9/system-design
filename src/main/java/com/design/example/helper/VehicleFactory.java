package com.design.example.helper;

import com.design.example.model.Bike;
import com.design.example.model.Car;
import com.design.example.model.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleFactory {

    public Vehicle getVehicle(String vehicleType){
        if(vehicleType.equalsIgnoreCase("car"))
            return new Car();
        else if(vehicleType.equalsIgnoreCase("bike"))
            return new Bike();
        else
            return null;
    }
}

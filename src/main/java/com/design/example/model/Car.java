package com.design.example.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
public class Car extends Vehicle {

    public int spots;

    public Car(){
        this.spots=4;
    }
}

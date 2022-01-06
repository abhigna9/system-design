package com.design.example.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Component
public class Bike extends Vehicle{

    private int spots;

    public Bike(){
        this.spots=1;
    }
}

package com.ateam.entity;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Simulation {
    private City city;
    private List<Vehicle> vehicles;
    private Integer bonus;
    private Integer steps;
    private List<Ride> rides;

    public Simulation(City city, int numOfVehicles, int bonus, Integer steps, List<Ride> rides) {
        this.city = city;
        this.vehicles = initVehicles(numOfVehicles);
        this.bonus = bonus;
        this.steps = steps;
        this.rides = rides;
    }

    private List<Vehicle> initVehicles(int num) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            vehicles.add(new Vehicle());
        }

        return vehicles;
    }
}

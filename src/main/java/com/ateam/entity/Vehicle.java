package com.ateam.entity;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.List;

@Setter
@Getter
public class Vehicle {
    private static Integer ID = 0;
    private Integer id;
    private Point currentPos;
    private Ride currRide;
    private List<Ride> rides;

    public Vehicle() {
        currentPos = new Point(0, 0);
        id = ID++;
    }

    public String getRidesAsString() {
        StringBuilder b = new StringBuilder();
        for (Ride r : rides) {
            b.append(r.getId()).append(" ");
        }
        return b.toString();
    }
}

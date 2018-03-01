package com.ateam.entity;

import java.awt.*;
import java.util.List;

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
}

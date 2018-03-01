package com.ateam.entity;

import java.awt.*;

public class Vehicle {
    private static Integer ID = 0;
    private Integer id;
    private Point currentPos;
    private Ride ride;

    public Vehicle() {
        currentPos = new Point(0, 0);
        id = ID++;
    }
}

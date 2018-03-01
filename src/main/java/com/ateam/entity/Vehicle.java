package com.ateam.entity;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Vehicle {
    private static Integer ID = 0;
    private Integer id;
    private Point currentPos;
    private Ride currRide;
    private List<Ride> rides;
    private Integer timeInRoad;

    public Vehicle() {
        currentPos = new Point(0, 0);
        id = ID++;
        rides = new ArrayList<>();
    }

    public String getRidesAsString() {
        StringBuilder b = new StringBuilder();
        for (Ride r : rides) {
            b.append(r.getId()).append(" ");
        }
        return b.toString();
    }

    public void assignRide(Ride ride) {
        this.currRide = ride;
        rides.add(ride);
    }

    public void executeRide(Integer currentStep) {
        if (currRide == null) {
            throw new RuntimeException("Current ride is null val.");
        }

        Integer time1 = calculateDistance(currentPos, currRide.getStart());
        Integer waitingTime = waitForExecution(currRide.getEarliestStart(), currentStep);
        Integer time2 = calculateDistance(currRide.getStart(), currRide.getFinish());

        timeInRoad = time1 + waitingTime + time2;

        // move
        timeInRoad--;
        currentPos = currRide.getFinish();
//        currRide = null;
    }

    private Integer waitForExecution(Integer earliestStart, Integer currStep) {
        Integer diff = earliestStart - currStep;
        return diff > 0 ? diff : 0;
    }

    private Integer calculateDistance(Point p1, Point p2) {
        double time = Math.abs(p1.getX() - p2.getX()) + Math.abs(p1.getY() - p2.getY());

        return (int) time;
    }

    public boolean isAvailable() {
        boolean isAvailable = true;
        if (timeInRoad != null) {
            isAvailable = timeInRoad <= 0;
            timeInRoad--;
        }
        return currRide == null || isAvailable;
    }
}

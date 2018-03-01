package com.ateam.algo;

import com.ateam.entity.Candidate;
import com.ateam.entity.Ride;
import com.ateam.entity.Simulation;
import com.ateam.entity.Vehicle;

import java.awt.*;
import java.util.*;
import java.util.List;

public class DummyAlgorithm {
    public Candidate calculate(Simulation simulation) {

        Queue<Vehicle> loadedVehicles = new ArrayDeque<>();
        List<Ride> rides = simulation.getRides();
        sort(rides);
        List<Vehicle> allVehicles = simulation.getVehicles();
        for (int i = 0; i < simulation.getSteps(); i++) {
//            if (loadedVehicles.size() == allVehicles.size()) {
//                continue;
//            }

            for (Vehicle v : allVehicles) {
                if (v.isAvailable()) {
                    // find more nearest..

                    if (!rides.isEmpty()) {
                        v.assignRide(getNearest(rides, v));
                        loadedVehicles.add(v);
                        v.executeRide(i); // will get 10 time units
                    } else {
                        break;
                        // keep results..
                    }
                } else {
                    // free
                }
            }
        }


        return new Candidate(allVehicles);
    }

    private Ride getNearest(List<Ride> rides, Vehicle vehicle) {
        Point pos = vehicle.getCurrentPos();
        Integer minDist = Integer.MAX_VALUE;
        int nearest = 0;
        for (int i = 0; i < Math.min(rides.size(), 20); i++) {
            Point start = rides.get(i).getStart();
            Integer distance = Math.abs(start.x - pos.x) + Math.abs(start.y - pos.y);
            if (distance < minDist) {
                minDist = distance;
                nearest = i;
            }
        }

        return rides.remove(nearest);
    }

    private void sort(List<Ride> rides) {
        rides.sort((o1, o2) -> {
            int es = 10 * (o1.getEarliestStart() - o2.getEarliestStart());

            int d = 4 * (int) (Math.abs(o1.getStart().x - o1.getFinish().x) + Math.abs(o1.getStart().getY() - o1.getFinish().y));
            int d2 = 4 * (int) (Math.abs(o2.getStart().x - o2.getFinish().x) + Math.abs(o2.getStart().getY() - o2.getFinish().y));

            int t1 = o1.getLatestFinish() - o1.getEarliestStart();
            int t2 = o2.getLatestFinish() - o2.getEarliestStart();

            int td = -(t2 - t1) * 1;
            int dd = (d2 - d) * 4;

            int r = td + dd + es;

            if (r < 0) {
                return 1;
            } else {
                return -1;
            }
        });
    }
}

package com.ateam.parser;

import com.ateam.entity.Ride;
import com.ateam.entity.Simulation;
import com.ateam.entity.City;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InputDataParser {
    public Simulation parseInData(String filename) {
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String[] firstLine = reader.readLine().split(" ");

            Integer rows = Integer.valueOf(firstLine[0]);
            Integer cols = Integer.valueOf(firstLine[1]);
            Integer vehicles = Integer.valueOf(firstLine[2]);
//            Integer rides = Integer.valueOf(firstLine[3]);
            Integer bonus = Integer.valueOf(firstLine[4]);
            Integer steps = Integer.valueOf(firstLine[5]);

            String line;
            List<Ride> rideList = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                Point start = new Point(Integer.valueOf(parts[0]), Integer.valueOf(parts[1]));
                Point finish = new Point(Integer.valueOf(parts[2]), Integer.valueOf(parts[3]));
                Integer earlStart = Integer.valueOf(parts[4]);
                Integer latestFinish = Integer.valueOf(parts[5]);

                Ride r = new Ride(start, finish, earlStart, latestFinish);
                rideList.add(r);
            }

            return new Simulation(new City(rows, cols), vehicles, bonus, steps, rideList);

        } catch (IOException e) {
            System.err.println("Could parse in data. " + e.getMessage());
        }

        return null;
    }
}

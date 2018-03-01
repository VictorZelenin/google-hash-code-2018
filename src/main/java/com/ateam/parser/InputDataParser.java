package com.ateam.parser;

import com.ateam.entity.Simulation;
import com.ateam.entity.City;

import java.io.*;

public class InputDataParser {
    public Simulation parseInData(String filename) {
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String[] firstLine = reader.readLine().split(" ");

            Integer rows = Integer.valueOf(firstLine[0]);
            Integer cols = Integer.valueOf(firstLine[1]);
            Integer vehicles = Integer.valueOf(firstLine[2]);
            Integer rides = Integer.valueOf(firstLine[3]);
            Integer bonus = Integer.valueOf(firstLine[4]);
            Integer steps = Integer.valueOf(firstLine[5]);

            Simulation simulation = new Simulation(new City(rows, cols), vehicles, )

//            while ((line = reader.readLine()) != null) {
//
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

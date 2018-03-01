package com.ateam;

import com.ateam.entity.Candidate;
import com.ateam.entity.Vehicle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    private Utils() {
    }

    public static void writeResults(Candidate finalCandidate, String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            for (Vehicle v : finalCandidate.getVehicles()) {
                writer.write(v.getRides().size() + " ");
                writer.write(v.getRidesAsString());
                writer.write("\n");
            }
            writer.flush();


        } catch (IOException e) {
            System.err.println("Couldnot write results to file. " + e.getMessage());
        }
    }
}

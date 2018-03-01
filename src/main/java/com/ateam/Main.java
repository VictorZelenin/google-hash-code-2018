package com.ateam;

import com.ateam.algo.DummyAlgorithm;
import com.ateam.entity.Candidate;
import com.ateam.entity.Simulation;
import com.ateam.parser.InputDataParser;

public class Main {

    public static void main(String[] args) {
        InputDataParser parser = new InputDataParser();
        Simulation simulation = parser.parseInData("a_example.in");

        DummyAlgorithm algorithm = new DummyAlgorithm();

        Candidate finalCandidate = algorithm.calculate(simulation);

        Utils.writeResults(finalCandidate, "res4.out");
    }
}
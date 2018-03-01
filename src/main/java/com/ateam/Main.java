package com.ateam;

import com.ateam.entity.Simulation;
import com.ateam.parser.InputDataParser;

public class Main {

    public static void main(String[] args) {
        InputDataParser parser = new InputDataParser();
        Simulation simulation = parser.parseInData("a_example.in");

        System.out.println(simulation);
    }
}
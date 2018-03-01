package com.ateam.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Candidate {
    private List<Vehicle> vehicles;
}

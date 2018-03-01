package com.ateam.entity;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class City {
    private List<List<Integer>> city;

    public City(int rows, int cols) {
        city = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            List<Integer> list = new ArrayList<>();

            city.add(list);
            for (int j = 0; j < cols; j++) {
                list.add(i + j);
            }
        }
    }
}

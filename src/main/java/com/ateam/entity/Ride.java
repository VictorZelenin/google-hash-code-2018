package com.ateam.entity;

import lombok.Getter;

import java.awt.*;

@Getter
public class Ride {
    private static Integer ID = 0;
    private Integer id;
    private final Point start;
    private final Point finish;

    private final Integer earliestStart;
    private final Integer latestFinish;

    public Ride(Point start, Point finish, Integer earliestStart, Integer latestFinish) {
        this.id = ID++;
        this.start = start;
        this.finish = finish;
        this.earliestStart = earliestStart;
        this.latestFinish = latestFinish;
    }
}

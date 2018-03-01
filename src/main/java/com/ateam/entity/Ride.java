package com.ateam.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.*;

@AllArgsConstructor
@Getter
public class Ride {
    private final Point start;
    private final Point finish;

    private final Integer earliestStart;
    private final Integer latestFinish;

}

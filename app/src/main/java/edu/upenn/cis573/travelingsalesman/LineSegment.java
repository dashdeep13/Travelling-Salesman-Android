package edu.upenn.cis573.travelingsalesman;

import android.graphics.Color;
import android.graphics.Point;

import java.util.ArrayList;


public class LineSegment {


    public Point start;
    public Point end;

    public LineSegment() {

    }

    public static double distance(Point start,Point end) {
        double dx = start.x - end.x;
        double dy = start.y - end.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

}

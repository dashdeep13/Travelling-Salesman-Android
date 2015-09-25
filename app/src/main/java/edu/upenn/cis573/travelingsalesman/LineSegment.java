package edu.upenn.cis573.travelingsalesman;

import android.graphics.Color;
import android.graphics.Point;

import java.util.ArrayList;


public class LineSegment {


    public Point start;
    public Point end;

    public LineSegment() {

    }
    public ArrayList<Point> linePoints() {
        ArrayList<Point> points = new ArrayList<Point>();
        points.add(start);
        points.add(end);
        return points;
    }
    public static double distance(Point start,Point end) {
        double dx = start.x - end.x;
        double dy = start.y - end.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

}

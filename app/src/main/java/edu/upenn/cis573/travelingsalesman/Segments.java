package edu.upenn.cis573.travelingsalesman;

import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Point;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Segments {

    protected ArrayList<LineSegment> lineSegments = new ArrayList<LineSegment>();
    protected HashMap<Point, ArrayList<Point>> reachable = new HashMap<Point, ArrayList<Point>>();

    protected boolean isValidStroke = false;
    final public int width = 10;
    final public int color = Color.RED;

    public Segments() {

    }

    public boolean isValidStroke() {
        return isValidStroke;
    }

    public void setValidStroke(boolean isValidStroke) {
        this.isValidStroke = isValidStroke;
    }

    public LineSegment get(int i) {
        return lineSegments.get(i);
    }

    public int size() {
        return lineSegments.size();
    }

    public void add(LineSegment line) {
        lineSegments.add(line);
    }

    public void remove(LineSegment line) {
        lineSegments.remove(line);
    }

    public void clear() {
        lineSegments.clear();
    }

    public boolean isCircuit(int numPoints) {
        // detects whether the segments form a circuit - but there's a bug!
        boolean isCircuit = true;
        Point startPoint = null;
        HashMap<Point, Integer> connections = new HashMap<>();
        for (int i = 0; i < this.size(); i++) {
            LineSegment line = this.get(i);
            Point p1 = line.start;
            Point p2 = line.end;
            if (reachable.containsKey(p1)) reachable.get(p1).add(p2);
            else reachable.put(p1, new ArrayList<>(Arrays.asList(p2)));
            if (reachable.containsKey(p2)) reachable.get(p2).add(p1);
            else reachable.put(p2, new ArrayList<>(Arrays.asList(p1)));
            Integer value = connections.get(p1);
            if (value == null)
                value = 0;
            value++;
            connections.put(p1, value);

            value = connections.get(p2);
            if (value == null)
                value = 0;
            value++;
            connections.put(p2, value);
        }
        if (this.size() == numPoints) {
            startPoint = lineSegments.get(0).start;
            Queue<Point> queue = new LinkedList<>();
            queue.add(startPoint);
            List<Point> visited = new LinkedList<>();
            while (queue.size() > 0) {
                Point point = queue.poll();
                ArrayList<Point> links = reachable.get(point);
                for (Point p : links) {
                    if (!visited.contains(p)) {
                        visited.add(p);
                        queue.add(p);
                    }
                }
            }
            reachable.clear();
            if (visited.size() != numPoints) isCircuit = false;
            else {
                if (this.size() == 0) {
                    isCircuit = false;
                } else {
                    for (int v : connections.values()) {
                        if (v != 2) {
                            isCircuit = false;
                            break;
                        }
                    }
                }
            }

        }
        reachable.clear();
        return isCircuit;
    }
}

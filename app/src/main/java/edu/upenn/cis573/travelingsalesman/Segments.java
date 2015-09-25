package edu.upenn.cis573.travelingsalesman;

import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Point;

import java.util.ArrayList;


public class Segments {

    protected ArrayList<LineSegment> lineSegments = new ArrayList<LineSegment>();

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

    public LineSegment get(int i ) {
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

}

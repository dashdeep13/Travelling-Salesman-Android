package edu.upenn.cis573.travelingsalesman;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class Stroke {

    protected ArrayList<Point> strokeCoords = new ArrayList<Point>();

    protected boolean isValidStroke = false;
    final public int width = 10;
    final public int color = Color.YELLOW;

    public Stroke() {

    }

    public boolean isValidStroke() {
        return isValidStroke;
    }

    public void setValidStroke(boolean isValidStroke) {
        this.isValidStroke = isValidStroke;
    }

    public Point get(int i ) {
        return strokeCoords.get(i);
    }

    public int size() {
        return strokeCoords.size();
    }

    public void add(Point point) {
        strokeCoords.add(point);
    }
    public void clear() {
        strokeCoords.clear();
    }

}

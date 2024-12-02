package com.example.cisc682doodleassignment;

import android.graphics.Path;

public class DrawPath {
    public Path path;
    public int color;
    public int strokeWidth;
    public int alpha;

    public DrawPath(int color, int strokeWidth, int alpha) {
        this.path = new Path();
        this.color = color;
        this.strokeWidth = strokeWidth;
        this.alpha = alpha;
    }
}

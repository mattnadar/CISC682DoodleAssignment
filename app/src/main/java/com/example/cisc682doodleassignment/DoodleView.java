package com.example.cisc682doodleassignment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class DoodleView extends View {
    private Paint paint;
    private ArrayList<DrawPath> paths;
    private DrawPath currentPath;

    public DoodleView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);

        paths = new ArrayList<>();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (DrawPath path : paths) {
            paint.setColor(path.color);
            paint.setStrokeWidth(path.strokeWidth);
            paint.setAlpha(path.alpha);
            canvas.drawPath(path.path, paint);
        }

        if (currentPath != null) {
            paint.setColor(currentPath.color);
            paint.setStrokeWidth(currentPath.strokeWidth);
            paint.setAlpha(currentPath.alpha);
            canvas.drawPath(currentPath.path, paint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                currentPath = new DrawPath(paint.getColor(), (int) paint.getStrokeWidth(), paint.getAlpha());
                currentPath.path.moveTo(event.getX(), event.getY());
                break;

            case MotionEvent.ACTION_MOVE:
                currentPath.path.lineTo(event.getX(), event.getY());
                invalidate();
                break;

            case MotionEvent.ACTION_UP:
                paths.add(currentPath);
                currentPath = null;
                break;
        }
        return true;
    }

    public void clearCanvas() {
        paths.clear();
        invalidate();
    }

    public void setColor(int color) {
        paint.setColor(color);
    }

    public void setBrushSize(float size) {
        paint.setStrokeWidth(size);
    }

    public void setOpacity(int alpha) {
        paint.setAlpha(alpha);
    }
}

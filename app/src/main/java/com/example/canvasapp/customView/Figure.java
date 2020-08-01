package com.example.canvasapp.customView;

import android.graphics.Canvas;

public abstract class Figure {

    private Point basePoint;

    public Figure(Point basePoint){
        this.basePoint = basePoint;
    }

    public abstract void draw(Canvas canvas);

    public void moveTo(int x, int y){
        basePoint.setX(x);
        basePoint.setY(y);
    }

    public Point getBasePoint() {
        return basePoint;
    }


    public void setBasePoint(Point basePoint) {
        this.basePoint = basePoint;
    }
}

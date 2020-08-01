package com.example.canvasapp.customView.figure;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.canvasapp.customView.Point;

public class Rectangle extends Square {

    private int height;
    private static Paint paint;

    public Rectangle(Point basePoint, int width, int height){
        super(basePoint, width);
        this.height = height;
        paint = new Paint();
    }

    @Override
    public void draw(Canvas canvas) {

        int[] color = getBasePoint().getCustomColor().getColor();
        paint.setARGB(255, color[0], color[1], color[2]);

        canvas.drawRect(
                getBasePoint().getX(),
                getBasePoint().getY(),
                getBasePoint().getX()+getWidth(),
                getBasePoint().getY()+height,
                paint
        );
    }

    public int getHeight(){
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

package com.example.canvasapp.customView.figure;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.canvasapp.customView.ChangableColor;
import com.example.canvasapp.customView.Point;

public class Ellipse extends Circle {

    private int radiusSecond;
    private static Paint paint;

    public Ellipse(Point basePoint, int radius, int radiusSecond){
        super(basePoint, radius);
        this.radiusSecond = radiusSecond;
        paint = new Paint();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void draw(Canvas canvas) {

        int[] color = getBasePoint().getCustomColor().getColor();
        paint.setARGB(255, color[0], color[1], color[2]);

        canvas.drawOval(
                getBasePoint().getX(),
                getBasePoint().getY(),
                getBasePoint().getX()+getRadiusSecond()*2,
                getBasePoint().getY()+getRadius()*2,
                paint
        );
    }

    public int getRadiusSecond() {
        return radiusSecond;
    }

    public void setRadiusSecond(int radiusSecond) {
        this.radiusSecond = radiusSecond;
    }
}

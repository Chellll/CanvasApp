package com.example.canvasapp.customView.figure;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.example.canvasapp.customView.ChangableColor;
import com.example.canvasapp.customView.CustomColor;
import com.example.canvasapp.customView.Figure;
import com.example.canvasapp.customView.Point;

public class Circle extends Figure implements ChangableColor {

    private int radius;
    private static Paint paint;

    public Circle(Point basePoint, int radius){
        super(basePoint);

        this.radius = radius;

        paint= new Paint();

    }

    @Override
    public void draw(Canvas canvas) {

        int[] color = super.getBasePoint().getCustomColor().getColor();

        paint.setARGB(255, color[0], color[1], color[2]);

        canvas.drawCircle(
                getBasePoint().getX(),
                getBasePoint().getY(),
                radius,
                paint
        );
    }

    public int getRadius(){
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void setColor(int red, int green, int blue) {
        getBasePoint().setCustomColor(new CustomColor(red, green, blue));
    }

    @Override
    public int[] getColor() {
        return getBasePoint().getCustomColor().getColor();
    }

    public void move(int x, int y){
        super.moveTo(x, y);
    }

}

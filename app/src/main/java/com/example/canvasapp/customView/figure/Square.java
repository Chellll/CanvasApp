package com.example.canvasapp.customView.figure;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.canvasapp.customView.ChangableColor;
import com.example.canvasapp.customView.Figure;
import com.example.canvasapp.customView.Point;

public class Square extends Figure  {

    private int width;
    private static Paint paint;

    public Square(Point basePoint, int width){
        super(basePoint);
        this.width = width;
        paint = new Paint();
        paint.setColor(Color.GREEN);
    }

    @Override
    public void draw(Canvas canvas) {

        int[] color = getBasePoint().getCustomColor().getColor();
        paint.setARGB(255, color[0], color[1], color[2]);

        canvas.drawRect(
                getBasePoint().getX(),
                getBasePoint().getY(),
                getBasePoint().getX()+width,
                getBasePoint().getY()+width,
                paint
        );
    }

    public int getWidth(){
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}

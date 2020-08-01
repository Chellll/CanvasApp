package com.example.canvasapp.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.canvasapp.customView.ChangableColor;
import com.example.canvasapp.customView.CustomColor;
import com.example.canvasapp.customView.figure.Circle;
import com.example.canvasapp.customView.Figure;
import com.example.canvasapp.customView.Point;

import java.util.Random;

public class DrawView extends View {

    private static final int STEP = 50;

    private Paint p;
    private CustomColor customColor;
    private Random random;
    private Figure figure;

    public DrawView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        p = new Paint();

        p.setARGB(255, 200,200,200);
    }

    public DrawView(Context context){
        super(context);
        p = new Paint();

        p.setARGB(255, 200,200,200);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        figure.draw(canvas);
    }

    @Override
    public void invalidate() {

        figure.moveTo(figure.getBasePoint().getX() + 15, figure.getBasePoint().getY() + 15);
        super.invalidate();
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
        invalidate();
    }


}

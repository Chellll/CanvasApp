package com.example.canvasapp.customView;

public class Point {

    private int x;
    private int y;
    private CustomColor customColor;

    public Point(){}

    public Point(int x, int y, CustomColor customColor) {
        this.x = x;
        this.y = y;
        this.customColor = customColor;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public CustomColor getCustomColor() {
        return customColor;
    }

    public void setCustomColor(CustomColor customColor) {
        this.customColor = customColor;
    }
}

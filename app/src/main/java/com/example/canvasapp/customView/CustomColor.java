package com.example.canvasapp.customView;

public class CustomColor {

    private int red;
    private int green;
    private int blue;

    public CustomColor() {

    }

    public CustomColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public void setColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int[] getColor() {
        return new int[]{red, green, blue};
    }
}
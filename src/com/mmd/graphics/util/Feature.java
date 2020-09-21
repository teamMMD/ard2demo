package com.mmd.graphics.util;

import java.awt.*;

public class Feature {
    public int x;
    public int y;
    public char glyph;
    public Color color;

    public Feature(int fx, int fy) {
        x = fx;
        y = fy;
    }

    public void updateLocation(int newX, int newY) {
        setX(newX);
        setY(newY);
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

    public char glyph() {
        return glyph;
    }
    public void setGlyph(char glyph) {
        this.glyph = glyph;
    }

    public Color color() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
}

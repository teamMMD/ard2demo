package com.mmd.meeples;

import java.awt.*;

public class Meeple {
    public String name;
    public int x;
    public int y;

    private char glyph;
    private Color color;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // set position in coordinate plane

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

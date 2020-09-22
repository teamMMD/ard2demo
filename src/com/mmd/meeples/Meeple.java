package com.mmd.meeples;

import java.awt.*;

public abstract class Meeple {
    private String name;
    private String description;
    private int health;

    private char glyph;
    private Color color;

    public int x;
    public int y;

    public abstract void moveBy(int mx, int my);
    public abstract void attack();

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public void updateHealth(int hp) {
        this.health = this.getHealth() + hp;
    }
    public int getHealth() {
        return health;
    }

}

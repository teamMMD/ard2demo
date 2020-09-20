package com.mmd.meeples;

public class Meeple {
    public String name;
    public int x;
    public int y;

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
}

package com.mmd.meeples;

import com.mmd.environment.Room;

import java.awt.*;

public class Player extends Meeple {
    private Room room;
    final public int maxHP = 100;
    public String[] inv = new String[3];

    public Player(Room room, char glyph, Color color, int sx, int sy) {
        this.room = room;
        setColor(color);
        setGlyph(glyph);
        setX(sx);
        setY(sy);
        updateHealth(100);
    }

    public void moveBy(int mx, int my) {
        setX(x + mx);
        setY(y + my);
    }

    public boolean availableMove(int ax, int ay) {
        return room.coordinatePlane(ax, ay) == null;
    }

    public StringBuilder getInv() {
        StringBuilder invStr = new StringBuilder();
        for (String i : inv)
            if (i != null)
                invStr.append(i);
        return invStr.length() > 0 ? invStr : new StringBuilder().append("empty");
    }

    @Override
    public String toString() {
        return "Player{" +
                "room=" + room +
                ", name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}

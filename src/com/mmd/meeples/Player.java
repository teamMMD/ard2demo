package com.mmd.meeples;

import com.mmd.environment.Room;

import java.awt.*;

public class Player extends Meeple {
    private Room room;

    public Player(Room room, char glyph, Color color, int sx, int sy) {
        this.room = room;
        setColor(color);
        setGlyph(glyph);
        setX(sx);
        setY(sy);
    }

    public void moveBy(int mx, int my) {
        setX(x + mx);
        setY(y + my);
    }

    public boolean availableMove(int ax, int ay) {
        return room.coordinatePlane(ax, ay) == null;
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

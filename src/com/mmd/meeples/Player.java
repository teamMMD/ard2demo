package com.mmd.meeples;

import com.mmd.environment.Room;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Player extends Meeple {
    private Room room;
    final public int maxHP = 100;
    public String[] inv = new String[3];

    public Player(Room room, char glyph, Color color) {
        this.room = room;
        setColor(color);
        setGlyph(glyph);
        setX(ThreadLocalRandom.current().nextInt(2, 79-2));
        setY(ThreadLocalRandom.current().nextInt(2, 22-2));
        updateHealth(100);
    }

    public Player(Room room, char glyph, Color color, int sx, int sy) {
        this.room = room;
        setColor(color);
        setGlyph(glyph);
        setX(sx);
        setY(sy);
        updateHealth(100);
    }

    public void moveBy(int mx, int my) {
        int moveX = x + mx;
        int moveY = y + my;
        if (availableMove(moveX, moveY)) {
            setX(moveX);
            setY(moveY);
            if (doorCheck(moveX, moveY)) {
                System.out.println("found a door!");
            }
        } else
            System.out.println("can't go that way!");
    }

    public boolean availableMove(int ax, int ay) {
        return room.coordinatePlane[ax][ay].glyph() == (char) 255 || doorCheck(ax, ay);
    }

    public boolean doorCheck(int dx, int dy) {
        Boolean doorPresent = false;
        if (
            room.coordinatePlane[dx][dy].glyph() == (char) 192 ||
            room.coordinatePlane[dx][dy].glyph() == (char) 196 ||
            room.coordinatePlane[dx][dy].glyph() == (char) 217
        )
            doorPresent = true;
        return doorPresent;
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

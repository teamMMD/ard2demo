package com.mmd.meeples;

import com.mmd.environment.Room;
import com.mmd.graphics.screens.PlayScreen;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Monster extends Meeple {
    private Room room;

    public Monster (Room room, char glyph, Color color) {
        setColor(color);
        setGlyph(glyph);
        setX(ThreadLocalRandom.current().nextInt(2, 79-2));
        setY(ThreadLocalRandom.current().nextInt(2, 22-2));
        updateHealth(30);
    }

    public boolean isAlive(PlayScreen ps) {
        return !ps.monsterInRoom;
    }

    @Override
    public void moveBy(int mx, int my) {

    }

    @Override
    public void attack() {

    }

}

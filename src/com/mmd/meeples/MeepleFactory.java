package com.mmd.meeples;

import asciiPanel.AsciiPanel;
import com.mmd.environment.Room;
import com.mmd.graphics.util.Tile;

import java.awt.*;

public class MeepleFactory {
    public Room room;

    public MeepleFactory(Room room) {
        this.room = room;
    }

//    public Meeple newPlayer() {
//        Meeple player = new Player(room, '@', AsciiPanel.brightMagenta);
//        room.entryDoor(player);
//    }

//    public static Monster createMonster() {
//        return new Monster((char) 237, Color.RED);
//    }
}

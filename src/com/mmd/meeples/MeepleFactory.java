package com.mmd.meeples;

import asciiPanel.AsciiPanel;
import com.mmd.environment.Room;

public class MeepleFactory {
    private Room room;

    public MeepleFactory(Room room) {
        this.room = room;
    }

//    public Meeple newPlayer() {
//        Meeple player = new Player(room, '@', AsciiPanel.brightMagenta);
//        room.entryDoor(player);
//    }

    public Meeple newMonster() {
        return new Meeple();
    }
}

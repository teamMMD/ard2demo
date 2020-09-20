package com.mmd.graphics.screens;

import asciiPanel.AsciiPanel;
import com.mmd.environment.Room;

import java.awt.event.KeyEvent;

public class PlayScreen implements Screen {
    private Room room;
    private int screenWidth = 79;
    private int screenHeight = 22;


    @Override
    public void displayInAP(AsciiPanel ap) {
//        ap.writeCenter("look at that a playscreen", 9);
        displayRoom(ap);
    }

    private void displayRoom(AsciiPanel ap) {
        room = new Room(screenWidth, screenHeight);
        for (int x = 0; x < room.getWidth(); x++) {
            for (int y = 0; y < room.getHeight(); y++) {
                ap.write(room.coordinatePlane[x][y].glyph(), room.coordinatePlane[x][y].color());
                System.out.println("..?");
            }
        }
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        System.out.println("playscreen knows about the keypress!");
        return null;
    }
}

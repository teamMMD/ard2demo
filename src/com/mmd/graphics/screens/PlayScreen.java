package com.mmd.graphics.screens;

import asciiPanel.AsciiPanel;
import com.mmd.environment.Room;
import com.mmd.meeples.Meeple;
import com.mmd.meeples.Player;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PlayScreen implements Screen {
    private int screenWidth = 79;
    private int screenHeight = 22;
    private Room room = new Room(screenWidth, screenHeight);
    private Player player = player = new Player(room, (char)65, Color.orange, 39, 11);;


    @Override
    public void displayInAP(AsciiPanel ap) {
//        ap.writeCenter("look at that a playscreen", 9);
        displayRoom(ap);
    }

    private void displayRoom(AsciiPanel ap) {
//        room = new Room(screenWidth, screenHeight);
//        player = new Player(room, (char)65, Color.orange, 39, 11);
        System.out.println(player.getX() + " - " + player.getY());
        for (int x = 0; x < room.getWidth(); x++) {
            for (int y = 0; y < room.getHeight(); y++) {
                if (x == player.getX() && y == player.getY())
                    ap.write(player.glyph(), x, y, player.color());
                else
                    ap.write(room.coordinatePlane[x][y].glyph(), x, y, room.coordinatePlane[x][y].color());
            }
        }
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                System.exit(1);
//            case KeyEvent.VK_LEFT:
//                return new TempScreen();
//            case KeyEvent.VK_ENTER:
//                return new PlayScreen();
            case KeyEvent.VK_W:
                player.moveBy(0, -1); break;
            case KeyEvent.VK_A:
                player.moveBy(-1, 0); break;
            case KeyEvent.VK_S:
                player.moveBy(0, 1); break;
            case KeyEvent.VK_D:
                player.moveBy(1, 0); break;
        }
        return this;
    }

}

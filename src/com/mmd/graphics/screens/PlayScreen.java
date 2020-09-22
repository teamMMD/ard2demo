package com.mmd.graphics.screens;

import asciiPanel.AsciiPanel;
import com.mmd.environment.Room;
import com.mmd.graphics.util.Tile;
import com.mmd.meeples.Monster;
import com.mmd.meeples.Player;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PlayScreen implements Screen {
    private int screenWidth = 79;
    private int screenHeight = 22;
    private Room room = new Room(79, 22);
    private Player player = new Player(room, (char)65, Color.orange, 39, room.getHeight() - 2);;
    private Monster monster = new Monster(room, Tile.MONSTER.glyph(), Tile.MONSTER.color());
    private boolean moveOn = false;
    private boolean monsterInRoom = true;

    @Override
    public void displayInAP(AsciiPanel ap) {
        if (!player.doorCheck(player.getX(), player.getY())) {
//            moveOn = false;
            if (player.x == monster.x && player.y == monster.y) {
                System.out.println("test");
                player.updateHealth(-30);
                monster.setX(-1);
                monster.setY(-1);
                monsterInRoom = false;
                ap.writeCenter("You fought the monster!", 22, Color.RED);
            }
            System.out.println("player: " + player.getX() + " - " + player.getY());
            System.out.println("monster: " + monster.getX() + " - " + monster.getY());
            player.updateHealth(-1);
            displayRoom(ap);
            displayUI(ap);
        } else {
            ap.writeCenter("Press [up]/[w] to move to the next room!", 11, Color.GREEN);
            ap.writeCenter("...if you dare...", 12, Color.GREEN);
//            respondToUserInput(key);
            moveOn = true;
        }
    }

    private void displayRoom(AsciiPanel ap) {
//        System.out.println(room.door.glyph + " " + room.door.getX() + " - " + room.door.getY());
//        System.out.println(player.getX() + " - " + player.getY());
        for (int x = 0; x < screenWidth; x++) {
            for (int y = 0; y < screenHeight; y++) {
                if (x == room.door.getX() && y == room.door.getY()) {
                    room.coordinatePlane[x-2][y] = Tile.LDOOR;
                    ap.write(room.coordinatePlane[x-2][y].glyph(), x-2, y, Color.CYAN);
                    room.coordinatePlane[x-1][y] = Tile.MDOOR;
                    ap.write(room.coordinatePlane[x-1][y].glyph(), x-1, y, Color.CYAN);
                    room.coordinatePlane[x][y] = Tile.RDOOR;
                    ap.write(room.coordinatePlane[x][y].glyph(), x, y);
                }
                else if (x == monster.getX() && y == monster.getY() && monsterInRoom)
                    ap.write(monster.glyph(), x, y, monster.color());
                else if (x == player.getX() && y == player.getY())
                    ap.write(player.glyph(), x, y, player.color());
                else
                    ap.write(room.coordinatePlane[x][y].glyph(), x, y, room.coordinatePlane[x][y].color());
            }
        }
    }

    public void displayUI(AsciiPanel ap) {
        ap.write("Health: " + player.getHealth() + " / " + player.maxHP, 4, 23, Color.orange);
        ap.write("Inventory: " + player.getInv(), 54, 23);
        ap.write("RoomName: " + "Proving Grounds", 54, 0);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
//        System.out.println("Health: " + player.getHealth());
        if (player.getHealth() < 1) return new LoseScreen(this);
        if (moveOn) return new PlayScreen();
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                System.exit(1);
            case KeyEvent.VK_P:
                return new TempScreen(this);
            case KeyEvent.VK_ENTER:
                return new PlayScreen();
            case KeyEvent.VK_W:
            case KeyEvent.VK_KP_UP:
            case KeyEvent.VK_UP:
                player.moveBy(0, -1); break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_KP_LEFT:
            case KeyEvent.VK_LEFT:
                player.moveBy(-1, 0); break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_KP_DOWN:
            case KeyEvent.VK_DOWN:
                player.moveBy(0, 1); break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_KP_RIGHT:
            case KeyEvent.VK_RIGHT:
                player.moveBy(1, 0); break;
            case KeyEvent.VK_H:
                return new InitialHelpScreen(this);
        }
        return this;
    }

}

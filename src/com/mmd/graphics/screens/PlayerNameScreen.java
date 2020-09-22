package com.mmd.graphics.screens;

import asciiPanel.AsciiPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PlayerNameScreen implements Screen {
    public String playerName = "";

    @Override
    public void displayInAP(AsciiPanel ap) {
        ap.writeCenter("You've fallen asleep after watching 'The Labrynth'", 4);
        ap.writeCenter("and eating some questionable leftovers.", 5);
        ap.writeCenter("Maybe not the best bet considering your long standing", 7);
        ap.writeCenter("irrational fear of being IronMan trapped in his 'A' suit", 8);
        ap.writeCenter("in a never ending randomly generated maze", 9);
        ap.writeCenter("Hopefully there won't be any monsters...", 10);
        ap.writeCenter("Please enter your dream name:", 14, Color.GRAY);
        ap.writeCenter(playerName, 16, Color.ORANGE);
        ap.setName(playerName);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        if (playerName.length() > 8) {
            saveNameToFile(getPlayerName());
            return new PlayScreen();
        }
        if (key.getKeyCode() != KeyEvent.VK_ENTER) {
            playerName = playerName + key.getKeyChar();
        } else if (key.getKeyCode() == KeyEvent.VK_ENTER) {
            // write playerName to save_file
            saveNameToFile(getPlayerName());
            return new PlayScreen();
        } else {
            return this;
        }
        return this;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    private void saveNameToFile(String name) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter("resources/save_file/name.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.append(name);
        writer.println();
        writer.close();

        System.out.println("name written to name.txt");
    }
}

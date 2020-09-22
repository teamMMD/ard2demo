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
        ap.writeCenter("Please enter your name:", 10);
        ap.writeCenter(playerName, 13, Color.MAGENTA);
        ap.setName(playerName);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        if (key.getKeyCode() != KeyEvent.VK_ENTER || playerName.length() > 8) {
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

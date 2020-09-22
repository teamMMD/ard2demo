package com.mmd.graphics.screens;

import asciiPanel.AsciiPanel;
import com.mmd.util.ConsoleManager;
import com.mmd.util.MenuTrieNode;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameControlsScreen implements Screen {
    public PlayScreen playScreen;
    public GameControlsScreen(PlayScreen playScreen) {
        this.playScreen = playScreen;
    }

    MenuTrieNode gameControls = ConsoleManager.read_xml_gameControls().getChild(0);

    @Override
    public void displayInAP(AsciiPanel terminal) {
        terminal.writeCenter(gameControls.getParent().getTitle(), 4, Color.orange);
        terminal.writeCenter(gameControls.getParent().getDescription(), 6, Color.white);
        terminal.writeCenter(gameControls.getParent().getChild(0).getDescription(), 9, Color.white);
        terminal.writeCenter(gameControls.getParent().getChild(1).getDescription(), 10, Color.white);
        terminal.writeCenter(gameControls.getParent().getChild(2).getDescription(), 11, Color.white);
        terminal.writeCenter(gameControls.getParent().getChild(3).getDescription(), 12, Color.white);

        terminal.writeCenter("Press [B] to return to the previous screen", 20, Color.gray);
        terminal.writeCenter("Press [Backspace] to return to the loadingScreen", 21, Color.gray);
        terminal.writeCenter("Press [Q] to quit", 22, Color.gray);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_BACK_SPACE:
                return new LoadingScreen(playScreen);
            case KeyEvent.VK_B:
                return new InitialHelpScreen(playScreen);
            case KeyEvent.VK_Q:
                return new QuitScreen(playScreen);
        }
        return this;
    }

}
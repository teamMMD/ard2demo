package com.mmd.graphics.screens;

import asciiPanel.AsciiPanel;

import java.awt.*;
import java.awt.event.KeyEvent;

public class QuitScreen implements Screen {
    public PlayScreen playScreen;
    public QuitScreen(PlayScreen playScreen) {
        this.playScreen = playScreen;
    }

    @Override
    public void displayInAP(AsciiPanel terminal) {
        terminal.writeCenter("If you quit now you will lose all your game progress.", 6, Color.white);
        terminal.writeCenter("Are you sure you want to quit?", 4, Color.orange);

        terminal.writeCenter("Press [Q] or [ESC] again to exit.", 20, Color.white);
        terminal.writeCenter("Press any button to go back.", 22, Color.gray);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_Q:
            case KeyEvent.VK_ESCAPE:
                System.exit(1);
        }
        return playScreen;
    }
}

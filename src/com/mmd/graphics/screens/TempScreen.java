package com.mmd.graphics.screens;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class TempScreen implements Screen {

    public PlayScreen playScreen;

    public TempScreen(PlayScreen playScreen) {
        this.playScreen = playScreen;
    }

    @Override
    public void displayInAP(AsciiPanel ap) {
        ap.writeCenter("Hi, I'm a helpful temp screen", 11);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        return playScreen;
    }
}

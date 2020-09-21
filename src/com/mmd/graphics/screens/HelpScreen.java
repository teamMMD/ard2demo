package com.mmd.graphics.screens;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class HelpScreen implements Screen {

    public PlayScreen playScreen;

    public HelpScreen(PlayScreen playScreen) {
        this.playScreen = playScreen;
    }

    @Override
    public void displayInAP(AsciiPanel ap) {
        ap.writeCenter("Help screen goes here", 11);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        return playScreen;
    }
}

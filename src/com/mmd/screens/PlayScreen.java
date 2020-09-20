package com.mmd.screens;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class PlayScreen implements Screen {
    @Override
    public void displayInAP(AsciiPanel ap) {
        ap.writeCenter("look at that a playscreen", 9);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        System.out.println("playscreen knows about the keypress!");
        return null;
    }
}

package com.mmd.graphics.screens;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public interface Screen {

    public void displayInAP(AsciiPanel ap);

    public Screen respondToUserInput(KeyEvent key);
}

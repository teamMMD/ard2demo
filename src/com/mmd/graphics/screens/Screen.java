package com.mmd.graphics.screens;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

public interface Screen {

    public void displayInAP(AsciiPanel ap) throws FileNotFoundException;

    public Screen respondToUserInput(KeyEvent key) throws FileNotFoundException;
}

package com.mmd.engine;

import asciiPanel.AsciiPanel;
import com.mmd.graphics.screens.LoadingScreen;
import com.mmd.graphics.screens.PlayScreen;
import com.mmd.graphics.screens.PlayerNameScreen;
import com.mmd.graphics.screens.Screen;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;

public class Paint extends JFrame implements KeyListener {

    private AsciiPanel ap;
    private Screen screen;
    private StringBuilder log;

    PlayScreen playScreen;

    public Paint() {
        super();
        ap = new AsciiPanel();
        add(ap);
        pack();
        screen = (Screen) new LoadingScreen(playScreen);
        addKeyListener(this);
        repaint();
    }

    public void repaint() {
        ap.clear();
        try {
            screen.displayInAP(ap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        super.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        try {
            screen = screen.respondToUserInput(e);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void getLog() {
        System.out.println(log);
    }
}

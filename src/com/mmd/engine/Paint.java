package com.mmd.engine;

import asciiPanel.AsciiPanel;
import com.mmd.graphics.screens.PlayScreen;
import com.mmd.graphics.screens.Screen;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Paint extends JFrame implements KeyListener {

    private AsciiPanel ap;
    private Screen screen;
    private StringBuilder log;

    public Paint() {
        super();
        ap = new AsciiPanel();
        add(ap);
        pack();
        screen = (Screen) new PlayScreen();
        addKeyListener(this);
        repaint();
    }

    public void repaint() {
        ap.clear();
        screen.displayInAP(ap);
        super.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        log.append(", ").append(e.getKeyCode());
        screen = screen.respondToUserInput(e);
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("whoopee a key was released...");
    }

    public void getLog() {
        System.out.println(log);
    }
}

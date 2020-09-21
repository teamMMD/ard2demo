package com.mmd.screens;

import asciiPanel.AsciiPanel;
import com.mmd.graphics.screens.PlayScreen;
import com.mmd.graphics.screens.Screen;
import com.mmd.util.ConsoleManager;
import com.mmd.util.MenuTrieNode;

import java.awt.*;
import java.awt.event.KeyEvent;

public class HowToWinHelpScreen implements Screen {
    PlayScreen playScreen;
    ConsoleManager cm = new ConsoleManager();
    MenuTrieNode howDoIwin = cm.read_xml().getChild(0).getChild(0);
    MenuTrieNode howToFindBoss = cm.read_xml().getChild(0).getChild(0).getChild(0);
    MenuTrieNode howToKillBoss = cm.read_xml().getChild(0).getChild(0).getChild(1);

    public HowToWinHelpScreen(PlayScreen playScreen) {
        this.playScreen = playScreen;
    }

    @Override
    public void displayInAP(AsciiPanel terminal) {
        terminal.writeCenter(howDoIwin.getTitle(), 4, Color.orange);
        terminal.writeCenter(howDoIwin.getDescription(), 5, Color.white);

        terminal.writeCenter(howToFindBoss.getTitle(), 7, Color.orange);
        terminal.writeCenter(howToFindBoss.getDescription(), 8, Color.white);

        terminal.writeCenter(howToKillBoss.getTitle(), 10, Color.orange);
        terminal.writeCenter(howToKillBoss.getDescription(), 11, Color.white);

        terminal.writeCenter("hit [b] to return to the previous screen", 21, Color.gray);
        terminal.writeCenter("hit [backspace] to return to the loadingScreen", 22, Color.gray);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_BACK_SPACE:
                return new LoadingScreen();
            case KeyEvent.VK_B:
                return new InitialHelpScreen();
        }
        return new LoadingScreen();
    }
}

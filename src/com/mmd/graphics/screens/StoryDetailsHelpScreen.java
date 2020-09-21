package com.mmd.screens;

import asciiPanel.AsciiPanel;
import com.mmd.graphics.screens.PlayScreen;
import com.mmd.graphics.screens.Screen;
import com.mmd.util.ConsoleManager;
import com.mmd.util.MenuTrieNode;

import java.awt.*;
import java.awt.event.KeyEvent;

public class StoryDetailsHelpScreen implements Screen {
    public PlayScreen playscreen;
    public ConsoleManager cm = new ConsoleManager();
    public MenuTrieNode storyDetails = cm.read_xml().getChild(0);

    public StoryDetailsHelpScreen(PlayScreen playScreen) {
        this.playscreen = playScreen;
    }

    @Override
    public void displayInAP(AsciiPanel ap) {
        ap.writeCenter(storyDetails.getTitle(), 4, Color.orange);
        ap.writeCenter(storyDetails.getDescription(), 6, Color.white);
        ap.writeCenter("Press <0> to see " + storyDetails.getChild(0).getTitle(), 9, Color.white);
        ap.writeCenter("Press <1> to see more information", 10, Color.white);

        ap.writeCenter("hit [b] to return to the previous screen", 21, Color.gray);
        ap.writeCenter("hit [backspace] to return to the loadingScreen", 22, Color.gray);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_0:
                return new HowToWinHelpScreen();
            case KeyEvent.VK_1:
                return new RoomsItemsSurviveHelpScreen();
            case KeyEvent.VK_BACK_SPACE:
                return new LoadingScreen();
            case KeyEvent.VK_B:
                return new InitialHelpScreen();
        }
        return new LoadingScreen();
    }

}

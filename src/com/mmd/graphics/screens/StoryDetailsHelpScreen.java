package com.mmd.graphics.screens;

import asciiPanel.AsciiPanel;
import com.mmd.graphics.screens.PlayScreen;
import com.mmd.graphics.screens.Screen;
import com.mmd.util.ConsoleManager;
import com.mmd.util.MenuTrieNode;

import java.awt.*;
import java.awt.event.KeyEvent;

public class StoryDetailsHelpScreen implements Screen {
    public PlayScreen playScreen;
    public ConsoleManager cm = new ConsoleManager();
    public MenuTrieNode storyDetails = cm.read_xml().getChild(0);

    public StoryDetailsHelpScreen(PlayScreen playScreen) {
        this.playScreen = playScreen;
    }

    @Override
    public void displayInAP(AsciiPanel ap) {
        ap.writeCenter(storyDetails.getTitle(), 4, Color.orange);
        ap.writeCenter(storyDetails.getDescription(), 6, Color.white);
        ap.writeCenter("Press [0] to see " + storyDetails.getChild(0).getTitle(), 9, Color.white);
        ap.writeCenter("Press [1] to see more information", 10, Color.white);

        ap.writeCenter("Press [B] to return to the previous screen", 20, Color.gray);
        ap.writeCenter("Press [Backspace] to return to the loadingScreen", 21, Color.gray);
        ap.writeCenter("Press [Q] to quit", 22, Color.gray);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_0:
                return new HowToWinHelpScreen(playScreen);
            case KeyEvent.VK_1:
                return new RoomsItemsSurviveHelpScreen(playScreen);
            case KeyEvent.VK_BACK_SPACE:
                return new LoadingScreen(playScreen);
            case KeyEvent.VK_B:
                return new InitialHelpScreen(playScreen);
            case KeyEvent.VK_Q:
                return new QuitScreen(playScreen);
        }
        return new LoadingScreen(playScreen);
    }
}

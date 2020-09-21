package com.mmd.graphics.screens;

import asciiPanel.AsciiPanel;
import com.mmd.graphics.screens.TempScreen;
import com.mmd.graphics.screens.PlayScreen;
import com.mmd.graphics.screens.Screen;
import com.mmd.util.ConsoleManager;
import com.mmd.util.MenuTrieNode;

import java.awt.*;
import java.awt.event.KeyEvent;

public class InitialHelpScreen implements Screen {
    public PlayScreen playScreen;
    public ConsoleManager cm = new ConsoleManager();
    public MenuTrieNode storyDetails = cm.read_xml().getChild(0);
    public MenuTrieNode gameControl = cm.read_xml().getChild(1);

    public InitialHelpScreen(PlayScreen playScreen) {
        this.playScreen = playScreen;
    }

    @Override
    public void displayInAP(AsciiPanel ap) {
        ap.writeCenter(cm.read_xml().getTitle(), 4, Color.orange);

        // "YOU asked for help, what item do you want to learn about?"
        ap.writeCenter(cm.read_xml().getDescription(), 6, Color.white);

        // "[0, Story Details]"
        ap.writeCenter("Press [0] to see " + storyDetails.getTitle(), 8, Color.white);
        // "[1, Game Controls]"
        ap.writeCenter("Press [1] to see " + gameControl.getTitle(), 9, Color.white);

        ap.writeCenter("Press [B] to resume game", 11);
        ap.writeCenter("Press [Q] to quit", 12);
        ap.writeCenter("Press [Backspace] to return to the loading screen", 22, Color.gray);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
            case KeyEvent.VK_ENTER:
            case KeyEvent.VK_BACK_SPACE:
                return new LoadingScreen(playScreen);
            case KeyEvent.VK_B:
                return playScreen;
            case KeyEvent.VK_0:
                return new StoryDetailsHelpScreen(playScreen);
            case KeyEvent.VK_1:
                return new GameControlsScreen(playScreen);
        }
        return this;
    }
}

package com.mmd.graphics.screens;

import asciiPanel.AsciiPanel;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.SQLOutput;
import com.mmd.ard.Game;

public class WinScreen implements Screen {
    // TODO: need input for players name -> then add score to final_scores.txt
    public PlayScreen playScreen;

    public WinScreen(PlayScreen playScreen) {
        this.playScreen = playScreen;
    }

    @Override
    public void displayInAP(AsciiPanel terminal) {
        // TODO: need logic to pull in current players name + score
        terminal.writeCenter("!!! CONGRATS YOU WIN !!!", 5, Color.orange);

        // show scores
        terminal.writeCenter("currentPlayer.getName() + your score is XXX", 11, Color.white);

        terminal.writeCenter("hit <esc> to exit, <s> to see all high scores, or <enter> to play again =)", 22, Color.gray);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                System.exit(1);
            case KeyEvent.VK_ENTER:
                System.out.println("play again");
                return new LoadingScreen();
            case KeyEvent.VK_S:
                System.out.println("show all players scores");
                return new ScoreScreen();
        }
        return this;
    }
}

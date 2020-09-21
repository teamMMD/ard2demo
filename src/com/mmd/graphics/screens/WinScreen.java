package com.mmd.graphics.screens;

import asciiPanel.AsciiPanel;
import com.mmd.engine.Main;
import java.util.Random;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Scanner;

public class WinScreen implements Screen {
    // TODO: need input for players name -> then add score to final_scores.txt
    public PlayScreen playScreen;
    public WinScreen(PlayScreen playScreen) {
        this.playScreen = playScreen;
    }

    @Override
    public void displayInAP(AsciiPanel terminal) {

        saveScoreToFile();

        // TODO: need logic to pull in current players name + score
        terminal.writeCenter("!!! CONGRATS YOU WIN !!!", 5, Color.orange);

        // show scores
        // terminal.writeCenter("currentPlayer.getName() + your score is XXX", 11, Color.white);
        terminal.writeCenter( Main.humanPlayerName + " + your score is XXX", 11, Color.white);

        terminal.writeCenter("Press [ESC] to exit, [S] to see all high scores, or [Enter] to play again =)", 22, Color.gray);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                System.exit(1);
            case KeyEvent.VK_ENTER:
                System.out.println("play again");
                return new LoadingScreen(playScreen);
            case KeyEvent.VK_S:
                System.out.println("show all players scores");
                return new ScoreScreen(playScreen);
        }
        return this;
    }

    private void saveScoreToFile() {
        Random rand = new Random();
        int num = rand.nextInt(5000);

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter("resources/scores/final_scores.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }

        LocalDateTime time = LocalDateTime.now();
        writer.append("<Final score for this game @" + time + ">" + "\n");
        writer.append("[ danny ] (Iron Man): " + num + " points\n");
        writer.println();
        writer.close();

        System.out.println("wrote score to final_scores.txt");
    }

}

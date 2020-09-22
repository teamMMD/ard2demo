package com.mmd.graphics.screens;

import asciiPanel.AsciiPanel;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class WinScreen implements Screen {
    public PlayScreen playScreen;
    public PlayerNameScreen playerNameScreen;

    public WinScreen(PlayScreen playScreen, PlayerNameScreen playerNameScreen) {
        this.playScreen = playScreen;
        this.playerNameScreen = playerNameScreen;
    }

    @Override
    public void displayInAP(AsciiPanel terminal) throws FileNotFoundException {

        saveScoreToFile();

        terminal.writeCenter("!!! CONGRATS YOU WIN !!!", 5, Color.orange);
        terminal.writeCenter( readNameFromTxtFile() + ", hit [S] to view your score!", 11, Color.white);
        terminal.writeCenter("Press [ESC] to exit, [S] to see all high scores, or [Enter] to play again =)", 22, Color.gray);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) throws FileNotFoundException {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                playScreen.clearNameTxtFile();
                System.exit(1);
            case KeyEvent.VK_ENTER:
                System.out.println("play again");
                playScreen.clearNameTxtFile();
                return new PlayerNameScreen();
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
        writer.append("[ " + readNameFromTxtFile() + " ] (Iron Man): " + num + " points\n");
        writer.println();
        writer.close();

        System.out.println("wrote score to final_scores.txt");
    }

    private String readNameFromTxtFile(){
        try {
            if (Files.readAllLines(Paths.get("resources/save_file/name.txt")).size() > 0) {
                String line = Files.readAllLines(Paths.get("resources/save_file/name.txt")).get(0);
                playScreen.clearNameTxtFile();
                return line;
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "test";
    }
}

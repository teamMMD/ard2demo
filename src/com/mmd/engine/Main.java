package com.mmd.engine;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // run the thing
        Paint gameGui = new Paint();
        gameGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameGui.setVisible(true);
        System.out.println("game should have just closed");
    }
}

package com.mmd.engine;

import com.mmd.environment.Room;
import com.mmd.environment.RoomFactory;
import com.mmd.graphics.util.Tile;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Paint gameGui = new Paint();
        gameGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameGui.setVisible(true);
    }

    public static void setHumanPlayerName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input your adventurer's name: ");
        String humanPlayerName = input.nextLine();
    }

}

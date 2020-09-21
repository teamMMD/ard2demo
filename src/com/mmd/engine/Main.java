package com.mmd.engine;

import com.mmd.environment.Room;
import com.mmd.environment.RoomFactory;
import com.mmd.graphics.util.Tile;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static String humanPlayerName;

    public static void main(String[] args) {
//        setHumanPlayerName();

        Paint gameGui = new Paint();
        gameGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameGui.setVisible(true);

//        Tile test = Tile.WALL;
//        System.out.println(test);

//        Room testRoom = RoomFactory.createRoom();
//        System.out.println("testRoom: " + testRoom.showCoordinatePlane());
//
//        System.out.println("game should have just closed");
    }

    public static void setHumanPlayerName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input your adventurer's name: ");
        humanPlayerName = input.nextLine();
    }

}

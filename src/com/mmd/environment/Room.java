package com.mmd.environment;

import com.mmd.graphics.util.Tile;

import java.awt.*;

public class Room {
    public Tile[][] coordinatePlane;
    public int width = 79;
    public int height = 22;

    public Room() {
        setCoordinatePlane(width, height);
        populateCoordinatePlane();
    }

    public Room(int x, int y) {
        setWidth(x);
        setHeight(y);
        setCoordinatePlane(getWidth(), getHeight());
        populateCoordinatePlane();
    }

    public void populateCoordinatePlane() {
        System.out.println("populating plane");
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                if (y < 2 || y > getHeight() - 3)
                    coordinatePlane[x][y] = Tile.WALL;
                else if (x < 2 || x > getWidth() - 3)
                    coordinatePlane[x][y] = Tile.WALL;
                else
                    coordinatePlane[x][y] = Tile.GROUND;
            }
        }
        // randomizer:

    }

    public Tile[][] getCoordinatePlane() {
        return coordinatePlane;
    }
    public void setCoordinatePlane(int w, int h) {
        this.coordinatePlane = new Tile[w][h];
    }

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }


    // these are likely not needed
    public Tile coordinatePlane(int x, int y) {
        return coordinatePlane[x][y];
    }
    public char glyph(int x, int y) {
        return coordinatePlane(x, y).glyph();
    }
    public Color color(int x, int y) {
        return coordinatePlane(x, y).color();
    }
    // above is likely not needed


    public StringBuilder showCoordinatePlane() {
        StringBuilder coordinatePlaneString = new StringBuilder("");
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                coordinatePlaneString.append(coordinatePlane[x][y]);
                System.out.println(coordinatePlane[x][y]);
            }
        }
        return coordinatePlaneString;
    }


}

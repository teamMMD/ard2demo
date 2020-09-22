package com.mmd.environment;

import com.mmd.graphics.util.Door;
import com.mmd.graphics.util.Tile;
import com.mmd.meeples.Item;
import com.mmd.meeples.MeepleFactory;
import com.mmd.meeples.Monster;
import com.mmd.util.MiniMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Room {
    public Tile[][] coordinatePlane;
    public int width = 79;
    public int height = 22;
    public Door door = new Door(new Random().nextInt(74) + 2, 1);
    public String roomName;
    public MiniMap minMap = new MiniMap();

    private String description; // description of the room
    private int id; // room id (for ensuring hashcode is different)
    private List<Item> items; // list of items in room
    private List<Monster> monsters; // list of monsters in room
    private Random random = new Random(); // Generate random numbers

    public Room() {
        setCoordinatePlane(width, height);
        populateCoordinatePlane();
    }

    public Room(String roomName) {
        setCoordinatePlane(width, height);
        populateCoordinatePlane();
        this.roomName = roomName;
    }

    public Room(int x, int y) {
        setWidth(x);
        setHeight(y);
        setCoordinatePlane(getWidth(), getHeight());
        populateCoordinatePlane();
    }

    public Room(String roomName, int x, int y) {
        this.roomName = roomName;
        setWidth(x);
        setHeight(y);
        setCoordinatePlane(getWidth(), getHeight());
        populateCoordinatePlane();
    }

    public Room(String description, int id, int x, int y) {
        setWidth(x);
        setHeight(y);
        setCoordinatePlane(getWidth(), getHeight());
        populateCoordinatePlane();
        this.description = description;
        this.id = id;
        items = new ArrayList<>();
        monsters = new ArrayList<>();
        generateRandomRoomItems();
        generateRandomNormalMonsters();
    }

    /**
     * generates between 0 and 3 items in rooms randomly
     */
    private void generateRandomRoomItems() {
        //Returns a random number.
        //between 0 (inclusive) and 3 (exclusive).
        if (this.id <= 5) {
            int quantity = random.nextInt(3);
            for (int i = 0; i < quantity; i++) {
                addItem(Item.values()[random.nextInt(6)]);
            }
        } else if (this.id > 5) {
            int quantity = random.nextInt(6);
            for (int i = 0; i < quantity; i++) {
                addItem(Item.values()[random.nextInt(12)]);
            }
        }
    }

    /**
     * Adds item to room's item list
     * @param item
     */
    public void addItem(Item item) {
        if (item != null) {
            items.add(item);
        }
    }

    /**
     * Randomly generate normal monsters with a probability of 80%
     */
    public void generateRandomNormalMonsters() {
        int number = random.nextInt(100);
        if (number < 80) {
            addMonster(new Monster(this, (char) 123, Color.MAGENTA));
        }
    }

    /**
     * Adds monster to room's monster list
     * @param monster
     */
    public void addMonster(Monster monster) {
        if (monster != null) {
            monsters.add(monster);
        }
    }

    public void populateCoordinatePlane() {
//        System.out.println("populating plane");
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

    public String getRoomName() {
        return roomName;
    }

    @Override
    public String toString() {
        return roomName + " {" +
//                "coordinatePlane=" + Arrays.toString(coordinatePlane) +
                ", width=" + width +
                ", height=" + height +
                ", door=" + door +
                " }";
    }
}

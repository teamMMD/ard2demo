package com.mmd.util;

import com.mmd.environment.Room;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

public class MiniMapTest {
    public MiniMap miniMap;


    @Before
    public void setUp() throws Exception {
        miniMap = new MiniMap();
        for (int i = 0; i < 5; i++) {
            String testRoomName = "testRoom" + Integer.toString(i);
            Room testRoom = new Room(testRoomName);
            miniMap.addRoomToMiniMap(testRoom);
        }
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("\nTest run complete!");
    }

//    @Test
//    public void generateHashTest() {
//        System.out.println(miniMap.generateHash());
//    }

    @Ignore
    @Test
    public void addRoomToMiniMapTest() {
        System.out.println("adding room...");
        Room testRoom = new Room("hi");
        miniMap.addRoomToMiniMap(testRoom);
        miniMap.showMiniMap();
    }

//    @Test
//    public void linkRoomsTest() {
////        System.out.println("miniMap keySet: " + miniMap.miniMap.keySet());
//        miniMap.showMiniMap();
//        currentRoom = room.uuid;
//        miniMap.linkRooms(miniMap.miniMap.get);
//    }


}
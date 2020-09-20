package com.mmd.environment;

public class RoomFactory {

    private RoomFactory() {
    }

    public static Room createRoom() {
        Room room = null;
        room = new Room();
        return room;
    }

}

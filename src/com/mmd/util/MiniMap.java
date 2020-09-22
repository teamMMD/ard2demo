package com.mmd.util;

import com.mmd.environment.Room;

import java.util.HashMap;
import java.util.UUID;

public class MiniMap {
    public HashMap<String, Room> miniMap;
//    public UUID uuid;

    public MiniMap() {
        miniMap = new HashMap<>();
//        System.out.println("miniMap: " + miniMap);
    }

    public String generateHash() {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        return randomUUIDString;
//        UUID uuid = UUID.fromString(hashStr);
//        String uuidStr = uuid.toString();
//        return uuidStr;
    }

    public void addRoomToMiniMap(Room room) {
        String roomUUID = generateHash();
        miniMap.put(roomUUID, room);
    }

    public void connectRooms(String roomUUID) {
        System.out.println(miniMap.get(roomUUID));
    }

    public StringBuilder showMiniMap() {
        StringBuilder miniMapStr = new StringBuilder("{\n");
        miniMap.forEach((key, value) -> {
            System.out.print(key + ": ");
            System.out.println(value.toString());
            miniMapStr.append(key).append(": ").append(value).append("\n}");
        });
        return miniMapStr;
    }

    public void linkRooms(String roomUUID) {
        System.out.println(miniMap.get(roomUUID));
    }

}

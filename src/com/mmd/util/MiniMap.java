package com.mmd.util;

import com.mmd.environment.Room;

import java.util.HashMap;
import java.util.UUID;

public class MiniMap {
    public HashMap<String, Room> miniMap;

    public MiniMap() {
        miniMap = new HashMap<>();
        System.out.println("miniMap: " + miniMap);
    }

//    public generateHash() {
//        uuid = new UUID();
//    }
}

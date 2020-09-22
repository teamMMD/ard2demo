package com.mmd.environment;

import java.util.HashMap;
import java.util.Map;

public class MiniMap {
    public Map<Room, Map<String, Room>> miniMap;
    public Room start;

    public MiniMap() {
        miniMap = new HashMap<>();
        start = RoomFactory.createRoom();
        miniMap.put(start, new HashMap<>());
    }

}

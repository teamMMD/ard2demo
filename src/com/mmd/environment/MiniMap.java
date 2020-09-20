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


//{
//    start: {
//        north: room2,
//        south: null,
//        east: null,
//        west: null,
//        },
//    room2: {
//        north: room3,
//        south: start,
//        east: room4,
//        west: room5,
//        },
//    room3: {
//        north: room6,
//        south: room2,
//        east: room7,
//        west: room8,
//        }
//}

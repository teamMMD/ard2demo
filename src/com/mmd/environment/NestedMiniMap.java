package com.mmd.environment;

import java.util.HashMap;
import java.util.Map;

public class NestedMiniMap {
    public Map<Room, Map<String, Room>> miniMap;
    public Room start;

    public NestedMiniMap() {
        miniMap = new HashMap<>();
        start = RoomFactory.createRoom();
        miniMap.put(start, new HashMap<>());
    }

}


//{
//    uuid: {
//        ROOM: { ... room info ...}
//        },
//    uuid: {
//        ROOM2: { ... room info ...}
//        },
//    uuid: {
//        ROOM3: { ... room info ...}
//        }
//}

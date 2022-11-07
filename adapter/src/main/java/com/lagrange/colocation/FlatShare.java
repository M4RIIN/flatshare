package com.lagrange.colocation;

import java.util.List;


public class FlatShare {
    private List<Room> rooms;
    private String id;
    private List<Roomate> roomates;

    private final String name;
    public FlatShare(List<Room> rooms, String id, List<Roomate> roomates, String name) {
        this.rooms = rooms;
        this.id = id;
        this.roomates = roomates;
        this.name = name;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public String getId() {
        return id;
    }

    public List<Roomate> getRoomates() {
        return roomates;
    }

    public String getName() {
        return name;
    }
}

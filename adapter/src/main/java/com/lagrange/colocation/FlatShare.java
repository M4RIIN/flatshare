package com.lagrange.colocation;

import java.util.List;


public class FlatShare {
    private List<Room> rooms;
    private String id;
    private List<Roomate> roomates;

    public FlatShare(List<Room> rooms, String id, List<Roomate> roomates) {
        this.rooms = rooms;
        this.id = id;
        this.roomates = roomates;
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
}

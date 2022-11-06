package com.lagrange.colocation;

import java.util.List;

public class Room {
    private String type;
    private String scope;
    private List<Tache> task;

    public Room(String type, String scope, List<Tache> task) {
        this.type = type;
        this.scope = scope;
        this.task = task;
    }

    public String getType() {
        return type;
    }

    public String getScope() {
        return scope;
    }

    public List<Tache> getTask() {
        return task;
    }
}

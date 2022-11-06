package com.lagrange.colocation;

import java.util.List;

public class Roomate {
    private final String name;
    private final List<Tache> taches;

    public Roomate(String name, List<Tache> taches) {
        this.name = name;
        this.taches = taches;
    }

    public String getName() {
        return name;
    }

    public List<Tache> getTaches() {
        return taches;
    }
}

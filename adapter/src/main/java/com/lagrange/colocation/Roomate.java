package com.lagrange.colocation;

import java.util.List;

public class Roomate {
    private final String name;
    private final List<String> taches;

    public Roomate(String name, List<String> taches) {
        this.name = name;
        this.taches = taches;
    }

    public String getName() {
        return name;
    }

    public List<String> getTaches() {
        return taches;
    }
}

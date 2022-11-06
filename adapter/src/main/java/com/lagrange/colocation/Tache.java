package com.lagrange.colocation;

public class Tache {
    private final String nom;
    private final String scope;

    public Tache(String nom, String scope) {
        this.nom = nom;
        this.scope = scope;
    }

    public String getNom() {
        return nom;
    }

    public String getScope() {
        return scope;
    }
}
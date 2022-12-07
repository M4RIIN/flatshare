package com.lagrange.colocation;

public class Tache {
    private final String nom;
    private final String scope;

    private final String piece;

    public Tache(String nom, String scope, String piece) {
        this.nom = nom;
        this.scope = scope;
        this.piece = piece;
    }

    public String getNom() {
        return nom;
    }

    public String getScope() {
        return scope;
    }

    public String getPiece() {
        return piece;
    }
}
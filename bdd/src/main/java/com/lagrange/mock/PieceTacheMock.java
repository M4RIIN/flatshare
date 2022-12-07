package com.lagrange.mock;

import com.lagrange.entity.piece.TypePiece;
import com.lagrange.entity.tache.Tache;
import com.lagrange.port.piecetache.PieceTacheRepository;

import java.util.*;

public class PieceTacheMock implements PieceTacheRepository {

    private static Map<TypePiece,List<Tache>> bdd;
    static {
        bdd = new HashMap<>();
        bdd.put(TypePiece.CHAMBRE, Arrays.asList(
            new Tache("Passer aspirateur chambre", "chambre"),
            new Tache("Ranger chambre", "chambre"),
            new Tache("Changer draps", "chambre")
        ));
        bdd.put(TypePiece.CUISINE, Arrays.asList(
            new Tache("Nettoyer sol cuisine", "cuisine"),
            new Tache("Nettoyer plan de travail", "cuisine"),
            new Tache("Ranger cuisine", "cuisine")
        ));
        bdd.put(TypePiece.TOILETTES, Arrays.asList(
            new Tache("Nettoyer sol toilettes", "toilettes"),
            new Tache("Nettoyer toilettes", "toilettes")
        ));
        bdd.put(TypePiece.SALLE_DE_BAIN, Arrays.asList(
            new Tache("Nettoyer sol salle de bain", "salle de bain"),
            new Tache("Nettoyer douche/baignoire", "salle de bain"),
            new Tache("Nettoyer siphon", "salle de bain")
        ));
        bdd.put(TypePiece.SALON, Arrays.asList(
            new Tache("Nettoyer sol salon", "salon"),
            new Tache("Ranger salon", "salon"),
            new Tache("Nettoyer vitre salon", "salon"),
            new Tache("Enlever toiles araignées", "salon")
        ));
        bdd.put(TypePiece.ESCALIER, Arrays.asList(
            new Tache("Nettoyer sol escalier", "escalier")
        ));
    }

    @Override
    public List<Tache> getTacheLIstForTypePiece(TypePiece typePiece) {
        return bdd.get(typePiece);
    }
}

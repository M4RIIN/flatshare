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
            new Tache("Passer aspirateur chambre"),
            new Tache("Ranger chambre"),
            new Tache("Changer draps")
        ));
        bdd.put(TypePiece.CUISINE, Arrays.asList(
            new Tache("Nettoyer sol cuisine"),
            new Tache("Nettoyer plan de travail"),
            new Tache("Ranger cuisine")
        ));
        bdd.put(TypePiece.TOILETTES, Arrays.asList(
            new Tache("Nettoyer sol toilettes"),
            new Tache("Nettoyer toilettes")
        ));
        bdd.put(TypePiece.SALLE_DE_BAIN, Arrays.asList(
            new Tache("Nettoyer sol salle de bain"),
            new Tache("Nettoyer douche/baignoire"),
            new Tache("Nettoyer siphon")
        ));
        bdd.put(TypePiece.SALON, Arrays.asList(
            new Tache("Nettoyer sol salon"),
            new Tache("Ranger salon"),
            new Tache("Nettoyer vitre salon"),
            new Tache("Enlever toiles araignées")
        ));
        bdd.put(TypePiece.ESCALIER, Arrays.asList(
            new Tache("Nettoyer sol escalier")
        ));
    }

    @Override
    public List<Tache> getTacheLIstForTypePiece(TypePiece typePiece) {
        return bdd.get(typePiece);
    }
}

package com.lagrange.services;

import com.lagrange.entity.colocataire.Colocataire;
import com.lagrange.entity.colocation.Colocation;
import com.lagrange.entity.tache.Tache;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ShuffleCommuneTask {

    private Random random;

    public ShuffleCommuneTask() {

    }

    public Colocation apply(Colocation colocation){
        random = new Random(SEEDGENERATOR.getINSTANCE().GET_SEED());
        if(colocation.getColocataires().isEmpty()) return colocation;
        List<Tache> tachesDePieceCommunes = colocation.getTacheCommune();
        Collections.shuffle(tachesDePieceCommunes,random);
        Iterator<Tache> tacheIterator = tachesDePieceCommunes.listIterator();
        int nombreColocataire = colocation.getColocataires().size();
        int compteurTourWhile = 0;
        while (tacheIterator.hasNext()){
            int indexActuelColocataire = compteurTourWhile % nombreColocataire;
            Colocataire colocataireActuel = colocation.getColocataires().get(indexActuelColocataire);
            Tache tache = tacheIterator.next();
            tache.setColocataireId(colocataireActuel.getColocataireId());
            colocation.getColocataires().get(indexActuelColocataire).addTacheHebdomadaire(tache);
            compteurTourWhile++;
        }
        Colocation colocation1 = colocation.clone();
        return colocation1;
    }
}

package com.lagrange.services;

import com.lagrange.entity.colocation.Colocation;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.lagrange.usecase.colocation.ColocationFixture.*;
import static org.junit.jupiter.api.Assertions.*;

class ShuffleCommuneTaskTest {

    @Test
    void apply() {
        Colocation colocation = createPopulateColocation();
        long seed = 10;
       ShuffleCommuneTask shuffleCommuneTask = new ShuffleCommuneTask();
        Colocation colocationShuffled = shuffleCommuneTask.apply(colocation);
        assertEquals(List.of(addColocataireIDToTache(creerTacheNettoyerSol(),MARIN_ID)), colocationShuffled.getColocataires().get(0).getTachesHebdommadaire());
        assertEquals(List.of(addColocataireIDToTache(creerTacheFaireCuisine(),TOM_ID)), colocationShuffled.getColocataires().get(1).getTachesHebdommadaire());
    }

    private Colocation createPopulateColocation() {
        Colocation colocation = createColocation();
        colocation.addColocataire(createMarinColocataire(List.of(colocation.getPieces().get(1))));
        colocation.addColocataire(createTomColocataire(List.of(colocation.getPieces().get(2))));
        return colocation;
    }
}

package com.lagrange;

import com.lagrange.entity.colocataire.Colocataire;
import com.lagrange.entity.colocation.Colocation;
import com.lagrange.entity.piece.Piece;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.lagrange.usecase.colocation.ColocationFixture.*;
import static org.assertj.core.api.Assertions.assertThat;

 class ColocationTest {

    @Test
    void shouldGetMyColocation(){
        Colocation colocation = createColocation();
        assertThat(colocation.getPieces()).isEqualTo(List.of(addIdToPiece(cuisineCommune(),0),addIdToPiece(chambrePrivee(),1),addIdToPiece(chambrePrivee(),2)));
    }


     @Test
     void shouldAddColocataire(){
         Colocation colocation = createColocation();
         Colocataire colocataire = createMarinColocataire(List.of(colocation.getPieces().get(0)));
         colocation.addColocataire(colocataire);
         assertThat(colocation.getColocataires()).containsExactly(colocataire);
    }




 }

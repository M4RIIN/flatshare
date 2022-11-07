package com.lagrange.usecase.colocation;

import com.lagrange.entity.colocataire.Colocataire;
import com.lagrange.entity.colocataire.ColocataireId;
import com.lagrange.entity.colocation.Colocation;
import com.lagrange.entity.colocation.ColocationId;
import com.lagrange.entity.piece.Piece;
import com.lagrange.entity.piece.ScopePiece;
import com.lagrange.entity.piece.TypePiece;
import com.lagrange.entity.tache.Tache;

import java.util.List;
import java.util.UUID;

public final class ColocationFixture {

    public static UUID TOM_ID = UUID.randomUUID();
    public static UUID MARIN_ID = UUID.randomUUID();

    public ColocationFixture() {
    }

    public static Colocation createColocation(){
        return new Colocation(List.of(cuisineCommune(),chambrePrivee(),chambrePrivee()),colocationID(), "colocation");
    }

    public static Colocataire createTomColocataire(List<Piece> pieces){
        return new Colocataire(new ColocataireId(TOM_ID),"TOM",pieces);
    }

    public static Colocataire createMarinColocataire(List<Piece> pieces){
        return new Colocataire(new ColocataireId(MARIN_ID),"MARIN",pieces);
    }

    public static Piece cuisineCommune() {
        return new Piece(TypePiece.CUISINE, ScopePiece.COMMUNE, List.of(creerTacheNettoyerSol(), creerTacheFaireCuisine()));
    }

    public static Tache creerTacheFaireCuisine() {
        return new Tache("faire la cuisine");
    }

    public static Tache creerTacheNettoyerSol() {
        return new Tache("nettoyer sol");
    }

    public static Piece chambrePrivee() {
        return new Piece( TypePiece.CHAMBRE, ScopePiece.PRIVEE, List.of(creerTacheNettoyerSol()));
    }


    public static ColocationId colocationID() {
        return new  ColocationId(UUID.fromString("9b50f546-a3e0-449a-9eaa-95c437eb9b38"));
    }

    public static Piece addIdToPiece(Piece piece,int localId) {
        piece.attribuerLocalID(localId);
        return piece;
    }

    public static Tache addColocataireIDToTache(Tache tache, UUID uuid) {
        tache.setColocataireId(new ColocataireId(uuid));
        return tache;
    }
}

package com.lagrange.entity.colocataire;

import com.lagrange.entity.piece.Piece;
import com.lagrange.entity.tache.Tache;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ToString
@EqualsAndHashCode
public class Colocataire {
    private final String nom;
    private final ColocataireId colocataireId;
    private final List<Piece> piecesPersonnelles;
    private List<Tache> tachesHebdommadaire;


    public Colocataire(ColocataireId id, String nom, List<Piece> piecesPersonnelles) {
        assert Objects.nonNull(piecesPersonnelles);
        assert !piecesPersonnelles.isEmpty();
        this.colocataireId = id;
        this.nom = nom;
        this.piecesPersonnelles = piecesPersonnelles;
        tachesHebdommadaire = new ArrayList<>();
        updateResponsableTachePOurChaquePiece();
    }

    public ColocataireId getColocataireId() {
        return colocataireId;
    }

    private void updateResponsableTachePOurChaquePiece() {
        piecesPersonnelles.stream()
            .map(Piece::getTaches)
            .flatMap(List::stream)
            .forEach(tache -> tache.setColocataireId(colocataireId));
    }

    public List<Tache> getPersonnalTachesList(){
        return piecesPersonnelles.stream()
                    .map(Piece::getTaches)
                    .flatMap(List::stream)
                    .collect(Collectors.toList());
    }

    public List<Tache> getTachesList(){
        return Stream.concat(getPersonnalTachesList().stream(),
                tachesHebdommadaire.stream())
            .collect(Collectors.toList());
    }


    public List<Tache> getTachesHebdommadaire() {
        return tachesHebdommadaire;
    }

    public void resetTacheHebdomadaire(){
        this.tachesHebdommadaire = new ArrayList<>();
    }

    public void addTacheHebdomadaire(Tache tache){
        this.tachesHebdommadaire.add(tache);
    }

    public String getNom() {
        return nom;
    }
}

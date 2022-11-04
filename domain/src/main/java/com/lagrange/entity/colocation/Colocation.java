package com.lagrange.entity.colocation;

import com.lagrange.entity.colocataire.Colocataire;
import com.lagrange.entity.piece.Piece;
import com.lagrange.entity.piece.ScopePiece;
import com.lagrange.entity.tache.Tache;
import com.lagrange.services.ShuffleCommuneTask;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ToString
@EqualsAndHashCode
public class Colocation implements Cloneable {

    private final List<Piece> pieces;
    private final ColocationId colocationId;
    private List<Colocataire> colocataires;

    public Colocation(List<Piece> pieces, ColocationId colocationId) {
        assert colocationId != null;
        assert pieces != null;
        assert !pieces.isEmpty();
        this.colocationId = colocationId;
        this.pieces = pieces;
        this.colocataires = new ArrayList<>();
        pieces.forEach(p->{
            p.attribuerLocalID(pieces.indexOf(p));
        });
    }

    public ColocationId getColocationId() {
        return colocationId;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public List<Colocataire> getColocataires() {
        return colocataires;
    }

    public void addColocataire(Colocataire colocataire){
        assert Objects.nonNull(colocataire);
        this.colocataires.add(colocataire);
    }

    public List<Piece> getPieceCommunes(){
        return pieces.stream()
            .filter(p -> p.getScopePiece().equals(ScopePiece.COMMUNE))
            .collect(Collectors.toList());
    }

    public List<Tache> getTacheCommune(){
        return getPieceCommunes().stream()
            .map(Piece::getTaches)
            .flatMap(List::stream)
            .collect(Collectors.toList());
    }

    @Override
    public Colocation clone() {
        try {
            Colocation clone = (Colocation) super.clone();
            //this.colocataires.forEach(clone::addColocataire);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

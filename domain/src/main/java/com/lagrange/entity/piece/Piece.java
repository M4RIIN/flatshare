package com.lagrange.entity.piece;

import com.lagrange.entity.tache.Tache;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

@ToString
@EqualsAndHashCode
public class Piece {
    private final TypePiece typePiece;
    private final ScopePiece scopePiece;
    private final List<Tache> taches;
    private int localID;

    public Piece( TypePiece typePiece, ScopePiece scopePiece, List<Tache> taches) {
        this.typePiece = typePiece;
        this.scopePiece = scopePiece;
        this.taches = taches;

    }

    public List<Tache> getTaches() {
        return taches;
    }

    public TypePiece getTypePiece() {
        return typePiece;
    }

    public ScopePiece getScopePiece() {
        return scopePiece;
    }

    public void attribuerLocalID(int localID) {
        this.localID = localID;
    }
}

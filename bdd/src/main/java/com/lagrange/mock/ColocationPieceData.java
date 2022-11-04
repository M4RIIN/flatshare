package com.lagrange.mock;

import com.lagrange.entity.piece.ScopePiece;
import com.lagrange.entity.piece.TypePiece;

import java.util.UUID;

public class ColocationPieceData {
    TypePiece typePiece;
    ScopePiece scopePiece;
    UUID uuidColocation;

    public ColocationPieceData(TypePiece typePiece, ScopePiece scopePiece, UUID uuidColocation) {
        this.typePiece = typePiece;
        this.scopePiece = scopePiece;
        this.uuidColocation = uuidColocation;
    }
}

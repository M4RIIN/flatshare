package com.lagrange.mock;

import com.lagrange.entity.piece.TypePiece;

import java.lang.reflect.Type;
import java.util.UUID;

public class ColocatairePiece {
    UUID uuidColoc;
    TypePiece typePiece;

    public ColocatairePiece(UUID uuidColoc, TypePiece typePiece) {
        this.uuidColoc = uuidColoc;
        this.typePiece = typePiece;
    }
}

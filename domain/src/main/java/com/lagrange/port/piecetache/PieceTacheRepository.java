package com.lagrange.port.piecetache;

import com.lagrange.entity.piece.TypePiece;
import com.lagrange.entity.tache.Tache;

import java.util.List;

public interface PieceTacheRepository {

    List<Tache> getTacheLIstForTypePiece(TypePiece typePiece);
}

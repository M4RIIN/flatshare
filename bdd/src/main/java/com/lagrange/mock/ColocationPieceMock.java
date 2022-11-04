package com.lagrange.mock;

import com.lagrange.entity.colocation.ColocationId;
import com.lagrange.entity.piece.Piece;
import com.lagrange.entity.piece.ScopePiece;
import com.lagrange.entity.piece.TypePiece;
import com.lagrange.port.piecetache.PieceTacheRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ColocationPieceMock {

    static List<ColocationPieceData> colocationPieceDb = new ArrayList<>();
    static {
        colocationPieceDb.add(new ColocationPieceData(TypePiece.CUISINE, ScopePiece.COMMUNE, UUID.fromString("69e349a5-edca-49d7-8876-d2a5b78745ea")));
        colocationPieceDb.add(new ColocationPieceData(TypePiece.CHAMBRE, ScopePiece.PRIVEE, UUID.fromString("69e349a5-edca-49d7-8876-d2a5b78745ea")));
        colocationPieceDb.add(new ColocationPieceData(TypePiece.CHAMBRE, ScopePiece.PRIVEE, UUID.fromString("69e349a5-edca-49d7-8876-d2a5b78745ea")));
        colocationPieceDb.add(new ColocationPieceData(TypePiece.CHAMBRE, ScopePiece.PRIVEE, UUID.fromString("69e349a5-edca-49d7-8876-d2a5b78745ea")));
        colocationPieceDb.add(new ColocationPieceData(TypePiece.TOILETTES, ScopePiece.PRIVEE, UUID.fromString("69e349a5-edca-49d7-8876-d2a5b78745ea")));
        colocationPieceDb.add(new ColocationPieceData(TypePiece.TOILETTES, ScopePiece.PRIVEE, UUID.fromString("69e349a5-edca-49d7-8876-d2a5b78745ea")));
        colocationPieceDb.add(new ColocationPieceData(TypePiece.TOILETTES, ScopePiece.PRIVEE, UUID.fromString("69e349a5-edca-49d7-8876-d2a5b78745ea")));
        colocationPieceDb.add(new ColocationPieceData(TypePiece.SALLE_DE_BAIN, ScopePiece.PRIVEE, UUID.fromString("69e349a5-edca-49d7-8876-d2a5b78745ea")));
        colocationPieceDb.add(new ColocationPieceData(TypePiece.SALLE_DE_BAIN, ScopePiece.PRIVEE, UUID.fromString("69e349a5-edca-49d7-8876-d2a5b78745ea")));
        colocationPieceDb.add(new ColocationPieceData(TypePiece.SALLE_DE_BAIN, ScopePiece.PRIVEE, UUID.fromString("69e349a5-edca-49d7-8876-d2a5b78745ea")));
        colocationPieceDb.add(new ColocationPieceData(TypePiece.SALON, ScopePiece.COMMUNE, UUID.fromString("69e349a5-edca-49d7-8876-d2a5b78745ea")));

    }

    private final PieceTacheRepository pieceTacheRepository;

    public ColocationPieceMock(PieceTacheRepository pieceTacheRepository) {
        this.pieceTacheRepository = pieceTacheRepository;
    }


    List<Piece> getAllPieceForColocation(ColocationId colocationId){
        return colocationPieceDb.stream()
            .filter(elt -> elt.uuidColocation.equals(colocationId.getUuid()))
            .map(elt -> new Piece(elt.typePiece,elt.scopePiece,pieceTacheRepository.getTacheLIstForTypePiece(elt.typePiece)))
            .collect(Collectors.toList());
    }
}

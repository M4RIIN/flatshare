package com.lagrange.mock;

import com.lagrange.entity.piece.Piece;
import com.lagrange.entity.piece.ScopePiece;
import com.lagrange.entity.piece.TypePiece;
import com.lagrange.port.piecetache.PieceTacheRepository;

import java.util.*;
import java.util.stream.Collectors;

public class ColocatairePieceMock {
    static List<ColocatairePiece> list = new ArrayList<>();
    static {
        list.add(new ColocatairePiece(UUID.fromString("4a5b20ed-e3ee-4193-8c65-3c86ab9cc52d"),TypePiece.CHAMBRE));
        list.add(new ColocatairePiece(UUID.fromString("4a5b20ed-e3ee-4193-8c65-3c86ab9cc52d"),TypePiece.SALLE_DE_BAIN));
        list.add(new ColocatairePiece(UUID.fromString("4a5b20ed-e3ee-4193-8c65-3c86ab9cc52d"),TypePiece.TOILETTES));

        list.add(new ColocatairePiece(UUID.fromString("90fe40b7-8a96-41eb-ae1b-80c3cf57677b"),TypePiece.CHAMBRE));
        list.add(new ColocatairePiece(UUID.fromString("90fe40b7-8a96-41eb-ae1b-80c3cf57677b"),TypePiece.SALLE_DE_BAIN));
        list.add(new ColocatairePiece(UUID.fromString("90fe40b7-8a96-41eb-ae1b-80c3cf57677b"),TypePiece.TOILETTES));

        list.add(new ColocatairePiece(UUID.fromString("da4d42d5-4e8e-4cee-8d74-3f88ec9c78ce"),TypePiece.CHAMBRE));
        list.add(new ColocatairePiece(UUID.fromString("da4d42d5-4e8e-4cee-8d74-3f88ec9c78ce"),TypePiece.SALLE_DE_BAIN));
        list.add(new ColocatairePiece(UUID.fromString("da4d42d5-4e8e-4cee-8d74-3f88ec9c78ce"),TypePiece.TOILETTES));

        list.add(new ColocatairePiece(UUID.fromString("1fbd1070-072d-4b88-b385-ede53a570265"),TypePiece.CHAMBRE));
        list.add(new ColocatairePiece(UUID.fromString("1fbd1070-072d-4b88-b385-ede53a570265"),TypePiece.SALLE_DE_BAIN));
        list.add(new ColocatairePiece(UUID.fromString("1fbd1070-072d-4b88-b385-ede53a570265"),TypePiece.TOILETTES));
    }

    private final PieceTacheRepository pieceTacheMock;

    public ColocatairePieceMock(PieceTacheRepository pieceTacheMock) {
        this.pieceTacheMock = pieceTacheMock;
    }

    public List<Piece> getPieceForColocataire(UUID uuid){
        return list.stream()
            .filter(elt -> elt.uuidColoc.equals(uuid))
            .map(elt -> new Piece(elt.typePiece, ScopePiece.PRIVEE,pieceTacheMock.getTacheLIstForTypePiece(elt.typePiece)))
            .collect(Collectors.toList());
    }
}

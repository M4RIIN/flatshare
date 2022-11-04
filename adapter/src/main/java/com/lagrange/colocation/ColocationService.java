package com.lagrange.colocation;

import com.lagrange.entity.colocataire.Colocataire;
import com.lagrange.entity.colocation.Colocation;
import com.lagrange.entity.colocation.ColocationId;
import com.lagrange.entity.piece.Piece;
import com.lagrange.entity.tache.Tache;
import com.lagrange.usecase.colocation.IGetColocationById;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ColocationService implements IColocationService {

    private final IGetColocationById getColocationById;

    public ColocationService(IGetColocationById getColocationById) {
        this.getColocationById = getColocationById;
    }

    @Override
    public FlatShare getFlatShareById(String id){
        Colocation colocation = getColocationById.getColocation(new ColocationId(UUID.fromString(id)));
        return mapColocationToFlatSHare(colocation);
    }

    private FlatShare mapColocationToFlatSHare(Colocation colocation) {
        return new FlatShare(colocation.getPieces().stream()
            .map(this::mapPieceToRoom).collect(Collectors.toList()), colocation.getColocationId().getUuid().toString(), getRoomates(colocation));
    }

    private List<Roomate> getRoomates(Colocation colocation) {
        return colocation.getColocataires().stream()
            .map(elt -> new Roomate(elt.getNom(), getTachesCollocataire(elt)))
            .collect(Collectors.toList());
    }

    private List<String> getTachesCollocataire(Colocataire elt) {
        return elt.getTachesList().stream().map(Tache::getLibelle).collect(Collectors.toList());
    }

    private Room mapPieceToRoom(Piece piece) {
        return new Room(piece.getTypePiece().name(), piece.getScopePiece().name(), mapTache(piece));
    }

    private List<String> mapTache(Piece piece) {
        return piece.getTaches().stream().map(Tache::getLibelle).collect(Collectors.toList());
    }
}

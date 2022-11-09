package com.lagrange.colocation;

import com.lagrange.entity.colocataire.Colocataire;
import com.lagrange.entity.colocation.Colocation;
import com.lagrange.entity.colocation.ColocationId;
import com.lagrange.entity.piece.Piece;
import com.lagrange.entity.tache.Tache;
import com.lagrange.services.ShuffleCommuneTask;
import com.lagrange.usecase.colocation.GetAllColocation;
import com.lagrange.usecase.colocation.IGetColocationById;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ColocationService implements IColocationService {

    private final IGetColocationById getColocationById;
    private final GetAllColocation getAllColocation;
    private final ShuffleCommuneTask shuffleCommuneTask;

    public ColocationService(IGetColocationById getColocationById, GetAllColocation getAllColocation, ShuffleCommuneTask shuffleCommuneTask) {
        this.getColocationById = getColocationById;
        this.getAllColocation = getAllColocation;
        this.shuffleCommuneTask = shuffleCommuneTask;
    }

    @Override
    public FlatShare getFlatShareById(String id){
        Colocation colocation = getColocationById.getColocation(new ColocationId(UUID.fromString(id)));
        return mapColocationToFlatSHare(colocation);
    }

    @Override
    public void shuffleCommuneTaskForEveryFlatshare() {
        getAllColocation.apply().forEach(shuffleCommuneTask::apply);
    }

    private FlatShare mapColocationToFlatSHare(Colocation colocation) {
        return new FlatShare(colocation.getPieces().stream()
            .map(this::mapPieceToRoom).collect(Collectors.toList()), colocation.getColocationId().getUuid().toString(), getRoomates(colocation), colocation.getName());
    }

    private List<Roomate> getRoomates(Colocation colocation) {
        return colocation.getColocataires().stream()
            .map(elt -> new Roomate(elt.getNom(), mapTacheWithOwner(elt,colocation.getPieces())))
            .collect(Collectors.toList());
    }

    private List<com.lagrange.colocation.Tache> mapTacheWithOwner(Colocataire elt,List<Piece> pieces) {
        return getTachesCollocataire(elt).stream().map(t -> new com.lagrange.colocation.Tache(t.getLibelle(), getScopeOfTache(t.getLibelle(),pieces))).collect(Collectors.toList());
    }

    private String getScopeOfTache(String tache,List<Piece> pieces){
     return  pieces.stream()
                .filter(p -> p.getTaches().stream().map(Tache::getLibelle).collect(Collectors.toList()).contains(tache))
                .findFirst()
                .map(elt -> elt.getScopePiece().name())
             .orElse("error");
    }

    private List<Tache> getTachesCollocataire(Colocataire elt) {
        return elt.getTachesList();
    }

    private Room mapPieceToRoom(Piece piece) {
        return new Room(piece.getTypePiece().name(), piece.getScopePiece().name(), mapTache(piece));
    }

    private List<com.lagrange.colocation.Tache> mapTache(Piece piece) {
        return piece.getTaches().stream().map(elt -> new com.lagrange.colocation.Tache(elt.getLibelle(),piece.getScopePiece().name())).collect(Collectors.toList());
    }
}

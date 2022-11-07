package com.lagrange.mock;

import com.lagrange.entity.colocation.Colocation;
import com.lagrange.entity.colocation.ColocationId;
import com.lagrange.port.colocation.ColocationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ColocationMock implements ColocationRepository {

    private static List<ColocationData> colocationDb = new ArrayList<>();
    static {
        colocationDb.add(new ColocationData(
                UUID.fromString("69e349a5-edca-49d7-8876-d2a5b78745ea"),
                "Lagrange"));
    }

    private final ColocationPieceMock colocationPieceMock;
    private final ColocataireMock colocataireMock;

    public ColocationMock(ColocationPieceMock colocationPieceMock, ColocataireMock colocataireMock) {
        this.colocationPieceMock = colocationPieceMock;
        this.colocataireMock = colocataireMock;
    }

    @Override
    public Colocation getColocationById(ColocationId colocationId) {
       Colocation colocation =  new Colocation(colocationPieceMock.getAllPieceForColocation(colocationId),colocationId, getColocationNameById(colocationId).getColocationName());
       colocataireMock.getColocataireByUUIDColocation(colocation.getColocationId().getUuid())
               .forEach(colocation::addColocataire);
       return colocation;
    }

    private static ColocationData getColocationNameById(ColocationId colocationId) {
        return colocationDb.stream().filter(elt -> elt.getUuidColocation().equals(colocationId.getUuid())).findFirst().orElseThrow();
    }
}

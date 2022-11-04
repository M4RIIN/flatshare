package com.lagrange.mock;

import com.lagrange.entity.colocataire.Colocataire;
import com.lagrange.entity.colocataire.ColocataireId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class ColocataireMock {

    static Map<UUID, List<ColocataireData>> colocataireMap = new HashMap<>();
    static {
        colocataireMap.put(UUID.fromString("69e349a5-edca-49d7-8876-d2a5b78745ea"),List.of(
            new ColocataireData(UUID.fromString("4a5b20ed-e3ee-4193-8c65-3c86ab9cc52d"),"marin"),
            new ColocataireData(UUID.fromString("90fe40b7-8a96-41eb-ae1b-80c3cf57677b"),"tom"),
            new ColocataireData(UUID.fromString("da4d42d5-4e8e-4cee-8d74-3f88ec9c78ce"),"louis")
        ));
    }

    private final ColocatairePieceMock colocatairePieceMock;

    public ColocataireMock(ColocatairePieceMock colocatairePieceMock) {
        this.colocatairePieceMock = colocatairePieceMock;
    }

    public List<Colocataire> getColocataireByUUIDColocation(UUID uuidColocation){
        return colocataireMap.get(uuidColocation).stream()
            .map(elt -> new Colocataire(new ColocataireId(elt.uuid), elt.nom,colocatairePieceMock.getPieceForColocataire(elt.uuid) ))
            .collect(Collectors.toList());
    }
}

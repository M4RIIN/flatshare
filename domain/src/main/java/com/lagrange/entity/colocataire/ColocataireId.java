package com.lagrange.entity.colocataire;

import lombok.EqualsAndHashCode;

import java.util.Objects;
import java.util.UUID;
@EqualsAndHashCode
public class ColocataireId {
    private final UUID id;

    public ColocataireId(UUID id) {
        assert Objects.nonNull(id);
        this.id = id;
    }
}

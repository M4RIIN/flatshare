package com.lagrange.entity.tache;

import com.lagrange.entity.colocataire.ColocataireId;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Objects;
import java.util.Optional;

@ToString
@EqualsAndHashCode
public class Tache {
    private final String libelle;
    private Optional<ColocataireId> colocataireId;

    public Tache(String libelle) {
        this.libelle = libelle;
        colocataireId = Optional.empty();
    }

    public String getLibelle() {
        return libelle;
    }

    public Optional<ColocataireId> getColocataireId() {
        return colocataireId;
    }

    public void setColocataireId(ColocataireId colocataireId) {
        assert Objects.nonNull(colocataireId);
        this.colocataireId = Optional.of(colocataireId);
    }
}

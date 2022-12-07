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

    private final String piece;
    private Optional<ColocataireId> colocataireId;

    public Tache(String libelle, String piece) {
        this.libelle = libelle;
        this.piece = piece;
        colocataireId = Optional.empty();
    }

    public String getPiece() {
        return piece;
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

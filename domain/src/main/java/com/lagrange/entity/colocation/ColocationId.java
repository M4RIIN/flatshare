package com.lagrange.entity.colocation;

import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode
public class ColocationId {
    private UUID uuid;
    public ColocationId(UUID uuid) {
        assert uuid != null;
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }
}

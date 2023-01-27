package com.lagrange.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity(name = "colocation")
public class ColocationEntity {

    @Id
    UUID uuid;

    @Column
    String name;

    public ColocationEntity(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public ColocationEntity() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }
}

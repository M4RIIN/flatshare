package com.lagrange.mock;

import java.util.UUID;

public class ColocationData {
    UUID uuidColocation;
    String ColocationName;

    public ColocationData(UUID uuidColocation, String colocationName) {
        this.uuidColocation = uuidColocation;
        ColocationName = colocationName;
    }

    public UUID getUuidColocation() {
        return uuidColocation;
    }

    public String getColocationName() {
        return ColocationName;
    }
}

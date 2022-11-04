package com.lagrange.port.colocation;

import com.lagrange.entity.colocation.Colocation;
import com.lagrange.entity.colocation.ColocationId;

public interface ColocationRepository {

    Colocation getColocationById(ColocationId colocationId);
}

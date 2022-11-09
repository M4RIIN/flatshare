package com.lagrange.port.colocation;

import com.lagrange.entity.colocation.Colocation;
import com.lagrange.entity.colocation.ColocationId;

import java.util.List;

public interface ColocationRepository {

    Colocation getColocationById(ColocationId colocationId);

    List<Colocation> getAll();
}

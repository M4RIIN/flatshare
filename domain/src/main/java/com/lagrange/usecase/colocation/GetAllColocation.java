package com.lagrange.usecase.colocation;

import com.lagrange.entity.colocation.Colocation;

import java.util.List;

public interface GetAllColocation {
    List<Colocation> apply();
}

package com.lagrange.usecase.colocation;

import com.lagrange.entity.colocation.Colocation;
import com.lagrange.port.colocation.ColocationRepository;

import java.util.List;

public class GetAllColocationImpl implements GetAllColocation {
    private final ColocationRepository colocationRepository;

    public GetAllColocationImpl(ColocationRepository colocationRepository) {
        this.colocationRepository = colocationRepository;
    }

    @Override
    public List<Colocation> apply() {
        return colocationRepository.getAll();
    }
}

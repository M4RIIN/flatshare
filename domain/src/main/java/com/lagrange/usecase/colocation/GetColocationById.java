package com.lagrange.usecase.colocation;

import com.lagrange.entity.colocation.Colocation;
import com.lagrange.entity.colocation.ColocationId;
import com.lagrange.port.colocation.ColocationRepository;
import com.lagrange.services.ShuffleCommuneTask;

public class GetColocationById implements IGetColocationById {

    private final ColocationRepository colocationRepository;
    private ShuffleCommuneTask shuffleCommuneTask;

    public GetColocationById(ColocationRepository colocationRepository) {
        this.colocationRepository = colocationRepository;
    }

    @Override
    public Colocation getColocation(ColocationId colocationId){
        shuffleCommuneTask =  new ShuffleCommuneTask(150); // TODO ENORME TRICHE
        //return colocationRepository.getColocationById(colocationId);
        //TODO UNIQUEMENT POUR TESTER
        Colocation colocation = colocationRepository.getColocationById(colocationId);
        return shuffleCommuneTask.apply(colocation);
    }
}

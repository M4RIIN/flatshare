package com.lagrange.springconfig.config;


import com.lagrange.colocation.ColocationService;
import com.lagrange.colocation.IColocationService;
import com.lagrange.mock.*;
import com.lagrange.port.colocation.ColocationRepository;
import com.lagrange.port.piecetache.PieceTacheRepository;
import com.lagrange.services.SEEDGENERATOR;
import com.lagrange.services.ShuffleCommuneTask;
import com.lagrange.springcontrollers.ColocationController;
import com.lagrange.springcontrollers.TacheController;
import com.lagrange.usecase.colocation.GetAllColocation;
import com.lagrange.usecase.colocation.GetAllColocationImpl;
import com.lagrange.usecase.colocation.GetColocationById;
import com.lagrange.usecase.colocation.IGetColocationById;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
//@EnableJpaRepositories("")
@EntityScan("com.lagrange.entity")
public class Config  {

    @Bean
    public PieceTacheRepository pieceTacheRepository(){
        return new PieceTacheMock();
    }

    @Bean
    public ColocationPieceMock colocationPieceMock(PieceTacheRepository pieceTacheRepository){
        return new ColocationPieceMock(pieceTacheRepository);
    }
    @Bean
    public ColocatairePieceMock colocatairePieceMock(PieceTacheRepository pieceTacheRepository){
        return new ColocatairePieceMock(pieceTacheRepository);
    }
    @Bean
    public ColocataireMock colocataireMock(ColocatairePieceMock colocatairePieceMock){
        return new ColocataireMock(colocatairePieceMock);
    }

    @Bean
    public ColocationRepository colocationRepository(ColocationPieceMock colocationPieceMock,ColocataireMock colocataireMock){
        return new ColocationMock(colocationPieceMock, colocataireMock);
    }

    @Bean
    public IGetColocationById getColocationById(ColocationRepository colocationRepository){
        return new GetColocationById(colocationRepository);
    }

    @Bean
    public GetAllColocation getAllColocation(ColocationRepository colocationRepository){
        return new GetAllColocationImpl(colocationRepository);
    }

    @Bean
    public ShuffleCommuneTask shuffleCommuneTask(){
        SEEDGENERATOR.getINSTANCE();
        return new ShuffleCommuneTask();
    }
    @Bean
    public IColocationService colocationService(IGetColocationById getColocationById,GetAllColocation getAllColocation,ShuffleCommuneTask shuffleCommuneTask){
        return new ColocationService(getColocationById, getAllColocation, shuffleCommuneTask);
    }

    @Bean
    public ColocationController colocationController(IColocationService colocationService){
        return new ColocationController(colocationService);
    }

    @Bean
    public TacheController tacheController(IColocationService colocationService){
        return new TacheController(colocationService);
    }

}

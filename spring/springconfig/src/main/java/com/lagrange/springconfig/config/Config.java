package com.lagrange.springconfig.config;


import com.lagrange.colocation.ColocationService;
import com.lagrange.colocation.IColocationService;
import com.lagrange.mock.*;
import com.lagrange.port.colocation.ColocationRepository;
import com.lagrange.port.piecetache.PieceTacheRepository;
import com.lagrange.springcontrollers.ColocationController;
import com.lagrange.usecase.colocation.GetColocationById;
import com.lagrange.usecase.colocation.IGetColocationById;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
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
    public IColocationService colocationService(IGetColocationById getColocationById){
        return new ColocationService(getColocationById);
    }
    @Bean
    public ColocationController colocationController(IColocationService colocationService){
        return new ColocationController(colocationService);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:8080")
                    .allowedMethods("PUT", "DELETE", "GET", "POST");
            }
        };
    }

}

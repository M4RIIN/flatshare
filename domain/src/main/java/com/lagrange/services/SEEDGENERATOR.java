package com.lagrange.services;

public class SEEDGENERATOR {

    private static SEEDGENERATOR INSTANCE = null;

    private static long SEED = 120;

    private SEEDGENERATOR(){

    }

    public static SEEDGENERATOR getINSTANCE(){
        if(INSTANCE == null){
            INSTANCE = new SEEDGENERATOR();
        }
        return INSTANCE;
    }

    public long GET_SEED(){
        return SEED;
    }

    public void changeSEED(){
        SEED = SEED + SEED;
    }
}

package com.lagrange;

import com.lagrange.colocation.ColocationService;

public class ConsoleView {
    private final ColocationService colocationService;

    public ConsoleView(ColocationService colocationService) {
        this.colocationService = colocationService;
    }

    public  void start(){
        System.out.println("-----Start-----");
        System.out.println(colocationService.getFlatShareById("69e349a5-edca-49d7-8876-d2a5b78745ea"));
    }
}

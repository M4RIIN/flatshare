package com.lagrange.springcontrollers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledAttributionTask {


    //@Scheduled(cron = "0 0 12 0 * MON" , zone = "Europe/Paris")
    //@Scheduled(cron = "0 56 15 * * WED", zone = "Europe/Paris")
    public void apply(){
        System.out.println("wesssssshhhhhhhhh");
    }


}

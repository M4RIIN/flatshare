package com.lagrange.springconfig;

import com.lagrange.colocation.IColocationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTaskAttributor {
    private final IColocationService colocationService;

    public ScheduledTaskAttributor(IColocationService colocationService) {
        this.colocationService = colocationService;
    }

    @Scheduled(cron = "0 0 8 * * MON", zone = "Europe/Paris")
    public void apply(){
        colocationService.shuffleCommuneTaskForEveryFlatshare();
        System.out.println("TÂCHES COMMUNES RÉATTRIBUÉES");
    }
}

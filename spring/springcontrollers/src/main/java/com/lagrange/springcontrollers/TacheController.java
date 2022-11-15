package com.lagrange.springcontrollers;

import com.lagrange.colocation.FlatShare;
import com.lagrange.colocation.IColocationService;
import com.lagrange.services.SEEDGENERATOR;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TacheController {

    private final IColocationService colocationService;

    @GetMapping(path = "tasks")
    public void reload(){
        SEEDGENERATOR.getINSTANCE().changeSEED();
        //colocationService.shuffleCommuneTaskForEveryFlatshare();
         System.out.println("TÂCHES COMMUNES RÉATTRIBUÉES");
    }
}

package com.lagrange.springcontrollers;

import com.lagrange.colocation.FlatShare;
import com.lagrange.colocation.IColocationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@CrossOrigin
public class ColocationController  {

    private final IColocationService colocationService;
    @GetMapping(path = "colocation")
    public FlatShare getByUuid(@RequestParam("uuid") String uuid){
        return colocationService.getFlatShareById(uuid);
    }
}

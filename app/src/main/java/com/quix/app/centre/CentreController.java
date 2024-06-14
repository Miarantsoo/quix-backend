package com.quix.app.centre;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/centres")
public class CentreController {

    @Autowired
    private CentreService centreService;

    @GetMapping
    public List<Centre> getAllCentres(){
        return centreService.getAllCentres();
    }
}
package com.quix.app.centre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/centres")
public class CentreController {
    
    @Autowired
    private CentreService centreService;

    @PostMapping
    public Centre addCentre(@RequestBody Centre centre) {
        return centreService.addCentre(centre);
    }
}


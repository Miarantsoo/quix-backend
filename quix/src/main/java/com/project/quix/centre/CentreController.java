package com.project.quix.centre;

import com.project.quix.tierces.TypeClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/centres")
public class CentreController {
    private final CentreService servCentre;

    public CentreController(CentreService servCentre){
        this.servCentre = servCentre;
    }

    @GetMapping("/get-all-centre")
    public List<Centre> getAllCentre() {
        return servCentre.getAllCentre();
    }
    
}

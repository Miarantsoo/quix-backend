package com.quix.app.rendezVous;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rendezvous")
public class RendezVousController {

    @Autowired
    private RendezVousService rendezVousService;

    @PostMapping
    public RendezVous createRendezVous(@RequestBody RendezVous rendezVous) {
        return rendezVousService.saveRendezVous(rendezVous);
    }
}

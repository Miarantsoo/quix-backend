package com.project.quix.rendezVous;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RendezVousController {

    @Autowired
    public RendezVousService rendezVousService;
}

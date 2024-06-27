package com.project.quix.rendezVous;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RendezVousService {

    @Autowired
    public RendezVousRepository rendezVousRepository;
}

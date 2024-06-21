package com.quix.app.centre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CentreService {
    
    @Autowired
    private CentreRepository centreRepository;

    public Centre addCentre(Centre centre) {
        return centreRepository.save(centre);
    }
}


package com.project.quix.parrainage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParrainageService {

    private final ParrainageRepository repo ;

    public ParrainageService(ParrainageRepository repo) {
        this.repo = repo;
    }
}

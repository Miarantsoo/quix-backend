package com.quix.app.centre;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CentreService {

    @Autowired
    private CentreRepository centreRepository;

    public List<Centre> getAllCentres(){
        return centreRepository.findAll();
    }
}
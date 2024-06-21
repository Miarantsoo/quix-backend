package com.quix.app.misajour;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/miseajour")
public class MiseAJourController {

    @Autowired
    private MiseAJourService miseajourService;

    @GetMapping
    public List<MiseAJour> getAllUtilisateurs(){
        return miseajourService.getAllMiseAJours();
    }
}
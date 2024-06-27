package com.project.quix.typeconsultation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/typeConsultations")
public class TypeConsultationController {

    @Autowired
    private TypeConsultationService typeConsulationService;

    @GetMapping
    public List<TypeConsultation> getAllCentres(){
        return typeConsulationService.getAllCentres();
    }
}
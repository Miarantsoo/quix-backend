package com.quix.app.consultation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultations")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    @PostMapping
    public Consultation createConsultation(@RequestBody Consultation consultation) {
        return consultationService.saveConsultation(consultation);
    }
}
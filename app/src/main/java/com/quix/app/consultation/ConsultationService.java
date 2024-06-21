package com.quix.app.consultation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
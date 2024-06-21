package com.quix.app.typeconsultation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeConsultationService {

    @Autowired
    private TypeConsultationRepository typeConsultationRepository;

    public List<TypeConsultation> getAllCentres(){
        return typeConsultationRepository.findAll();
    }
}
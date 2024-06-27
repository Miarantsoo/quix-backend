package com.project.quix.consulation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultationService {

    @Autowired
    public ConsultationRepository consultationRepository;

}

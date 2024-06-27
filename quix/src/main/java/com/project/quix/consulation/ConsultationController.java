package com.project.quix.consulation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsultationController {

    @Autowired
    public ConsultationService consultationService;

}

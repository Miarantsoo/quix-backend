package com.project.quix.dashboard.model;

import com.project.quix.consulation.Consultation;
import com.project.quix.consulation.ConsultationRepository;
import com.project.quix.consulation.ConsultationService;
import com.project.quix.rendezVous.RendezVous;
import com.project.quix.rendezVous.RendezVousRepository;
import com.project.quix.rendezVous.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {
    @Autowired
    RendezVousRepository rendezVousRepository;
    @Autowired
    ConsultationRepository consultationRepo;
    public DashboardComponents getDashboard(DateIntervalDTO dateIntervalDTO){
        DashboardComponents dashboardComponents = new DashboardComponents();
        dashboardComponents.setRendezVous(rendezVousRepository.findRdvBetween(dateIntervalDTO.getDate1(),dateIntervalDTO.getDate2()).toArray(new RendezVous[0]));
        dashboardComponents.setConsultation(consultationRepo.findBetween(dateIntervalDTO.getDate1(),dateIntervalDTO.getDate2()).toArray(new Consultation[0]));
        return dashboardComponents;
    }
}

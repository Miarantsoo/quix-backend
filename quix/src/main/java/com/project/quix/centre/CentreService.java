package com.project.quix.centre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CentreService {

    private final CentreRepository repoCentre;
    public CentreService(CentreRepository repoCentre){
        this.repoCentre = repoCentre;
    }

    public List<Centre> getAllCentre(){
        return repoCentre.findAllCentres();
    }

}
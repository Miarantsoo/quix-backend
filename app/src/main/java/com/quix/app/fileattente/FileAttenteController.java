package com.quix.app.fileattente;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.quix.app.utilisateur.Utilisateur;
import com.quix.app.utilisateur.UtilisateurService;

@RestController
@RequestMapping("/api/fileAttentes")
public class FileAttenteController {

    @Autowired
    private FileAttenteService fileAttenteService;
    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping
    public List<FileAttente> getAllCentres(){
        return fileAttenteService.getAllCentres();
    }

    @PostMapping("/redirection")
    public void redirection(@RequestParam("idFile") Long idFile , @RequestParam("idNewMedecin") Long idNewMedecin){
        LocalDateTime dateFin = LocalDateTime.now();

        fileAttenteService.addDateFinToFile(idFile, dateFin);

        Optional<FileAttente> fileAttente = fileAttenteService.findByIdFile(idFile);
        Optional<Utilisateur> newMedecin = utilisateurService.findByIdUtilisateur(idNewMedecin);

        if(fileAttente.isPresent() && newMedecin.isPresent()){
            FileAttente attente = fileAttente.get();
            Utilisateur medecin = newMedecin.get();

            FileAttente newFile = new FileAttente();
            newFile.setDateDebut(dateFin);
            newFile.setMedecin(medecin);
            newFile.setPatient(attente.getPatient());
            newFile.setTypeConsultation(attente.getTypeConsultation());
            Long maxNum = fileAttenteService.findMaxNumeroFile();
            newFile.setNumeroFile(maxNum==null ? 1 : maxNum+1);

            fileAttenteService.addFileAttente(newFile);
        }
    }
}
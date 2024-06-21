package com.quix.app.fileattente;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileAttenteService {

    @Autowired
    private FileAttenteRepository fileAttenteRepository;

    public List<FileAttente> getAllCentres(){
        return fileAttenteRepository.findAll();
    }

    public void addDateFinToFile(Long idFile , LocalDateTime dateFin){
        fileAttenteRepository.addDateFinToFile(idFile, dateFin);
    }

    public Optional<FileAttente> findByIdFile(Long idFile){
        Optional<FileAttente> fileAttente = fileAttenteRepository.findByIdFile(idFile);
        return fileAttente;
    }

    public Long findMaxNumeroFile(){
        return fileAttenteRepository.findMaxNumeroFile();
    }

    public void addFileAttente(FileAttente fileAttente){
        fileAttenteRepository.save(fileAttente);
    }
}
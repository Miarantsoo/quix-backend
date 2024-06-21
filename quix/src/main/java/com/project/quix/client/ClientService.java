package com.project.quix.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository repoClient;

    public ClientService(ClientRepository repoClient) {
        this.repoClient = repoClient;
    }

    public List<Client> getAllClientbyType(int type){
        return repoClient.findClientByType(type);
    }

    public List<Client> getClientByName(int type, String recherche){
        return repoClient.searchPatientByName(type, recherche);
    }
}

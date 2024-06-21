package com.project.quix.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    private final ClientService servClient;

    public ClientController(ClientService servClient) {
        this.servClient = servClient;
    }

    @GetMapping("/get-all-client")
    public List<Client> getClientByType(@RequestParam("typeClient") int type){
        return servClient.getAllClientbyType(type);
    }

    @PostMapping("/search-client")
    public List<Client> searchClientByName(@RequestParam("typeClient") int type, @RequestParam("recherche") String recherche){
        return servClient.getClientByName(type, recherche);
    }
}

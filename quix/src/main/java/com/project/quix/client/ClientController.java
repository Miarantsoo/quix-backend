package com.project.quix.client;

import com.project.quix.tierces.TypeClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService servClient;

    public ClientController(ClientService servClient) {
        this.servClient = servClient;
    }

    @PostMapping("/get-all-client")
    @ResponseBody
    public List<Client> getClientByType(@RequestBody TypeClient type){
        return servClient.getAllClientbyType(type.getTypeClient());
    }

    @PostMapping("/search-client")
    @ResponseBody
    public List<Client> searchClientByName(@RequestParam("typeClient") int type, @RequestParam("recherche") String recherche){
        return servClient.getClientByName(type, recherche);
    }
}

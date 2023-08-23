package com.example.mid_project.Controllers;


import com.example.mid_project.Models.Client;
import com.example.mid_project.Services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;



    @GetMapping("/get")
    public List<Client> getAllClients(){
        return clientService.getAll();
    }

    @GetMapping("/update/{id}")
    public ResponseEntity clientUpdate(@PathVariable Integer id, Client client){

        clientService.updateClient(client, id);
        return ResponseEntity.status(200).body("Client Updated Successfully");
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity clientDelete(@PathVariable Integer id){
        clientService.deleteClient(id);
        return ResponseEntity.status(200).body("Client Deleted Successfully");
    }

    @PostMapping("/add")
    public ResponseEntity clientAdd(@RequestBody Client client){
        clientService.addClient(client);
        return ResponseEntity.status(200).body("Client Added Successfully");
    }

    @GetMapping("/get/{id}")
    public Client getClientById(@PathVariable Integer id){
        return clientService.getClientById(id);
    }

}

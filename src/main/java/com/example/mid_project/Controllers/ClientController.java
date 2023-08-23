package com.example.mid_project.Controllers;


import com.example.mid_project.APIs.ApiResponse;
import com.example.mid_project.Models.Client;
import com.example.mid_project.Models.Project;
import com.example.mid_project.Services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/client")
public class ClientController {

    private final ClientService clientService;


    @GetMapping("/get")
    public List<Client> getAllClients() {
        return clientService.getAll();
    }

    @GetMapping("/update/{id}")
    public ResponseEntity clientUpdate(@PathVariable Integer id, Client client) {

        clientService.updateClient(client, id);
        return ResponseEntity.status(200).body(new ApiResponse("Client Updated Successfully"));
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity clientDelete(@PathVariable Integer id) {
        clientService.deleteClient(id);
        return ResponseEntity.status(200).body(new ApiResponse("Client Deleted Successfully"));
    }

    @PostMapping("/add")
    public ResponseEntity clientAdd(@RequestBody Client client) {
        clientService.addClient(client);
        return ResponseEntity.status(200).body(new ApiResponse("Client Added Successfully"));
    }

    @GetMapping("/get/{id}")
    public Client getClientById(@PathVariable Integer id) {
        return clientService.getClientById(id);
    }

    @GetMapping("/search/provider/{name}")
    public ResponseEntity searchForProviderByName(@PathVariable String name) {
        return ResponseEntity.status(200).body(clientService.getProviderByName(name));
    }


    @PostMapping("/add/project/{clientID}")
    public ResponseEntity addNewProject(@PathVariable Integer clientID, @RequestBody Project project) {
        clientService.addNewProject(clientID, project);
        return ResponseEntity.status(200).body(new ApiResponse("Project Added Successfully"));
    }

    @GetMapping("/requests/{id}")
    public ResponseEntity getProjectRequests(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(clientService.getProjectRequests(id));
    }

    @PutMapping("/accept/request/{id}")
    public ResponseEntity acceptRequest(@PathVariable Integer id) {
        clientService.acceptRequest(id);
        return ResponseEntity.status(200).body(new ApiResponse("request accepted Successfully"));
    }


}

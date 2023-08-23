package com.example.mid_project.Services;

import com.example.mid_project.Models.Client;
import com.example.mid_project.Repos.ClientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ClientService {

    public final ClientRepo clientRepo;

    public List<Client> getAll(){
       return clientRepo.findAll();
    }


    public void addClient(Client client){
         clientRepo.save(client);
    }

    public void updateClient(Client client,Integer id){
        Client client1 = clientRepo.findClientById(id);;


        client1.setName(client.getName());
        client1.setEmail(client.getEmail());
        client1.setPhoneNumber(client.getPhoneNumber());
        client1.setCommercialRegistration(client.getCommercialRegistration());
        clientRepo.save(client);
    }

    public void deleteClient(Integer id){
        clientRepo.deleteById(id);
    }
    public Client getClientById(Integer id){
        return clientRepo.findClientById(id);
    }
}

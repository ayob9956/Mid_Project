package com.example.mid_project.Services;

import com.example.mid_project.APIs.ApiException;
import com.example.mid_project.Models.Client;
import com.example.mid_project.Models.Project;
import com.example.mid_project.Models.Provider;
import com.example.mid_project.Models.Request;
import com.example.mid_project.Repos.ClientRepo;
import com.example.mid_project.Repos.ProjectRepo;
import com.example.mid_project.Repos.ProviderRepo;
import com.example.mid_project.Repos.RequestRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@RequiredArgsConstructor
@Service
public class ClientService {

    private final ClientRepo clientRepo;
    private final ProjectRepo projectRepo;
    private final ProviderRepo providerRepo;
    private final RequestRepo requestRepo;

    public List<Client> getAll() {
        return clientRepo.findAll();
    }


    public void addClient(Client client) {
        clientRepo.save(client);
    }

    public void updateClient(Client client, Integer id) {
        Client client1 = clientRepo.findClientById(id);


        client1.setName(client.getName());
        client1.setEmail(client.getEmail());
        client1.setPhoneNumber(client.getPhoneNumber());
        client1.setCommercialRecord(client.getCommercialRecord());
        clientRepo.save(client);
    }

    public void deleteClient(Integer id) {
        clientRepo.deleteById(id);
    }

    public Client getClientById(Integer id) {
        return clientRepo.findClientById(id);
    }

    public void addNewProject(Integer clientID, Project project) {
        Client client = clientRepo.findClientById(clientID);

        if (client == null) {
            throw new ApiException("Sorry! please check client ID");
        }
        project.setClient(client);
        project.setStatus("waiting");
        projectRepo.save(project);
    }

    public Set<Request> getProjectRequests(Integer id) {
        Project project = projectRepo.findProjectById(id);
        if (project == null) {
            throw new ApiException("wrong project ID");
        }
        return project.getRequests();
    }

    public void acceptRequest(Integer id) {
        Request request = requestRepo.findRequestById(id);

        if (request == null) {
            throw new ApiException("wrong request ID");
        }

        Project project = projectRepo.findProjectById(request.getProject().getId());
        Provider provider = providerRepo.findProviderById(request.getProvider().getId());

        request.setIsApproved(true);
        project.setProvider(provider);
        requestRepo.save(request);
        projectRepo.save(project);

    }
}

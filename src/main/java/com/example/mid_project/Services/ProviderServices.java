package com.example.mid_project.Services;

import com.example.mid_project.APIs.ApiException;
import com.example.mid_project.Models.Project;
import com.example.mid_project.Models.Provider;
import com.example.mid_project.Models.Request;
import com.example.mid_project.Repos.ProjectRepo;
import com.example.mid_project.Repos.ProviderRepo;
import com.example.mid_project.Repos.RequestRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProviderServices {

    private final ProviderRepo providerRepo;
    private final ProjectRepo projectRepo;
    private final RequestRepo requestRepo;

    public List<Provider> getAllProviders() {
        return providerRepo.findAll();
    }

    public void addProvider(Provider provider) {
        providerRepo.save(provider);
    }

    public void updateProvider(Integer id, Provider newProvider) {
        Provider provider = providerRepo.findProviderById(id);

        if (provider == null) {
            throw new ApiException("wrong provider ID ");
        }
        provider.setProviderType(newProvider.getProviderType());
        provider.setName(newProvider.getName());
        provider.setEmail(newProvider.getEmail());
        provider.setBalance(newProvider.getBalance());
        provider.setCommercialRecord(newProvider.getCommercialRecord());
        provider.setPhone(newProvider.getPhone());

        providerRepo.save(provider);
    }

    public void deleteProvider(Integer id) {
        Provider provider = providerRepo.findProviderById(id);

        if (provider == null) {
            throw new ApiException("wrong provider ID ");
        }

        providerRepo.delete(provider);
    }

    public Provider getProviderById(Integer id) {
        return providerRepo.findProviderById(id);
    }


    public void postRequest(Request request, Integer providerId, Integer prjectId) {
        Provider provider = providerRepo.findProviderById(providerId);
        Project project = projectRepo.findProjectById(prjectId);
        Request request1 = requestRepo.checkRequest(providerId, prjectId);
        if (project == null || provider == null) {
            throw new ApiException("wrong provider ID or project ID");
        }
        if (request1 != null) {
            throw new ApiException("request already exist");
        }


        if (provider.getBalance() < project.getDocumentation_price()) {
            throw new ApiException("not enough money");
        }
        provider.setBalance(provider.getBalance() - project.getDocumentation_price());
        request.setProviderName(provider.getName());
        request.setIsApproved(false);
        request.setProvider(provider);
        request.setProject(project);
        requestRepo.save(request);
    }

    public List<Provider> searchProvidersByType(String type) {
        List<Provider> providers = providerRepo.findAllByProviderType(type);

        if (providers.isEmpty()) {
            throw new ApiException("sorry! there's no providers with this type");
        }
        return providers;
    }
}

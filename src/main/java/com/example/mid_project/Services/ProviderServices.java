package com.example.mid_project.Services;

import com.example.mid_project.APIs.ApiException;
import com.example.mid_project.Models.Provider;
import com.example.mid_project.Repos.ProviderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProviderServices {

    private final ProviderRepo providerRepo;

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
}

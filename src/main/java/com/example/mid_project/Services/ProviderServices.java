package com.example.mid_project.Services;

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
}

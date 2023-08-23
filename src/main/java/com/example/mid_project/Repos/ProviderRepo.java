package com.example.mid_project.Repos;

import com.example.mid_project.Models.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderRepo extends JpaRepository<Provider, Integer> {
    Provider findProviderById(Integer id);

    Provider findProviderByName(String name);


    List<Provider> findAllByProviderType(String type);
}

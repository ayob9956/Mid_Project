package com.example.mid_project.Repos;

import com.example.mid_project.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepo extends JpaRepository<Client, Integer> {
//    List<Client> findAll();

    Client findClientById(Integer id);
}

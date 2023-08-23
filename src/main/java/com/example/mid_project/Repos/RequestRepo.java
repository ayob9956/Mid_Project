package com.example.mid_project.Repos;

import com.example.mid_project.Models.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepo extends JpaRepository<Request, Integer> {
    Request findRequestById(Integer id);
}

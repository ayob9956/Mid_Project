package com.example.mid_project.Repos;

import com.example.mid_project.Models.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepo extends JpaRepository<Request, Integer> {
    Request findRequestById(Integer id);

    @Query("SELECT r FROM Request r WHERE r.provider.id =?1 AND r.project.id=?2")
    Request checkRequest(Integer providerId,Integer projectId);
}

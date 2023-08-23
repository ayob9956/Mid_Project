package com.example.mid_project.Repos;

import com.example.mid_project.Models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer> {
    Project findProjectById(Integer id);

    List<Project> findProjectByType(String type);

    @Query("select p from Project p ")
    List<Project> getAllProject();

}

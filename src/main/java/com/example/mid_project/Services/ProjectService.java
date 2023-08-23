package com.example.mid_project.Services;

import com.example.mid_project.APIs.ApiException;
import com.example.mid_project.Models.Client;
import com.example.mid_project.Models.Project;
import com.example.mid_project.Repos.ClientRepo;
import com.example.mid_project.Repos.ProjectRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.KeyStore;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepo projectRepo;
    private final ClientRepo clientRepo;

    public List<Project> getAllProjects() {
        return projectRepo.getAllProject();
    }

    public void addProject(Project project) {
        projectRepo.save(project);

    }

    public void updateProject(Project project, Integer id) {
        Project project1 = projectRepo.findProjectById(id);
        if (project1 == null) {
            throw new ApiException("Project not found");
        }

        project1.setName(project.getName());
        project1.setDescription(project.getDescription());
        project1.setStatus(project.getStatus());
        project1.setDocumentation_price(project.getDocumentation_price());
        project1.setType(project.getType());
        project1.setSubmission_deadline(project.getSubmission_deadline());
        projectRepo.save(project1);
    }

    public void deleteProject(Integer id) {

        Project project = projectRepo.findProjectById(id);
        if (project == null) {
            throw new ApiException("Project not found");
        }

        projectRepo.delete(project);
    }

    public Project findProjectById(Integer id) {
        return projectRepo.findProjectById(id);
    }

}

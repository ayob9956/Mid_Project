package com.example.mid_project.Controllers;


import com.example.mid_project.Models.Project;
import com.example.mid_project.Services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/project")
@RequiredArgsConstructor

public class ProjectController {

    private final ProjectService projectService;


    @GetMapping("/get")
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping("/add")
    public ResponseEntity createProject(@RequestBody Project project) {
        projectService.addProject(project);
        return ResponseEntity.status(200).body("the project is added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateProject(@RequestBody Project project, @PathVariable Integer id) {
        projectService.updateProject(project, id);
        return ResponseEntity.status(200).body("the project is updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProject(@PathVariable Integer id) {

        projectService.deleteProject(id);
        return ResponseEntity.status(200).body("the project is deleted");
    }

    @GetMapping("/get/{id}")
    public Project findProjectById(@PathVariable Integer id) {
        return projectService.findProjectById(id);
    }
}

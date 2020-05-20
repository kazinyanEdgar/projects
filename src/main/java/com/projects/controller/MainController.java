package com.projects.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.projects.model.Attribute;
import com.projects.model.Geometry;
import com.projects.model.Project;
import com.projects.model.ProjectView;
import com.projects.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/projects")
public class MainController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping
    @JsonView(ProjectView.class)
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    @GetMapping("{id}")
    @JsonView(ProjectView.class)
    public Project getProject(@PathVariable Integer id) {
        return projectRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    @JsonView(ProjectView.class)
    public void createProject(@RequestBody String name) {
        Project project = new Project(name);
        List<Geometry> geometries = new ArrayList<>();
        List<Attribute> attributes = new ArrayList<>();

        for (int i = 0; i < 100_000; i++) {
            geometries.add(new Geometry("Geom" + i));
            attributes.add(new Attribute("Attr" + i));
        }

        project.setGeometries(geometries);
        project.setAttributes(attributes);

        projectRepository.save(project);
    }

    @PutMapping("{id}")
    @JsonView(ProjectView.class)
    public void updateProject(@PathVariable Integer id, @RequestBody String name) {
        Project project = projectRepository.findById(id).orElse(null);
        project.setName(name);
        projectRepository.save(project);
    }

    @DeleteMapping("{id}")
    public void deleteProject(@PathVariable Integer id) {
        projectRepository.deleteById(id);
    }

}

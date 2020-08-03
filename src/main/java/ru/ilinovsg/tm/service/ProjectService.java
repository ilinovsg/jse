package ru.ilinovsg.tm.service;

import ru.ilinovsg.tm.repository.ProjectRepository;
import ru.ilinovsg.tm.entity.Project;

import java.util.List;

public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project create(String name) {
        if (name == null || name.isEmpty()) return null;
        return projectRepository.create(name);
    }

    public Project create(String name, String description) {
        if (name == null || name.isEmpty()) return null;
        if (description == null || description.isEmpty()) return null;
        return projectRepository.create(name, description);
    }

    public Project update(Long id, String name, String description) {
        if (id == null) return null;
        if (name == null || name.isEmpty()) return null;
        if (description == null || description.isEmpty()) return null;
        return projectRepository.update(id, name, description);
    }

    public Project findByIndex(int index) {
        if (index < 0 || index > projectRepository.getSize() - 1) return null;
        return projectRepository.findByIndex(index);
    }

    public Project removeByIndex(int index) {
        if (index < 0 || index > projectRepository.getSize() - 1) return null;
        return projectRepository.removeByIndex(index);
    }

    public Project findByName(String name) {
        if (name == null || name.isEmpty()) return null;
        return projectRepository.findByName(name);
    }

    public Project removeByName(String name) {
        if (name == null || name.isEmpty()) return null;
        return projectRepository.removeByName(name);
    }

    public Project findById(Long id) {
        if (id == null) return null;
        return projectRepository.findById(id);
    }

    public Project removeById(Long id) {
        if (id == null) return null;
        return projectRepository.removeById(id);
    }

    public void clear() {
        projectRepository.clear();
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

}

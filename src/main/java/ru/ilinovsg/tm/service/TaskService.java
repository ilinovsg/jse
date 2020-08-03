package ru.ilinovsg.tm.service;

import ru.ilinovsg.tm.repository.TaskRepository;
import ru.ilinovsg.tm.entity.Task;

import java.util.Collections;
import java.util.List;

public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task create(String name) {
        if (name == null || name.isEmpty()) return null;
        return taskRepository.create(name);
    }

    public Task update(Long id, String name) {
        if (id == null) return null;
        if (name == null || name.isEmpty()) return null;
        return taskRepository.update(id, name);
    }

    public Task findByIndex(int index) {
        if (index < 0 || index > taskRepository.getSize() - 1) return null;
        return taskRepository.findByIndex(index);
    }

    public Task removeByIndex(int index) {
        if (index < 0 || index > taskRepository.getSize() - 1) return null;
        return taskRepository.removeByIndex(index);
    }

    public Task findByName(String name) {
        if (name == null || name.isEmpty()) return null;
        return taskRepository.findByName(name);
    }

    public Task removeByName(String name) {
        if (name == null || name.isEmpty()) return null;
        return taskRepository.removeByName(name);
    }

    public Task findById(Long id) {
        if (id == null) return null;
        return taskRepository.findById(id);
    }

    public Task removeById(Long id) {
        if (id == null) return null;
        return taskRepository.removeById(id);
    }

    public void clear() {
        taskRepository.clear();
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findByProjectIdAndId(Long projectId, Long id) {
        if (projectId == null || id == null) return null;
        return taskRepository.findByProjectIdAndId(projectId, id);
    }

    public List<Task> findAllByProjectId(Long projectId) {
        if (projectId == null) return null;
        return taskRepository.findAllByProjectId(projectId);
    }
}

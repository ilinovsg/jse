package ru.ilinovsg.tm.service;

import ru.ilinovsg.tm.dao.TaskRepository;
import ru.ilinovsg.tm.entity.Task;

import java.util.List;

public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task create(String name) {
        if(name == null || name.isEmpty()) return null;
        return taskRepository.create(name);
    }

    public Task update(Long id, String name) {
        if(id == null) return null;
        if(name == null || name.isEmpty()) return null;
        return taskRepository.update(id, name);
    }

    public Task findByIndex(int index) {
        if(index < 0 || index > this.findAll().size() - 1) return null;
        return taskRepository.findByIndex(index);
    }

    public Task removeByIndex(int index) {
        if(index < 0 || index > this.findAll().size() - 1) return null;
        return taskRepository.removeByIndex(index);
    }

    public Task findByName(String name) {
        if(name == null || name.isEmpty()) return null;
        return taskRepository.findByName(name);
    }

    public Task removeByName(String name) {
        if(name == null || name.isEmpty()) return null;
        return taskRepository.removeByName(name);
    }

    public Task findById(Long id) {
        if(id == null) return null;
        return taskRepository.findById(id);
    }

    public Task removeById(Long id) {
        if(id == null) return null;
        return taskRepository.removeById(id);
    }

    public void clear() {
        taskRepository.clear();
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

}

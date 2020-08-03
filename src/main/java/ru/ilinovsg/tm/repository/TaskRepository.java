package ru.ilinovsg.tm.repository;

import ru.ilinovsg.tm.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private final List<Task> tasks = new ArrayList<>();

    public Task create(final String name) {
        final Task task = new Task(name);
        tasks.add(task);
        return task;
    }

    public Task update(final Long id, final String name) {
        final Task task = findById(id);
        if (task == null) return null;
        task.setId(id);
        task.setName(name);
        return task;
    }

    public Task findByIndex(int index) {
        return tasks.get(index);
    }

    public Task removeByIndex(final int index) {
        final Task task = findByIndex(index);
        if (task == null) return null;
        tasks.remove(task);
        return task;
    }

    public Task findByName(final String name) {
        for (final Task task : tasks) {
            if (task.getName().equals(name)) return task;
        }
        return null;
    }

    public Task removeByName(final String name) {
        final Task task = findByName(name);
        if (task == null) return null;
        tasks.remove(task);
        return task;
    }

    public Task findById(final Long id) {
        for (final Task task : tasks) {
            if (task.getId().equals(id)) return task;
        }
        return null;
    }

    public Task removeById(final Long id) {
        final Task task = findById(id);
        if (task == null) return null;
        tasks.remove(task);
        return task;
    }

    public void clear() {
        tasks.clear();
    }

    public List<Task> findAll() {
        return tasks;
    }

    public int getSize() {
        return tasks.size();
    }

}

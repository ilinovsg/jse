package ru.ilinovsg.tm.controller;

import ru.ilinovsg.tm.entity.Task;
import ru.ilinovsg.tm.service.TaskService;

public class TaskController extends AbstractController{

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    public int createTask() {
        System.out.println("[Create task]");
        System.out.println("[Please, enter task name]");
        final String name = scanner.nextLine();
        taskService.create(name);
        System.out.println("[OK]");
        return 0;
    }

    public int updateTaskByName() {
        System.out.println("[Update task]");
        System.out.println("[Please, enter task name]");
        final String name = scanner.nextLine();
        final Task task = taskService.findByName(name);
        if(task == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        System.out.println("[Please, enter task name]");
        final String new_name = scanner.nextLine();
        taskService.update(task.getId(), new_name);
        System.out.println("[OK]");
        return 0;
    }

    public int updateTaskById() {
        System.out.println("[Update task]");
        System.out.println("[Please, enter task id]");
        final Long id = Long.parseLong(scanner.nextLine());
        final Task task = taskService.findById(id);
        if(task == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        System.out.println("[Please, enter task name]");
        final String name = scanner.nextLine();
        taskService.update(task.getId(), name);
        System.out.println("[OK]");
        return 0;
    }

    public int updateTaskByIndex() {
        System.out.println("[Update project]");
        System.out.println("[Please, enter task index]");
        final int index = Integer.parseInt(scanner.nextLine()) - 1;
        final Task task = taskService.findByIndex(index);
        if(task == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        System.out.println("[Please, enter task name]");
        final String name = scanner.nextLine();
        taskService.update(task.getId(), name);
        System.out.println("[OK]");
        return 0;
    }

    public int removeTaskByName() {
        System.out.println("[Please, enter task name]");
        final String name = scanner.nextLine();
        final Task task = taskService.removeByName(name);
        if(task == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    public int removeTaskById() {
        System.out.println("[Please, enter task id]");
        final Long id = scanner.nextLong();
        final Task task = taskService.removeById(id);
        if(task == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    public int removeTaskByIndex() {
        System.out.println("[Please, enter task index]");
        final int index = scanner.nextInt() - 1;
        final Task task = taskService.removeByIndex(index);
        if(task == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    public int clearTask() {
        System.out.println("[Clear task]");
        taskService.clear();
        System.out.println("[OK]");
        return 0;
    }

    public void viewTask(final Task task) {
        if(task == null) return;
        System.out.println("[View task]");
        System.out.println("ID: " + task.getId());
        System.out.println("NAME: " + task.getName());
        System.out.println("DESCRIPTION: " + task.getDescription());
        System.out.println("[OK]");
    }

    public int viewTaskByIndex() {
        System.out.println("Enter task index");
        final int index = scanner.nextInt() - 1;
        final Task task = taskService.findByIndex(index);
        viewTask(task);
        return 0;
    }

    public int viewTaskByName() {
        System.out.println("Enter task name");
        final String name = scanner.nextLine();
        final Task task = taskService.findByName(name);
        viewTask(task);
        return 0;
    }

    public int viewTaskById() {
        System.out.println("Enter task id");
        final Long id = scanner.nextLong();
        final Task task = taskService.findById(id);
        viewTask(task);
        return 0;
    }

    public int listTask() {
        System.out.println("[List task]");
        int index = 1;
        for(final Task task: taskService.findAll()) {
            System.out.println(index + "." + task.getId() + " " + task.getName());
            index++;
        }
        System.out.println("[OK]");
        return 0;
    }

}

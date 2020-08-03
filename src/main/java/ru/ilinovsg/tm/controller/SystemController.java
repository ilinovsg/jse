package ru.ilinovsg.tm.controller;

public class SystemController {

    public int displayExit() {
        System.out.println("Close programm");
        return 0;
    }

    public int displayError() {
        System.out.println("Error! Unknown argument...");
        System.out.println("Use command Help to view list of commands");
        return -1;
    }

    public void displayWelcome() {
        System.out.println("***WELCOME TO TASK-MANAGER***");
    }

    public int displayHelp() {
        System.out.println("version - Display application version");
        System.out.println("about - Display developer info");
        System.out.println("help - Display list of commands");
        System.out.println("exit - Close programm");
        System.out.println();
        System.out.println("project-create - Create new project");
        System.out.println("project-clear - Remove all projects");
        System.out.println("project-list - Display list of projects");
        System.out.println("project-view - Display project");
        System.out.println("project-view-by-name - Display project by name");
        System.out.println("project-view-by-id - Display project by id");
        System.out.println("project-view-by-index - Display project index");
        System.out.println("project-remove-by-name - Remove project by name");
        System.out.println("project-remove-by-id - Remove project by id");
        System.out.println("project-remove-by-index - Remove project by index");
        System.out.println("project-update-by-name - Update project by name");
        System.out.println("project-update-by-id - Update project by id");
        System.out.println("project-update-by-index - Update project by index");
        System.out.println();
        System.out.println("task-create - Create new task");
        System.out.println("task-clear - Remove all taskss");
        System.out.println("task-list - Display list of tasks");
        System.out.println("task-view - Display task");
        System.out.println("task-view-by-name - Display task by name");
        System.out.println("task-view-by-id - Display task by id");
        System.out.println("task-view-by-index - Display task index");
        System.out.println("task-remove-by-name - Remove task by name");
        System.out.println("task-remove-by-id - Remove task by id");
        System.out.println("task-remove-by-index - Remove task by index");
        System.out.println("task-update-by-name - Update task by name");
        System.out.println("task-update-by-id - Update task by id");
        System.out.println("task-update-by-index - Update task by index");
        System.out.println("task-list-by-project-id - Display task list by project id");
        System.out.println("task-add-to-project-by-ids - Add task to project by ids");
        System.out.println("task-remove-from-project-by-ids - Remove task from project by id");
        System.out.println("task-remove-with-project-by-id - Remove tasks and project by id");
        return 0;
    }

    public int displayVersion() {
        System.out.println("1.0.0");
        return 0;
    }

    public int displayAbout() {
        System.out.println("Sergey Ilinov");
        System.out.println("ilyinov_sg@nlmk.com");
        return 0;
    }

}

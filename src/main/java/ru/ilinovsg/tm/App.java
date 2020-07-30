package ru.ilinovsg.tm;

import ru.ilinovsg.tm.controller.ProjectController;
import ru.ilinovsg.tm.controller.SystemController;
import ru.ilinovsg.tm.controller.TaskController;
import ru.ilinovsg.tm.dao.ProjectRepository;
import ru.ilinovsg.tm.dao.TaskRepository;
import ru.ilinovsg.tm.service.ProjectService;
import ru.ilinovsg.tm.service.TaskService;

import java.util.Scanner;

import static ru.ilinovsg.tm.constant.TerminalConst.*;

public class App {

    private final ProjectRepository projectRepository = new ProjectRepository();
    private final ProjectService projectService = new ProjectService(projectRepository);

    private final TaskRepository taskRepository = new TaskRepository();
    private final TaskService taskService = new TaskService(taskRepository);

    private final ProjectController projectController = new ProjectController(projectService);

    private final TaskController taskController = new TaskController(taskService);

    private final SystemController systemController = new SystemController();

    {
        projectRepository.create("PROJECT 1");
        projectRepository.create("PROJECT 2");
        taskRepository.create("TASK 1");
        taskRepository.create("TASK 2");
    }

    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final App app = new App();
        app.run(args);
        app.systemController.displayWelcome();
        String command = "";
        while (!EXIT.equals(command)) {
            command = scanner.nextLine();
            app.run(command);
        }
    }

    public void run(final String[] args) {
        if (args == null) return;
        if (args.length < 1) return;
        final String param = args[0];
        final int result = run(param);
        System.exit(result);
    }

    public int run(final String param) {
        if (param == null || param.isEmpty()) return -1;
        switch (param) {
            case VERSION:
                return systemController.displayVersion();
            case ABOUT:
                return systemController.displayAbout();
            case HELP:
                return systemController.displayHelp();
            case EXIT:
                return systemController.displayExit();
            case PROJECT_CREATE:
                return projectController.createProject();
            case PROJECT_REMOVE_BY_NAME:
                return projectController.removeProjectByName();
            case PROJECT_REMOVE_BY_ID:
                return projectController.removeProjectById();
            case PROJECT_REMOVE_BY_INDEX:
                return projectController.removeProjectByIndex();
            case PROJECT_UPDATE_BY_NAME:
                return projectController.updateProjectByName();
            case PROJECT_UPDATE_BY_ID:
                return projectController.updateProjectById();
            case PROJECT_UPDATE_BY_INDEX:
                return projectController.updateProjectByIndex();
            case PROJECT_CLEAR:
                return projectController.clearProject();
            case PROJECT_LIST:
                return projectController.listProject();
            case PROJECT_VIEW_BY_ID:
                return projectController.viewProjectById();
            case PROJECT_VIEW_BY_INDEX:
                return projectController.viewProjectByIndex();
            case PROJECT_VIEW_BY_NAME:
                return projectController.viewProjectByName();
            case TASK_CREATE:
                return taskController.createTask();
            case TASK_REMOVE_BY_NAME:
                return taskController.removeTaskByName();
            case TASK_REMOVE_BY_ID:
                return taskController.removeTaskById();
            case TASK_REMOVE_BY_INDEX:
                return taskController.removeTaskByIndex();
            case TASK_UPDATE_BY_NAME:
                return taskController.updateTaskByName();
            case TASK_UPDATE_BY_ID:
                return taskController.updateTaskById();
            case TASK_UPDATE_BY_INDEX:
                return taskController.updateTaskByIndex();
            case TASK_CLEAR:
                return taskController.clearTask();
            case TASK_LIST:
                return taskController.listTask();
            case TASK_VIEW_BY_ID:
                return taskController.viewTaskById();
            case TASK_VIEW_BY_INDEX:
                return taskController.viewTaskByIndex();
            case TASK_VIEW_BY_NAME:
                return taskController.viewTaskByName();
            default:
                return systemController.displayError();
        }
    }

}

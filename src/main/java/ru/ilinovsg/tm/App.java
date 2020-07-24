package ru.ilinovsg.tm;

import ru.ilinovsg.tm.dao.ProjectDAO;
import ru.ilinovsg.tm.dao.TaskDAO;
import ru.ilinovsg.tm.entity.Task;

import java.util.Scanner;

import static ru.ilinovsg.tm.constant.TerminalConst.*;

public class App {

    private static final ProjectDAO projectDAO = new ProjectDAO();

    private static final TaskDAO taskDAO = new TaskDAO();

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(final String[] args) {
        run(args);
        displayWelcome();
        String command = "";
        while (!EXIT.equals(command)) {
            command = scanner.nextLine();
            run(command);
        }
    }

    private static void run(final String[] args) {
        if (args == null) return;
        if (args.length < 1) return;
        final String param = args[0];
        final int result = run(param);
        System.exit(result);
    }

    private static int run(final String param) {
        if (param == null) return -1;
        switch (param) {
            case VERSION:
                return displayVersion();
            case ABOUT:
                return displayAbout();
            case HELP:
                return displayHelp();
            case EXIT:
                return displayExit();
            case PROJECT_CREATE:
                return createProject();
            case PROJECT_CLEAR:
                return clearProject();
            case PROJECT_LIST:
                return listProject();
            case TASK_CREATE:
                return createTask();
            case TASK_CLEAR:
                return clearTask();
            case TASK_LIST:
                return listTask();
            default:
                return displayError();
        }
    }

    private static int createProject() {
        System.out.println("[Create project]");
        System.out.println("[Please, enter project name]");
        final String name = scanner.nextLine();
        projectDAO.create(name);
        System.out.println("[OK]");
        return 0;
    }

    private static int clearProject() {
        System.out.println("[Clear project]");
        projectDAO.clear();
        System.out.println("[OK]");
        return 0;
    }

    private static int listProject() {
        System.out.println("[List project]");
        System.out.println(projectDAO.findAll());
        System.out.println("[OK]");
        return 0;
    }

    private static int createTask() {
        System.out.println("[Create task]");
        System.out.println("[Please, enter task name]");
        final String name = scanner.nextLine();
        taskDAO.create(name);
        System.out.println("[OK]");
        return 0;
    }

    private static int clearTask() {
        System.out.println("[Clear task]");
        taskDAO.clear();
        System.out.println("[OK]");
        return 0;
    }

    private static int listTask() {
        System.out.println("[List task]");
        System.out.println(taskDAO.findAll());
        System.out.println("[OK]");
        return 0;
    }

    private static int displayExit() {
        System.out.println("Close programm");
        return 0;
    }

    private static int displayError() {
        System.out.println("Error! Unknown argument...");
        System.out.println("Use command Help to view list of commands");
        return -1;
    }

    private static void displayWelcome() {
        System.out.println("***WELCOME TO TASK-MANAGER***");
    }

    private static int displayHelp() {
        System.out.println("version - Display application version");
        System.out.println("about - Display developer info");
        System.out.println("help - Display list of commands");
        System.out.println("exit - Close programm");
        System.out.println();
        System.out.println("project-create - Create new project");
        System.out.println("project-clear - Remove all projects");
        System.out.println("project-list - Display list of projects");
        System.out.println();
        System.out.println("task-create - Create new task");
        System.out.println("task-clear - Remove all taskss");
        System.out.println("task-list - Display list of tasks");
        return 0;
    }

    private static int displayVersion() {
        System.out.println("1.0.0");
        return 0;
    }

    private static int displayAbout() {
        System.out.println("Sergey Ilinov");
        System.out.println("ilyinov_sg@nlmk.com");
        return 0;
    }

}

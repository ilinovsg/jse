package ru.ilinovsg.tm;

import ru.ilinovsg.tm.dao.ProjectDAO;
import ru.ilinovsg.tm.dao.TaskDAO;
import ru.ilinovsg.tm.entity.Project;
import ru.ilinovsg.tm.entity.Task;

import java.util.Scanner;

import static ru.ilinovsg.tm.constant.TerminalConst.*;

public class App {

    private static final ProjectDAO projectDAO = new ProjectDAO();

    private static final TaskDAO taskDAO = new TaskDAO();

    private static final Scanner scanner = new Scanner(System.in);

    static {
        projectDAO.create("PROJECT 1");
        projectDAO.create("PROJECT 2");
        taskDAO.create("TASK 1");
        taskDAO.create("TASK 2");
    }

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
        if (param == null || param.isEmpty()) return -1;
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
            case PROJECT_REMOVE_BY_NAME:
                return removeProjectByName();
            case PROJECT_REMOVE_BY_ID:
                return removeProjectById();
            case PROJECT_REMOVE_BY_INDEX:
                return removeProjectByIndex();
            case PROJECT_UPDATE_BY_NAME:
                return updateProjectByName();
            case PROJECT_UPDATE_BY_ID:
                return updateProjectById();
            case PROJECT_UPDATE_BY_INDEX:
                return updateProjectByIndex();
            case PROJECT_CLEAR:
                return clearProject();
            case PROJECT_LIST:
                return listProject();
            case PROJECT_VIEW_BY_ID:
                return viewProjectById();
            case PROJECT_VIEW_BY_INDEX:
                return viewProjectByIndex();
            case PROJECT_VIEW_BY_NAME:
                return viewProjectByName();
            case TASK_CREATE:
                return createTask();
            case TASK_REMOVE_BY_NAME:
                return removeTaskByName();
            case TASK_REMOVE_BY_ID:
                return removeTaskById();
            case TASK_REMOVE_BY_INDEX:
                return removeTaskByIndex();
            case TASK_UPDATE_BY_NAME:
                return updateTaskByName();
            case TASK_UPDATE_BY_ID:
                return updateTaskById();
            case TASK_UPDATE_BY_INDEX:
                return updateTaskByIndex();
            case TASK_CLEAR:
                return clearTask();
            case TASK_LIST:
                return listTask();
            case TASK_VIEW_BY_ID:
                return viewTaskById();
            case TASK_VIEW_BY_INDEX:
                return viewTaskByIndex();
            case TASK_VIEW_BY_NAME:
                return viewTaskByName();
            default:
                return displayError();
        }
    }

    private static int createProject() {
        System.out.println("[Create project]");
        System.out.println("[Please, enter project name]");
        final String name = scanner.nextLine();
        System.out.println("[Please, enter project description]");
        final String description = scanner.nextLine();
        projectDAO.create(name, description);
        System.out.println("[OK]");
        return 0;
    }

    private static int updateProjectByName() {
        System.out.println("[Update project]");
        System.out.println("[Please, enter project name]");
        final String name = scanner.nextLine();
        final Project project = projectDAO.findByName(name);
        if(project == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        System.out.println("[Please, enter project name]");
        final String new_name = scanner.nextLine();
        System.out.println("[Please, enter project description]");
        final String description = scanner.nextLine();
        projectDAO.update(project.getId(), new_name, description);
        System.out.println("[OK]");
        return 0;
    }

    private static int updateProjectById() {
        System.out.println("[Update project]");
        System.out.println("[Please, enter project id]");
        final Long id = Long.parseLong(scanner.nextLine());
        final Project project = projectDAO.findById(id);
        if(project == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        System.out.println("[Please, enter project name]");
        final String name = scanner.nextLine();
        System.out.println("[Please, enter project description]");
        final String description = scanner.nextLine();
        projectDAO.update(project.getId(), name, description);
        System.out.println("[OK]");
        return 0;
    }

    private static int updateProjectByIndex() {
        System.out.println("[Update project]");
        System.out.println("[Please, enter project index]");
        final int index = Integer.parseInt(scanner.nextLine()) - 1;
        final Project project = projectDAO.findByIndex(index);
        if(project == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        System.out.println("[Please, enter project name]");
        final String name = scanner.nextLine();
        System.out.println("[Please, enter project description]");
        final String description = scanner.nextLine();
        projectDAO.update(project.getId(), name, description);
        System.out.println("[OK]");
        return 0;
    }

    private static int removeProjectByName() {
        System.out.println("[Please, enter project name]");
        final String name = scanner.nextLine();
        final Project project = projectDAO.removeByName(name);
        if(project == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    private static int removeProjectById() {
        System.out.println("[Please, enter project id]");
        final Long id = scanner.nextLong();
        final Project project = projectDAO.removeById(id);
        if(project == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    private static int removeProjectByIndex() {
        System.out.println("[Please, enter project index]");
        final int index = scanner.nextInt() - 1;
        final Project project = projectDAO.removeByIndex(index);
        if(project == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    private static int clearProject() {
        System.out.println("[Clear project]");
        projectDAO.clear();
        System.out.println("[OK]");
        return 0;
    }

    private static void viewProject(final Project project) {
        if(project == null) return;
        System.out.println("[View project]");
        System.out.println("ID: " + project.getId());
        System.out.println("NAME: " + project.getName());
        System.out.println("DESCRIPTION: " + project.getDescription());
        System.out.println("[OK]");
    }

    private static int viewProjectByIndex() {
        System.out.println("Enter project index");
        final int index = scanner.nextInt() - 1;
        final Project project = projectDAO.findByIndex(index);
        viewProject(project);
        return 0;
    }

    private static int viewProjectByName() {
        System.out.println("Enter project name");
        final String name = scanner.nextLine();
        final Project project = projectDAO.findByName(name);
        viewProject(project);
        return 0;
    }

    private static int viewProjectById() {
        System.out.println("Enter project id");
        final Long id = scanner.nextLong();
        final Project project = projectDAO.findById(id);
        viewProject(project);
        return 0;
    }

    private static int listProject() {
        System.out.println("[List project]");
        int index = 1;
        for(final Project project: projectDAO.findAll()) {
            System.out.println(index + "." + project.getId() + " " + project.getName());
            index++;
        }
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

    private static int updateTaskByName() {
        System.out.println("[Update task]");
        System.out.println("[Please, enter task name]");
        final String name = scanner.nextLine();
        final Task task = taskDAO.findByName(name);
        if(task == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        System.out.println("[Please, enter task name]");
        final String new_name = scanner.nextLine();
        taskDAO.update(task.getId(), new_name);
        System.out.println("[OK]");
        return 0;
    }

    private static int updateTaskById() {
        System.out.println("[Update task]");
        System.out.println("[Please, enter task id]");
        final Long id = Long.parseLong(scanner.nextLine());
        final Task task = taskDAO.findById(id);
        if(task == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        System.out.println("[Please, enter task name]");
        final String name = scanner.nextLine();
        taskDAO.update(task.getId(), name);
        System.out.println("[OK]");
        return 0;
    }

    private static int updateTaskByIndex() {
        System.out.println("[Update project]");
        System.out.println("[Please, enter task index]");
        final int index = Integer.parseInt(scanner.nextLine()) - 1;
        final Task task = taskDAO.findByIndex(index);
        if(task == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        System.out.println("[Please, enter task name]");
        final String name = scanner.nextLine();
        taskDAO.update(task.getId(), name);
        System.out.println("[OK]");
        return 0;
    }

    private static int removeTaskByName() {
        System.out.println("[Please, enter task name]");
        final String name = scanner.nextLine();
        final Task task = taskDAO.removeByName(name);
        if(task == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    private static int removeTaskById() {
        System.out.println("[Please, enter task id]");
        final Long id = scanner.nextLong();
        final Task task = taskDAO.removeById(id);
        if(task == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    private static int removeTaskByIndex() {
        System.out.println("[Please, enter task index]");
        final int index = scanner.nextInt() - 1;
        final Task task = taskDAO.removeByIndex(index);
        if(task == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    private static int clearTask() {
        System.out.println("[Clear task]");
        taskDAO.clear();
        System.out.println("[OK]");
        return 0;
    }

    private static void viewTask(final Task task) {
        if(task == null) return;
        System.out.println("[View task]");
        System.out.println("ID: " + task.getId());
        System.out.println("NAME: " + task.getName());
        System.out.println("DESCRIPTION: " + task.getDescription());
        System.out.println("[OK]");
    }

    private static int viewTaskByIndex() {
        System.out.println("Enter task index");
        final int index = scanner.nextInt() - 1;
        final Task task = taskDAO.findByIndex(index);
        viewTask(task);
        return 0;
    }

    private static int viewTaskByName() {
        System.out.println("Enter task name");
        final String name = scanner.nextLine();
        final Task task = taskDAO.findByName(name);
        viewTask(task);
        return 0;
    }

    private static int viewTaskById() {
        System.out.println("Enter task id");
        final Long id = scanner.nextLong();
        final Task task = taskDAO.findById(id);
        viewTask(task);
        return 0;
    }

    private static int listTask() {
        System.out.println("[List task]");
        int index = 1;
        for(final Task task: taskDAO.findAll()) {
            System.out.println(index + "." + task.getId() + " " + task.getName());
            index++;
        }
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
        System.out.println("project-view - Display project");
        System.out.println();
        System.out.println("task-create - Create new task");
        System.out.println("task-clear - Remove all taskss");
        System.out.println("task-list - Display list of tasks");
        System.out.println("task-view - Display task");
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

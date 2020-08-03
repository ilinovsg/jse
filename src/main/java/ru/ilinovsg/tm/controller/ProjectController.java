package ru.ilinovsg.tm.controller;

import ru.ilinovsg.tm.entity.Project;
import ru.ilinovsg.tm.service.ProjectService;

public class ProjectController extends  AbstractController{

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    public int createProject() {
        System.out.println("[Create project]");
        System.out.println("[Please, enter project name]");
        final String name = scanner.nextLine();
        System.out.println("[Please, enter project description]");
        final String description = scanner.nextLine();
        projectService.create(name, description);
        System.out.println("[OK]");
        return 0;
    }

    public int updateProjectByName() {
        System.out.println("[Update project]");
        System.out.println("[Please, enter project name]");
        final String name = scanner.nextLine();
        final Project project = projectService.findByName(name);
        if(project == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        System.out.println("[Please, enter project name]");
        final String new_name = scanner.nextLine();
        System.out.println("[Please, enter project description]");
        final String description = scanner.nextLine();
        projectService.update(project.getId(), new_name, description);
        System.out.println("[OK]");
        return 0;
    }

    public int updateProjectById() {
        System.out.println("[Update project]");
        System.out.println("[Please, enter project id]");
        final Long id = Long.parseLong(scanner.nextLine());
        final Project project = projectService.findById(id);
        if(project == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        System.out.println("[Please, enter project name]");
        final String name = scanner.nextLine();
        System.out.println("[Please, enter project description]");
        final String description = scanner.nextLine();
        projectService.update(project.getId(), name, description);
        System.out.println("[OK]");
        return 0;
    }

    public int updateProjectByIndex() {
        System.out.println("[Update project]");
        System.out.println("[Please, enter project index]");
        final int index = Integer.parseInt(scanner.nextLine()) - 1;
        final Project project = projectService.findByIndex(index);
        if(project == null) {
            System.out.println("[FAIL]");
            return 0;
        }
        System.out.println("[Please, enter project name]");
        final String name = scanner.nextLine();
        System.out.println("[Please, enter project description]");
        final String description = scanner.nextLine();
        projectService.update(project.getId(), name, description);
        System.out.println("[OK]");
        return 0;
    }

    public int removeProjectByName() {
        System.out.println("[Please, enter project name]");
        final String name = scanner.nextLine();
        final Project project = projectService.removeByName(name);
        if(project == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    public int removeProjectById() {
        System.out.println("[Please, enter project id]");
        final Long id = scanner.nextLong();
        final Project project = projectService.removeById(id);
        if(project == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    public int removeProjectByIndex() {
        System.out.println("[Please, enter project index]");
        final int index = scanner.nextInt() - 1;
        final Project project = projectService.removeByIndex(index);
        if(project == null) System.out.println("[FAIL]");
        else System.out.println("[OK]");
        return 0;
    }

    public int clearProject() {
        System.out.println("[Clear project]");
        projectService.clear();
        System.out.println("[OK]");
        return 0;
    }

    public void viewProject(final Project project) {
        if(project == null) return;
        System.out.println("[View project]");
        System.out.println("ID: " + project.getId());
        System.out.println("NAME: " + project.getName());
        System.out.println("DESCRIPTION: " + project.getDescription());
        System.out.println("[OK]");
    }

    public int viewProjectByIndex() {
        System.out.println("Enter project index");
        final int index = scanner.nextInt() - 1;
        final Project project = projectService.findByIndex(index);
        viewProject(project);
        return 0;
    }

    public int viewProjectByName() {
        System.out.println("Enter project name");
        final String name = scanner.nextLine();
        final Project project = projectService.findByName(name);
        viewProject(project);
        return 0;
    }

    public int viewProjectById() {
        System.out.println("Enter project id");
        final Long id = scanner.nextLong();
        final Project project = projectService.findById(id);
        viewProject(project);
        return 0;
    }

    public int listProject() {
        System.out.println("[List project]");
        int index = 1;
        for(final Project project: projectService.findAll()) {
            System.out.println(index + "." + project.getId() + " " + project.getName());
            index++;
        }
        System.out.println("[OK]");
        return 0;
    }

}

package ru.ilinovsg.tm;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import ru.ilinovsg.tm.entity.Project;
import ru.ilinovsg.tm.entity.Task;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        final App app = new App();
        final Task task = app.getTaskService().findByIndex(0);
        System.out.println(task);
        final Project project = app.getProjectService().findByIndex(0);
        System.out.println(project);

        app. getProjectTaskService().addTaskToProject(project.getId(), task.getId());
        System.out.println(app.getProjectTaskService().findAllByProjectId(project.getId()));

        app.getProjectTaskService().removeTaskFromProject(project.getId(), task.getId());
        System.out.println(app.getProjectTaskService().findAllByProjectId(project.getId()));
        assertTrue( true );
    }
}

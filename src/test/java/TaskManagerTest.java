import org.example.Status;
import org.example.Task;
import org.example.TaskManager;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TaskManagerTest {

    @Test
    public void testAddTask() {
        String description = "my task";
        TaskManager taskManager = new TaskManager();
        taskManager.addTask(description.trim());
        Assert.assertEquals("my task", taskManager.getTaskbyIndex(0).getDescription());
    }

    @Test
    public void testRemoveTask() {
        String description = "my task";
        TaskManager taskManager = new TaskManager();
        taskManager.addTask(description.trim());
        taskManager.removeTask(1);
        Assert.assertTrue(taskManager.isEmpty());
    }

    @Test
    public void testRemoveTaskFail() {
        String description = "my task";
        TaskManager taskManager = new TaskManager();
        taskManager.addTask(description.trim());
        taskManager.removeTask(2);
        Assert.assertFalse(taskManager.isEmpty());
    }

    @Test
    public void testSetStatusDone() {
        TaskManager taskManager = new TaskManager();
        taskManager.addTask("first task");
        taskManager.taskDone(1);
        Assert.assertEquals(Status.DONE, taskManager.getTaskbyIndex(0).getStatus());
    }

    @Test
    public void testSetStatusToDo() {
        List<Task> taskList = new ArrayList<>();
        Task task = new Task("my task", 1, Status.DONE);
        taskList.add(task);
        TaskManager taskManager = new TaskManager(taskList);
        taskManager.taskToDo(1);
        Assert.assertEquals(Status.TODO, taskManager.getTaskbyIndex(0).getStatus());
    }

    @Test
    public void testParseAddTaskAction() {
        TaskManager taskManager = new TaskManager();
        taskManager.parseAction("+ my task");
        Assert.assertEquals("my task", taskManager.getTaskbyIndex(0).getDescription());
    }

    @Test
    public void testParseRemoveTaskAction() {
        String description = "my task";
        TaskManager taskManager = new TaskManager();
        taskManager.addTask(description.trim());
        taskManager.parseAction("- 1");
        Assert.assertTrue(taskManager.isEmpty());
    }

    @Test
    public void testParseSetStatusToDoAction() {
        List<Task> taskList = new ArrayList<>();
        Task task = new Task("my task", 1, Status.DONE);
        taskList.add(task);
        TaskManager taskManager = new TaskManager(taskList);
        taskManager.parseAction("x 1");
        Assert.assertEquals(Status.TODO, taskManager.getTaskbyIndex(0).getStatus());
    }

    @Test
    public void testParseSetStatusDoneAction() {
        TaskManager taskManager = new TaskManager();
        taskManager.addTask("first task");
        taskManager.parseAction("o 1");
        Assert.assertEquals(Status.DONE, taskManager.getTaskbyIndex(0).getStatus());
    }
}

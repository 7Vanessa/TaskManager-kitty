import org.example.Status;
import org.example.Task;
import org.example.TaskManager;
import org.junit.Assert;
import org.junit.Test;

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

}

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


}

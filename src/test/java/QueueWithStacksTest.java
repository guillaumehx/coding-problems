import org.junit.Assert;
import org.junit.Test;

public class QueueWithStacksTest {

    @Test
    public void testDequeue() {

        QueueWithStacks<String> queue = new QueueWithStacks<>();

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");

        Assert.assertEquals("A", queue.dequeue());
        Assert.assertEquals("B", queue.dequeue());
        Assert.assertEquals("C", queue.dequeue());
        Assert.assertEquals("D", queue.dequeue());
    }

    @Test
    public void testIsEmpty() {

        QueueWithStacks<String> queue = new QueueWithStacks<>();

        queue.enqueue("A");
        Assert.assertFalse(queue.isEmpty());
        queue.dequeue();
        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void testPeek() {

        QueueWithStacks<String> queue = new QueueWithStacks<>();

        queue.enqueue("A");

        Assert.assertEquals("A", queue.peek());
        Assert.assertFalse(queue.isEmpty());
    }
}
import org.junit.Assert;
import org.junit.Test;

public class PlusOneTest {

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[] { 9, 0, 0, 0 }, PlusOne.execute(new int[] { 8, 9, 9, 9 }));
        Assert.assertArrayEquals(new int[] { 9, 0 }, PlusOne.execute(new int[] { 8, 9 }));
        Assert.assertArrayEquals(new int[] { 1, 2, 4 }, PlusOne.execute(new int[] { 1, 2, 3 }));
        Assert.assertArrayEquals(new int[] { 4, 3, 2, 2 }, PlusOne.execute(new int[] { 4, 3, 2, 1 }));
        Assert.assertArrayEquals(new int[] { 1, 0 }, PlusOne.execute(new int[] { 9 }));
        Assert.assertArrayEquals(new int[] { 1, 0, 0, 0, 0, 0 }, PlusOne.execute(new int[] { 9, 9, 9, 9, 9 }));
    }

}
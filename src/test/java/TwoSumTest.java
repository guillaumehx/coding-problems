import org.junit.Assert;
import org.junit.Test;

public class TwoSumTest {

    @Test
    public void test_1() {
        int[] result = TwoSum.execute(new int[] { 8, 10, 2, 5 }, 7);
        Assert.assertArrayEquals(new int[] { 2, 3 }, result);
    }

    @Test
    public void test_2() {
        int[] result = TwoSum.execute(new int[] { 1, 1 }, 2);
        Assert.assertArrayEquals(new int[] { 0, 1 }, result);
    }

    @Test
    public void test_3() {
        int[] result = TwoSum.execute(new int[] { 2, 7, 11, 15 }, 9);
        Assert.assertArrayEquals(new int[] { 0, 1 }, result);
    }

    @Test
    public void test_4() {
        int[] result = TwoSum.execute(new int[] { 3, 2, 4 }, 6);
        Assert.assertArrayEquals(new int[] { 1, 2 }, result);
    }

}
import org.junit.Assert;
import org.junit.Test;

public class SingleNumberTest {

    @Test
    public void test_1() {
        int res = SingleNumber.execute(new int[] {1,1,3,3,4,4,2});
        Assert.assertEquals(2, res);
    }

    @Test
    public void test_2() {
        int res = SingleNumber.execute(new int[] {4,1,2,1,2});
        Assert.assertEquals(4, res);
    }

    @Test
    public void test_3() {
        int res = SingleNumber.execute(new int[] {1});
        Assert.assertEquals(1, res);
    }

}
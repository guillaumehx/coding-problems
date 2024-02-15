import org.junit.Assert;
import org.junit.Test;

/**
 * @author Guillaume Houioux ©
 */
public class GCDTest {

    @Test
    public void testMultipleValues() {
        Assert.assertEquals(18, GCD.execute(461952, 116298));
        Assert.assertEquals(526, GCD.execute(24826148, 45296490));
        Assert.assertEquals(2, GCD.execute(6, 16));
        Assert.assertEquals(32, GCD.execute(7966496, 314080416));
        Assert.assertEquals(4, GCD.execute(4, 8));
    }

}

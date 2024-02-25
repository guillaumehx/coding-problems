import org.junit.Assert;
import org.junit.Test;

public class RPNTest {

    @Test
    public void testValid() {
        Assert.assertEquals("18.0", RPN.execute("3 4 2 + *"));
        Assert.assertEquals("4.0", RPN.execute("5 4 2 * 3 + + sqrt"));
        Assert.assertEquals("42.0", RPN.execute("6 8 4 + 3 2 + - *"));
        Assert.assertEquals("14.24", RPN.execute("3.12 4 + 2 * 14.24"));
        Assert.assertEquals("3.0", RPN.execute("81 sqrt sqrt"));
    }

    @Test
    public void testInvalid() {
        Assert.assertEquals("", RPN.execute(""));
        Assert.assertEquals("blablabla", RPN.execute("blablabla"));
        Assert.assertEquals("18", RPN.execute("18"));
    }

}
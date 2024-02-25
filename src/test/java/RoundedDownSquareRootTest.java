import org.junit.Assert;
import org.junit.Test;

public class RoundedDownSquareRootTest {

    @Test
    public void test() {
        Assert.assertEquals(2, RoundedDownSquareRoot.execute(8));
        Assert.assertEquals(2, RoundedDownSquareRoot.execute(4));
        Assert.assertEquals(90, RoundedDownSquareRoot.execute(8192));
        Assert.assertEquals(46339, RoundedDownSquareRoot.execute(2147395599));
    }
}
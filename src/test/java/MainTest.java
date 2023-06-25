import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    @Test
    public void testSquareRoot() {
        Assert.assertEquals(4.0743097574926725, Main.calculate("5.4 4.1 2 * 3 + + sqrt"), 0);
    }

    @Test
    public void testOnlyTwoDigits() {
        Assert.assertEquals(9.2, Main.calculate("5.2 4 +"), 0);
    }

    @Test
    public void testMultipleSquareRoots() {
        Assert.assertEquals(8, Main.calculate("16 sqrt 16 sqrt +"), 0);
    }

    @Test
    public void testDivide() {
        Assert.assertEquals(7.25, Main.calculate("10 4.5 + 2 /"), 0);
    }

    @Test
    public void bulkTest() {
        Assert.assertEquals(12, Main.calculate("2 4 sqrt * 8 +"), 0);
        Assert.assertEquals(24, Main.calculate("2 4 8 + *"), 0);
        Assert.assertEquals(-5, Main.calculate("3 2 * 11 -"), 0);
        Assert.assertEquals(2, Main.calculate("2 5 * 4 + 3 2 * 1 + /"), 0);
        Assert.assertEquals(4, Main.calculate("5 4 2 * 3 + + sqrt"), 0);
    }

}
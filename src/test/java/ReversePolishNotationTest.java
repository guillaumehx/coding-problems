import org.junit.Assert;
import org.junit.Test;

public class ReversePolishNotationTest {

    @Test
    public void testSquareRoot() {
        Assert.assertEquals(4.0743097574926725, ReversePolishNotationV1.calculate("5.4 4.1 2 * 3 + + sqrt"), 0);
    }

    @Test
    public void testOnlyTwoDigits() {
        Assert.assertEquals(9.2, ReversePolishNotationV1.calculate("5.2 4 +"), 0);
    }

    @Test
    public void testMultipleSquareRoots() {
        Assert.assertEquals(8, ReversePolishNotationV1.calculate("16 sqrt 16 sqrt +"), 0);
    }

    @Test
    public void testDivide() {
        Assert.assertEquals(7.25, ReversePolishNotationV1.calculate("10 4.5 + 2 /"), 0);
    }

    @Test
    public void testMultipleValues() {
        Assert.assertEquals(12, ReversePolishNotationV1.calculate("2 4 sqrt * 8 +"), 0);
        Assert.assertEquals(24, ReversePolishNotationV1.calculate("2 4 8 + *"), 0);
        Assert.assertEquals(-10, ReversePolishNotationV1.calculate("2 4 8 + -"), 0);
        Assert.assertEquals(-5, ReversePolishNotationV1.calculate("3 2 * 11 -"), 0);
        Assert.assertEquals(2, ReversePolishNotationV1.calculate("2 5 * 4 + 3 2 * 1 + /"), 0);
        Assert.assertEquals(4, ReversePolishNotationV1.calculate("5 4 2 * 3 + + sqrt"), 0);
    }
}

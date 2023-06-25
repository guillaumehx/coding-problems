import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void testSquareRoot() {
        assertEquals(4, Main.calculate("5 4 2 * 3 + + sqrt"));
    }

    @Test
    public void testOnlyTwoDigits() {
        assertEquals(9, Main.calculate("5 4 +"));
    }

    @Test
    public void testMultipleSquareRoots() {
        assertEquals(8, Main.calculate("16 sqrt 16 sqrt +"));
    }

    @Test
    public void testDivide() {
        assertEquals(7, Main.calculate("10 4 + 2 /"));
    }

    @Test
    public void bulkTest() {
        assertEquals(12, Main.calculate("2 4 sqrt * 8 +"));
        assertEquals(24, Main.calculate("2 4 8 + *"));
        assertEquals(-5, Main.calculate("3 2 * 11 -"));
        assertEquals(2, Main.calculate("2 5 * 4 + 3 2 * 1 + /"));
        assertEquals(4, Main.calculate("5 4 2 * 3 + + sqrt"));
    }

}
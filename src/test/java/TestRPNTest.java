import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TestRPNTest {

    @Test
    public void testNotationWithCorrectValues() {
        assertEquals(30.0, TestRPN.execute(List.of("1", "10", "2", "/", "+", "3", "2", "+", "*")), 0.0);
        assertEquals(11.0, TestRPN.execute(List.of("1", "10", "+")), 0.0);
        assertEquals(500.0, TestRPN.execute(List.of("1000", "10", "/", "5", "*")), 0.0);
        assertEquals(0.19444444444444445, TestRPN.execute(List.of("7", "4", "/", "5", "*", "45", "/")), 0.0);
        assertEquals(3.0, TestRPN.execute(List.of("81", "sqrt", "sqrt")), 0.0);
        assertEquals(4.0, TestRPN.execute(List.of("5", "4", "2", "*", "3", "+", "+", "sqrt")), 0.0);
    }

    @Test
    public void testCalculateWithCorrectValues() {
        assertEquals(20.0, TestRPN.calculateValue(10.0,10.0, "+"), 0.0);
        assertEquals(9, TestRPN.calculateValue(null, 81.0, "sqrt"), 0.0);
    }

    @Test
    public void testNotationWithIncorrectOperator() {
        assertThrows(RuntimeException.class, () -> TestRPN.calculateValue(10.0,10.0, "{"));
    }

}
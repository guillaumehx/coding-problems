import org.junit.Assert;
import org.junit.Test;

public class RomanToIntTest {

    @Test
    public void test_1() {
        Assert.assertEquals(1994, RomanToInt.execute("MCMXCIV"));
    }

    @Test
    public void test_2() {
        Assert.assertEquals(58, RomanToInt.execute("LVIII"));
    }

    @Test
    public void test_3() {
        Assert.assertEquals(3, RomanToInt.execute("III"));
    }

    @Test
    public void test_4() {
        Assert.assertEquals(4, RomanToInt.execute("IV"));
    }

    @Test
    public void test_5() {
        Assert.assertEquals(2024, RomanToInt.execute("MMXXIV"));
    }

}
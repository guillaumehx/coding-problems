import org.junit.Assert;
import org.junit.Test;

/**
 * @author Guillaume Houioux ©
 */
public class PalindromeTest {

    @Test
    public void test_1() {
        Assert.assertTrue(Palindrome.execute(123321));
    }

    @Test
    public void test_2() {
        Assert.assertTrue(Palindrome.execute(11));
    }

    @Test
    public void test_3() {
        Assert.assertTrue(Palindrome.execute(0));
    }

    @Test
    public void test_4() {
        Assert.assertTrue(Palindrome.execute(123454321));
    }

    @Test
    public void test_5() {
        Assert.assertFalse(Palindrome.execute(437643));
    }
}

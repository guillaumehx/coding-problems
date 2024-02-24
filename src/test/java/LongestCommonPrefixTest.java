import org.junit.Assert;
import org.junit.Test;

/**
 * @author Guillaume Houioux ©
 */
public class LongestCommonPrefixTest {

    @Test
    public void test() {
        Assert.assertEquals("fl", LongestCommonPrefix.execute(new String[] { "flower","flow","flight" }));
        Assert.assertEquals("", LongestCommonPrefix.execute(new String[] { "dog","racecar","car" }));
        Assert.assertEquals("house", LongestCommonPrefix.execute(new String[] { "house" }));
        Assert.assertEquals("", LongestCommonPrefix.execute(new String[] { }));
        Assert.assertEquals("aa", LongestCommonPrefix.execute(new String[] { "aaaa", "aaa", "aa" }));
    }

}

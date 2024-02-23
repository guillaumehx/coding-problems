import org.junit.Assert;
import org.junit.Test;

public class PigItTest {

    @Test
    public void testAverageString() {
        Assert.assertEquals("elloHay orldway", PigIt.execute("Hello world"));
    }

    @Test
    public void testOnlyOneWordString() {
        Assert.assertEquals("elloHay", PigIt.execute("Hello"));
    }

    @Test
    public void testWithOneCharacterString() {
        Assert.assertEquals("iay aay oay uay", PigIt.execute("i a o u"));
    }

    @Test
    public void testStringWithNonLetters() {
        Assert.assertEquals("eyHay ! owHay reaay ouyay ? oodGay ! hanksTay !", PigIt.execute("Hey ! How are you ? Good ! Thanks !"));
    }
}

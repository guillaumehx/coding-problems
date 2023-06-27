import org.junit.Assert;
import org.junit.Test;

public class PigItTest {

    @Test
    public void testAverageString() {
        Assert.assertEquals("elloHay orldway", PigIt.pigIt("Hello world"));
    }

    @Test
    public void testOnlyOneWordString() {
        Assert.assertEquals("elloHay", PigIt.pigIt("Hello"));
    }

    @Test
    public void testWithOneCharacterString() {
        Assert.assertEquals("iay aay oay uay", PigIt.pigIt("i a o u"));
    }

    @Test
    public void testStringWithNonLetters() {
        Assert.assertEquals("eyHay ! owHay reaay ouyay ? oodGay ! hanksTay !", PigIt.pigIt("Hey ! How are you ? Good ! Thanks !"));
    }
}

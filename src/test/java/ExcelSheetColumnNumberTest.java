import org.junit.Assert;
import org.junit.Test;

public class ExcelSheetColumnNumberTest {

    @Test
    public void test() {
        Assert.assertEquals(703, ExcelSheetColumnNumber.execute("AAA"));
        Assert.assertEquals(1838, ExcelSheetColumnNumber.execute("BRR"));
        Assert.assertEquals(55, ExcelSheetColumnNumber.execute("BC"));
        Assert.assertEquals(701, ExcelSheetColumnNumber.execute("ZY"));
        Assert.assertEquals(28, ExcelSheetColumnNumber.execute("AB"));
    }

}
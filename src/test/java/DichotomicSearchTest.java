import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * @author Guillaume Houioux ©
 */
public class DichotomicSearchTest {

    @Test
    public void testMultipleValues() {
        final Integer[] array = new Integer[] {1, 2, 6, 7, 9, 12, 14, 19, 20, 21, 24};
        final int bi = 0, bs = array.length;

        assertEquals(0, (int) DichotomicSearch.execute(array, bi, bs, 1));
        assertEquals(10, (int) DichotomicSearch.execute(array, bi, bs, 24));
        assertEquals(1, (int) DichotomicSearch.execute(array, bi, bs, 2));
        assertEquals(7, (int) DichotomicSearch.execute(array, bi, bs, 19));
        assertEquals(-1, (int) DichotomicSearch.execute(array, bi, bs, 15));
    }

}

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleSortTest {

    @Test
    public void testFullArray() {
        int[] array = new int[] {2, 7, 9, 1, 4, 6, 2, 8, 3, 0};
        BubbleSort.execute(array);

        assertArrayEquals(new int[] {0, 1, 2, 2, 3, 4, 6, 7, 8, 9}, array);
    }

    @Test
    public void testAlreadySortedArray() {
        int[] array = new int[] {0, 1, 2, 2, 3, 4, 6, 7, 8, 9};
        BubbleSort.execute(array);

        assertArrayEquals(new int[] {0, 1, 2, 2, 3, 4, 6, 7, 8, 9}, array);
    }

    @Test
    public void testOneValueArray() {
        int[] array = new int[] {2};
        BubbleSort.execute(array);

        assertArrayEquals(new int[] {2}, array);
    }

    @Test
    public void testEmptyArray() {
        int[] array = new int[] {};
        BubbleSort.execute(array);

        assertArrayEquals(new int[] {}, array);
    }

}
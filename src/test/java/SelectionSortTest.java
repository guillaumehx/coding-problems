import org.junit.Test;

import static org.junit.Assert.*;

public class SelectionSortTest {

    @Test
    public void testFullArray() {
        int[] array = new int[] {2, 7, 9, 1, 4, 6, 2, 8, 3, 0};
        SelectionSort.execute(array);

        assertArrayEquals(new int[] {0, 1, 2, 2, 3, 4, 6, 7, 8, 9}, array);
    }

    @Test
    public void testOneValueArray() {
        int[] array = new int[] {2};
        SelectionSort.execute(array);

        assertArrayEquals(new int[] {2}, array);
    }

    @Test
    public void testEmptyArray() {
        int[] array = new int[] {};
        SelectionSort.execute(array);

        assertArrayEquals(new int[] {}, array);
    }
}
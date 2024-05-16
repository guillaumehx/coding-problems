package binarytree;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    private final int[] arr = new int[] {2, 4, 6, 8, 10, 11, 11, 12, 16, 18, 20};
    private final int[] arrCyclique = new int[] {10, 11, 11, 12, 16, 18, 20, 2, 4, 6, 8};
    private int bi = 0;
    private int bs = arr.length - 1;

    @Test
    public void testDichomoticSearchTrue() {
        assertTrue(BinaryTreeUtils.rechercheDichotomique(arr, 20, bi, bs));
        assertTrue(BinaryTreeUtils.rechercheDichotomique(arr, 11, bi, bs));
        assertTrue(BinaryTreeUtils.rechercheDichotomique(arr, 2, bi, bs));
        assertTrue(BinaryTreeUtils.rechercheDichotomique(arr, 18, bi, bs));

    }

    @Test
    public void testDichomoticSearchFalse() {
        assertFalse(BinaryTreeUtils.rechercheDichotomique(arr, 1, bi, bs));
        assertFalse(BinaryTreeUtils.rechercheDichotomique(arr, -100, bi, bs));
        assertFalse(BinaryTreeUtils.rechercheDichotomique(arr, 21, bi, bs));
        assertFalse(BinaryTreeUtils.rechercheDichotomique(arr, 2000000, bi, bs));

    }


    @Test
    public void testDichomoticSearchCycliqueTrue() {
        assertTrue(BinaryTreeUtils.rechercheDichotomiqueCyclique(arrCyclique, 11, bi, bs));
        assertTrue(BinaryTreeUtils.rechercheDichotomiqueCyclique(arrCyclique, 8, bi, bs));
        assertTrue(BinaryTreeUtils.rechercheDichotomiqueCyclique(arrCyclique, 10, bi, bs));
        assertTrue(BinaryTreeUtils.rechercheDichotomiqueCyclique(arrCyclique, 18, bi, bs));
    }

    @Test
    public void testDichomoticSearchCycliqueFalse() {
        assertFalse(BinaryTreeUtils.rechercheDichotomiqueCyclique(arrCyclique, 9, bi, bs));
        assertFalse(BinaryTreeUtils.rechercheDichotomiqueCyclique(arrCyclique, 13, bi, bs));
        assertFalse(BinaryTreeUtils.rechercheDichotomiqueCyclique(arrCyclique, 1, bi, bs));
        assertFalse(BinaryTreeUtils.rechercheDichotomiqueCyclique(arrCyclique, -100, bi, bs));
        assertFalse(BinaryTreeUtils.rechercheDichotomiqueCyclique(arrCyclique, 21, bi, bs));
        assertFalse(BinaryTreeUtils.rechercheDichotomiqueCyclique(arrCyclique, 2000000, bi, bs));
    }

}
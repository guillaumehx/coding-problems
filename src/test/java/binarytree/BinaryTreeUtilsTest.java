package binarytree;

import org.junit.Test;

public class BinaryTreeUtilsTest {

    @Test
    public void testOddNodes() {
        Node<Integer> T = BinarySearchTreeUtils.createTree(10, 20);
        BinaryTreeUtils.Printer.printClean(T);
        System.out.println(BinaryTreeUtils.numberOfOddNodes(T));
    }

}

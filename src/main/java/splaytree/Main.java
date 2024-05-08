package splaytree;

import binarytree.BinaryTreeUtils;
import binarytree.Node;

public class Main {

    public static void main(String[] args) {
        Node<Integer> z = new Node<>(10);
        Node<Integer> y = new Node<>(8);
        Node<Integer> x = new Node<>(7);

        z.setLeft(y);
        y.setLeft(x);

        x.setParent(y);
        y.setParent(z);

        BinaryTreeUtils.Printer.printCompact(z);
        SplayTreeUtils.splay(z, 8);
        BinaryTreeUtils.Printer.printCompact(z);
    }
}

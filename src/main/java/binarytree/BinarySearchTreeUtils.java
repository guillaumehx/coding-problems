package binarytree;

import java.util.Random;

public class BinarySearchTreeUtils {

    public static Node<Integer> createTree(Integer numberOfNodes, Integer maxValue) {
        Random random = new Random();
        Node<Integer> tree = null;
        for (int i = 0; i < numberOfNodes; i++) {
            tree = BinarySearchTreeUtils.insertBST(tree, random.nextInt(maxValue));
        }
        return tree;
    }

    public static boolean searchBST(final Node<Integer> T, int k) {
        if (T == null) {
            return false;
        }

        if (k == T.getKey()) {
            return true;
        } else if (k > T.getKey()) {
            return searchBST(T.getRight(), k);
        } else {
            return searchBST(T.getLeft(), k);
        }
    }

    public static boolean searchIterativeBST(final Node<Integer> T, int k) {
        Node<Integer> p = T;

        while (p != null && p.getKey() != k) {
            if (k < p.getKey()) {
                p = p.getLeft();
            } else if (k > p.getKey()) {
                p = p.getRight();
            }
        }

        if (p != null) {
            return true;
        }

        return false;
    }

    public static Node<Integer> insertBST(final Node<Integer> T, int k) {
        if (T == null) {
            return new Node<>(k);
        }

        if (k <= T.getKey()) {
            Node<Integer> p = insertBST(T.getLeft(), k);
            T.setLeft(p);
        }

        if (k > T.getKey()) {
            Node<Integer> p = insertBST(T.getRight(), k);
            T.setRight(p);
        }

        return T;
    }

    public static Node<Integer> insertIterativeBST(final Node<Integer> T, int k) {

        if (T == null) {
            return new Node<>(k);
        }

        Node<Integer> p = T;
        boolean fin = false;

        while (!fin) {
            if (k < p.getKey()) {
                if (p.getLeft() == null) {
                    p.setLeft(new Node<>(k));
                    fin = true;
                } else {
                    p = p.getLeft();
                }
            } else if (k > p.getKey()) {
                if (p.getRight() == null) {
                    p.setRight(new Node<>(k));
                    fin = true;
                } else {
                    p = p.getRight();
                }
            }
        }

        return T;
    }

    public static Node<Integer> deleteBST(Node<Integer> T, int k) {
        if (k < T.getKey()) {
            T.setLeft(deleteBST(T.getLeft(), k));
        } else if (k > T.getKey()) {
            T.setRight(deleteBST(T.getRight(), k));
        } else {
            if (T.getLeft() == null) {
                Node<Integer> p = T.getRight();
                T = null;
                T = p;
            } else if (T.getRight() == null) {
                Node<Integer> p = T.getLeft();
                T = null;
                T = p;
            } else {
                Node<Integer> max = maximumBST(T.getLeft());
                T.setKey(max.getKey());
                T.setLeft(deleteBST(T.getLeft(), max.getKey()));
            }
        }
        return T;
    }

    public static Node<Integer> maximumBST(final Node<Integer> T) {
        if (T.getRight() != null) {
            return maximumBST(T.getRight());
        } else {
            return T;
        }
    }

    public static Node<Integer> minimumBST(final Node<Integer> T) {
        if (T.getLeft() != null) {
            return minimumBST(T.getLeft());
        } else {
            return T;
        }
    }
}

package binarytree;

public class BinarySearchTreeUtils {

    public static boolean rechercheRecursiveABR(final Node<Integer> A, int k) {
        if (A == null) {
            return false;
        }

        if (k == A.getKey()) {
            return true;
        } else if (k > A.getKey()) {
            return rechercheRecursiveABR(A.getRight(), k);
        } else {
            return rechercheRecursiveABR(A.getLeft(), k);
        }
    }

    public static boolean rechercheIterativeABR(final Node<Integer> A, int k) {
        Node<Integer> p = A;

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

    public static Node<Integer> insertionRecursiveABR(final Node<Integer> A, int k) {
        if (A == null) {
            return new Node<>(k);
        }

        if (k <= A.getKey()) {
            Node<Integer> p = insertionRecursiveABR(A.getLeft(), k);
            A.setLeft(p);
        }

        if (k > A.getKey()) {
            Node<Integer> p = insertionRecursiveABR(A.getRight(), k);
            A.setRight(p);
        }

        return A;
    }

    public static Node<Integer> insertionIterativeABR(final Node<Integer> A, int k) {

        if (A == null) {
            return new Node<>(k);
        }

        Node<Integer> p = A;
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

        return A;
    }

    public static Node<Integer> suppressionABR(Node<Integer> A, int k) {
        if (k < A.getKey()) {
            A.setLeft(suppressionABR(A.getLeft(), k));
        } else if (k > A.getKey()) {
            A.setRight(suppressionABR(A.getRight(), k));
        } else {
            if (A.getLeft() == null) {
                Node<Integer> p = A.getRight();
                A = null;
                A = p;
            } else if (A.getRight() == null) {
                Node<Integer> p = A.getLeft();
                A = null;
                A = p;
            } else {
                Node<Integer> max = maximumABR(A.getLeft());
                A.setKey(max.getKey());
                A.setLeft(suppressionABR(A.getLeft(), max.getKey()));
            }
        }
        return A;
    }

    public static Node<Integer> maximumABR(final Node<Integer> A) {
        if (A.getRight() != null) {
            return maximumABR(A.getRight());
        } else {
            return A;
        }
    }

    public static Node<Integer> minimumABR(final Node<Integer> A) {
        if (A.getLeft() != null) {
            return maximumABR(A.getLeft());
        } else {
            return A;
        }
    }
}

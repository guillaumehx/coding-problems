package binarytree;

public class AVLTreeUtils {

    public static void main(String[] args) {

        Node<Integer> n_17 = new Node<>(17);
        n_17.setHeight(4);
        Node<Integer> n_15 = new Node<>(15);
        n_15.setHeight(2);
        Node<Integer> n_10 = new Node<>(10);
        n_10.setHeight(1);
        Node<Integer> n_20 = new Node<>(20);
        n_20.setHeight(3);
        Node<Integer> n_30 = new Node<>(30);
        n_30.setHeight(2);
        Node<Integer> n_22 = new Node<>(22);
        n_22.setHeight(1);

        n_15.setLeft(n_10);
        n_17.setLeft(n_15);
        n_30.setLeft(n_22);
        n_20.setRight(n_30);
        n_17.setRight(n_20);


        insertionAVL(n_17, 23);


        BinaryTreeUtils.Printer.printClean(n_17);
    }

    public static boolean rechercheAVL(final Node<Integer> A, int k) {
         if (A == null) {
             return false;
         }

        if (A.getKey() == k) {
            return true;
        } else if (k < A.getKey()) {
            return rechercheAVL(A.getLeft(), k);
        } else {
            return rechercheAVL(A.getRight(), k);
        }
    }

    public static Node<Integer> insertionAVL(Node<Integer> A, int k) {
        if (A == null) {
            Node<Integer> ne = new Node<>(k);
            ne.setHeight(1);
            return ne;
        } else {
            if (k < A.getKey()) {
                Node<Integer> p = insertionRecursiveAVL(A.getLeft(), k);
                A.setLeft(p);
                A = equilibrer(A);
            } else if (k > A.getKey()) {
                Node<Integer> p = insertionRecursiveAVL(A.getRight(), k);
                A.setRight(p);
                A = equilibrer(A);
            }
            return A;
        }
    }

    public static Node<Integer> equilibrer(Node<Integer> A) {
        if (bal(A) == 2) {
            if (bal(A.getRight()) >= 0) {
                A = rotationGauche(A);
            } else {
                A.setRight(rotationDroite(A.getRight()));
                A = rotationGauche(A);
            }
        } else {
            if (bal(A) == -2) {
                if (bal(A.getLeft()) <= 0) {
                    A = rotationDroite(A);
                } else {
                    A.setLeft(rotationGauche(A.getLeft()));
                    A = rotationDroite(A);
                }
            } else {
                hauteur(A);
            }
        }
        return A;
    }

    public static int bal(final Node<Integer> A) {
        int bal;
        if (A.getLeft() == null && A.getRight() == null) {
            bal = 0;
        } else {
            if (A.getLeft() == null) {
                bal = A.getRight().getHeight();
            } else {
                if (A.getRight() == null) {
                    bal = (A.getLeft().getHeight() * -1);
                } else {
                    bal = A.getRight().getHeight() - A.getLeft().getHeight();
                }
            }
        }
        return bal;
    }

    public static void hauteur(final Node<Integer> A) {
        if (A.getLeft() == null && A.getRight() == null) {
            A.setHeight(1);
        } else {
            if (A.getLeft() == null) {
                A.setHeight(1 + A.getRight().getHeight());
            } else {
                if (A.getRight() == null) {
                    A.setHeight(1 + A.getLeft().getHeight());
                } else {
                    A.setHeight(1 + Math.max(A.getRight().getHeight(), A.getLeft().getHeight()));
                }
            }
        }
    }

    public static Node<Integer> rotationGauche(Node<Integer> A) {
        Node<Integer> temp = A;
        A = A.getRight();
        temp.setRight(A.getLeft());
        A.setLeft(temp);
        return A;
    }

    public static Node<Integer> rotationDroite(Node<Integer> A) {
        Node<Integer> temp = A;
        A = A.getLeft();
        temp.setLeft(A.getRight());
        A.setRight(temp);
        return A;
    }

}

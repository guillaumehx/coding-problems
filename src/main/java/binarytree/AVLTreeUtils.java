package binarytree;

public class AVLTreeUtils {

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(63);
        root.setLeft(new Node<>(9));

        insertionRecursiveAVL(root, 19);


        BinaryTreeUtils.Printer.printClean(root);
    }

    public static boolean rechercheRecursiveAVL(final Node<Integer> A, int k) {
         if (A == null) {
             return false;
         }

        if (A.getKey() == k) {
            return true;
        } else if (k < A.getKey()) {
            return rechercheRecursiveAVL(A.getLeft(), k);
        } else {
            return rechercheRecursiveAVL(A.getRight(), k);
        }
    }

    public static Node<Integer> insertionRecursiveAVL(final Node<Integer> A, int k) {
        if (A == null) {
            return new Node<>(k);
        } else {
            if (k < A.getKey()) {
                Node<Integer> p = insertionRecursiveAVL(A.getLeft(), k);
                A.setLeft(p);
                equilibrer(A);
            } else if (k > A.getKey()) {
                Node<Integer> p = insertionRecursiveAVL(A.getRight(), k);
                A.setRight(p);
                equilibrer(A);
            }
            return A;
        }
    }

    public static void equilibrer(Node<Integer> A) {
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
            }
        }
    }

    public static int bal(final Node<Integer> A) {
        int bal;
        if (A.getLeft() == null && A.getRight() == null) {
            bal = 0;
        } else {
            if (A.getLeft() == null) {
                bal = hauteur(A.getRight());
            } else {
                if (A.getRight() == null) {
                    bal = (hauteur(A.getLeft()) * -1);
                } else {
                    bal = hauteur(A.getRight()) - hauteur(A.getLeft());
                }
            }
        }
        return bal;
    }

    public static int hauteur(final Node<Integer> A) {
        if (A.getLeft() == null && A.getRight() == null) {
            return 1;
        } else {
            if (A.getLeft() == null) {
                return 1 + hauteur(A.getRight());
            } else {
                if (A.getRight() == null) {
                    return 1 + hauteur(A.getLeft());
                } else {
                    return 1 + Math.max(hauteur(A.getRight()), hauteur(A.getLeft()));
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

package binarytree;

import org.javatuples.Pair;

public class AVLTreeUtils {

    public static void main(String[] args) {

        Node<Integer> n_15 = new Node<>(15);
        n_15.setHeight(3);
        Node<Integer> n_9 = new Node<>(9);
        n_9.setHeight(2);
        Node<Integer> n_14 = new Node<>(14);
        n_14.setHeight(1);
        Node<Integer> n_71 = new Node<>(71);
        n_71.setHeight(2);
        Node<Integer> n_66 = new Node<>(66);
        n_66.setHeight(1);
        Node<Integer> n_96 = new Node<>(96);
        n_96.setHeight(1);

        n_71.setRight(n_96);
        n_71.setLeft(n_66);
        n_9.setRight(n_14);
        n_15.setLeft(n_9);
        n_15.setRight(n_71);

        BinaryTreeUtils.Printer.printClean(n_15);
        n_15 = insertionAVL(n_15, 69);
        n_15 = insertionAVL(n_15, 70);
        n_15 = insertionAVL(n_15, 65);
        n_15 = insertionAVL(n_15, 64);
        n_15 = insertionAVL(n_15, 63);
        n_15 = suppressionAVL(n_15, 65);
        BinaryTreeUtils.Printer.printClean(n_15);
        //BinaryTreeUtils.Printer.printCompact(n_15);
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
            A = new Node<>(k);
            A.setHeight(1);
        } else {
            if (k < A.getKey()) {
                A.setLeft(insertionAVL(A.getLeft(), k));
                A = equilibrer(A);
            } else if (k > A.getKey()) {
                A.setRight(insertionAVL(A.getRight(), k));
                A = equilibrer(A);
            }
        }
        return A;
    }

    public static Node<Integer> suppressionAVL(Node<Integer> A, int k) {
        if (A != null) {
            if (k < A.getKey()) {
                A.setLeft(suppressionAVL(A.getLeft(), k));
                A = equilibrer(A);
            } else {
                if (k > A.getKey()) {
                    A.setRight(suppressionAVL(A.getRight(), k));
                    A = equilibrer(A);
                } else {
                    A = suppressionRacineAVL(A);
                }
            }
        }
        return A;
    }

    public static Node<Integer> suppressionRacineAVL(Node<Integer> A) {
        if (estFeuille(A)) {
            A = null;
        } else {
            if (A.getLeft() == null) {
                A = A.getRight();
            } else {
                if (A.getRight() == null) {
                    A = A.getLeft();
                } else {
                    Pair<Integer, Node<Integer>> pair = suppressionMinAVL(A.getRight());
                    A.setKey(pair.getValue0());
                    A.setRight(pair.getValue1());
                    A = equilibrer(A);
                }
            }
        }
        return A;
    }

    public static Pair<Integer, Node<Integer>> suppressionMinAVL(Node<Integer> A) {
        int minimum;
        if (A.getLeft() == null) {
            minimum = A.getKey();
            A = A.getRight();
        } else {
            Pair<Integer, Node<Integer>> pair = suppressionMinAVL(A.getLeft());
            minimum = pair.getValue0();
            A.setLeft(pair.getValue1());
            A = equilibrer(A);
        }
        return new Pair<>(minimum, A);
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
        if (estFeuille(A)) {
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
        if (estFeuille(A)) {
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
        hauteur(temp);
        hauteur(A);
        return A;
    }

    public static Node<Integer> rotationDroite(Node<Integer> A) {
        Node<Integer> temp = A;
        A = A.getLeft();
        temp.setLeft(A.getRight());
        A.setRight(temp);
        hauteur(temp);
        hauteur(A);
        return A;
    }

    public static boolean estFeuille(final Node<Integer> A) {
        if (A.getLeft() == null && A.getRight() == null) {
            return true;
        }
        return false;
    }

}

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
        System.out.println(checkAVL(n_15));
        n_15 = insertAVL(n_15, 69);
        System.out.println(checkAVL(n_15));
        n_15 = insertAVL(n_15, 70);
        System.out.println(checkAVL(n_15));
        n_15 = insertAVL(n_15, 65);
        System.out.println(checkAVL(n_15));
        n_15 = insertAVL(n_15, 64);
        System.out.println(checkAVL(n_15));
        n_15 = insertAVL(n_15, 63);
        System.out.println(checkAVL(n_15));
        BinaryTreeUtils.Printer.printClean(n_15);
        n_15 = deleteAVL(n_15, 65);
        System.out.println(checkAVL(n_15));
        BinaryTreeUtils.Printer.printClean(n_15);
        //BinaryTreeUtils.Printer.printCompact(n_15);
    }

    public static boolean searchAVL(final Node<Integer> T, int k) {
        if (T == null) {
             return false;
        }
        if (T.getKey() == k) {
            return true;
        } else if (k < T.getKey()) {
            return searchAVL(T.getLeft(), k);
        } else {
            return searchAVL(T.getRight(), k);
        }
    }

    public static Node<Integer> insertAVL(Node<Integer> T, int k) {
        if (T == null) {
            T = new Node<>(k);
            T.setHeight(1);
        } else {
            if (k < T.getKey()) {
                T.setLeft(insertAVL(T.getLeft(), k));
                T = balanceTree(T);
            } else if (k > T.getKey()) {
                T.setRight(insertAVL(T.getRight(), k));
                T = balanceTree(T);
            }
        }
        return T;
    }

    public static Node<Integer> deleteAVL(Node<Integer> T, int k) {
        if (T != null) {
            if (k < T.getKey()) {
                T.setLeft(deleteAVL(T.getLeft(), k));
                T = balanceTree(T);
            } else {
                if (k > T.getKey()) {
                    T.setRight(deleteAVL(T.getRight(), k));
                    T = balanceTree(T);
                } else {
                    T = deleteRootAVL(T);
                }
            }
        }
        return T;
    }

    public static Node<Integer> deleteRootAVL(Node<Integer> T) {
        if (isLeaf(T)) {
            T = null;
        } else {
            if (T.getLeft() == null) {
                T = T.getRight();
            } else {
                if (T.getRight() == null) {
                    T = T.getLeft();
                } else {
                    Pair<Integer, Node<Integer>> pair = deleteMinimumAVL(T.getRight());
                    T.setKey(pair.getValue0());
                    T.setRight(pair.getValue1());
                    T = balanceTree(T);
                }
            }
        }
        return T;
    }

    public static Pair<Integer, Node<Integer>> deleteMinimumAVL(Node<Integer> T) {
        int minimum;
        if (T.getLeft() == null) {
            minimum = T.getKey();
            T = T.getRight();
        } else {
            Pair<Integer, Node<Integer>> pair = deleteMinimumAVL(T.getLeft());
            minimum = pair.getValue0();
            T.setLeft(pair.getValue1());
            T = balanceTree(T);
        }
        return new Pair<>(minimum, T);
    }

    public static Node<Integer> balanceTree(Node<Integer> T) {
        if (getBalance(T) == 2) {
            if (getBalance(T.getRight()) >= 0) {
                T = leftRotation(T);
            } else {
                T.setRight(rightRotation(T.getRight()));
                T = leftRotation(T);
            }
        } else {
            if (getBalance(T) == -2) {
                if (getBalance(T.getLeft()) <= 0) {
                    T = rightRotation(T);
                } else {
                    T.setLeft(leftRotation(T.getLeft()));
                    T = rightRotation(T);
                }
            } else {
                setHeight(T);
            }
        }
        return T;
    }

    public static int getBalance(final Node<Integer> T) {
        int bal;
        if (isLeaf(T)) {
            bal = 0;
        } else {
            if (T.getLeft() == null) {
                bal = T.getRight().getHeight();
            } else {
                if (T.getRight() == null) {
                    bal = (T.getLeft().getHeight() * -1);
                } else {
                    bal = T.getRight().getHeight() - T.getLeft().getHeight();
                }
            }
        }
        return bal;
    }

    public static void setHeight(final Node<Integer> T) {
        if (isLeaf(T)) {
            T.setHeight(1);
        } else {
            if (T.getLeft() == null) {
                T.setHeight(1 + T.getRight().getHeight());
            } else {
                if (T.getRight() == null) {
                    T.setHeight(1 + T.getLeft().getHeight());
                } else {
                    T.setHeight(1 + Math.max(T.getRight().getHeight(), T.getLeft().getHeight()));
                }
            }
        }
    }

    public static Node<Integer> leftRotation(Node<Integer> T) {
        Node<Integer> temp = T;
        T = T.getRight();
        temp.setRight(T.getLeft());
        T.setLeft(temp);
        setHeight(temp);
        setHeight(T);
        return T;
    }

    public static Node<Integer> rightRotation(Node<Integer> T) {
        Node<Integer> temp = T;
        T = T.getLeft();
        temp.setLeft(T.getRight());
        T.setRight(temp);
        setHeight(temp);
        setHeight(T);
        return T;
    }

    public static boolean isLeaf(final Node<Integer> T) {
        if (T.getLeft() == null && T.getRight() == null) {
            return true;
        }
        return false;
    }

    public static boolean checkAVL(final Node<Integer> T) {
        return isAVL(T).getValue1();
    }

    private static Pair<Integer, Boolean> isAVL(final Node<Integer> T) {

        if (T == null) {
            return new Pair<>(0, true);
        }

        Pair<Integer, Boolean> leftAvl = isAVL(T.getLeft());
        Pair<Integer, Boolean> rightAvl = isAVL(T.getRight());
        int heightDifference = Math.abs(rightAvl.getValue0() - leftAvl.getValue0());
        int max = Math.max(rightAvl.getValue0(), leftAvl.getValue0());

        if (heightDifference <= 1 && leftAvl.getValue1() && rightAvl.getValue1()) {
            return new Pair<>(max + 1, true);
        } else {
            return new Pair<>(max + 1, false);
        }
    }

}

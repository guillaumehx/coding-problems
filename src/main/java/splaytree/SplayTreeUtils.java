package splaytree;

import binarytree.BinaryTreeUtils;
import binarytree.Node;

public class SplayTreeUtils {


    public static Node<Integer> recherche(Node<Integer> racine, Integer k) {
        if (racine.getKey().equals(k)) {
            splay(racine, k);
            return racine;
        }
        if (k < racine.getKey()) {
            if (racine.getLeft() == null) {
                splay(racine,k );
                return racine;
            } else {
                return recherche(racine.getLeft(), k);
            }
        } else {
            if (racine.getRight() == null) {
                splay(racine,k);
                return racine;
            } else {
                return recherche(racine.getRight(), k);
            }
        }
    }

    public static Node<Integer>[] split(Node<Integer> racine, Integer k) {
        if (racine == null) {
            return new Node[] {null, null};
        }
        Node<Integer> nouvelleRacine = recherche(racine, k);
        if (nouvelleRacine.getKey() > k) {
            Node<Integer> arbreGauche = nouvelleRacine.getLeft();
            nouvelleRacine.setLeft(null);
            return new Node[] {arbreGauche, nouvelleRacine};
        } else {
            Node<Integer> arbreDroit = nouvelleRacine.getRight();
            nouvelleRacine.setRight(null);
            return new Node[] {nouvelleRacine, arbreDroit};
        }
    }

    public static Node<Integer> insertion(Node<Integer> racine, Integer k) {
        Node<Integer>[] noeuds = split(racine, k);
        Node<Integer> nouveauNoeud = new Node<>(k);
        nouveauNoeud.setLeft(noeuds[0]);
        nouveauNoeud.setRight(noeuds[1]);
        return nouveauNoeud;
    }

    public static Node<Integer> join(Node<Integer> premierArbre, Node<Integer> deuxiemeArbre) {
        if (premierArbre == null) {
            return deuxiemeArbre;
        }
        if (deuxiemeArbre == null) {
            return premierArbre;
        }
        Node<Integer> max = maximum(premierArbre);
        splay(max, 10);
        max.setRight(deuxiemeArbre);
        return max;
    }

    public static Node<Integer> maximum(Node<Integer> root) {
        if (root == null)
            return null;

        Node<Integer> current = root;
        while (current.getRight() != null) {
            current = current.getRight();
        }
        return current;
    }

    public static Node<Integer> suppression(Node<Integer> racine, Integer k) {
        Node<Integer> noeud = recherche(racine, k);
        noeud = join(noeud.getLeft(), noeud.getRight());
        return noeud;
    }

    public static void sptttlay(Node<Integer> x) {
        Node<Integer> p = x.getParent();
        Node<Integer> g = p.getParent();

        do {
            if (x == p.getLeft()) {
                if (g != null && p == g.getLeft()) {
                    zigRight(p);
                } else {
                    //return;
                }
                zigRight(x);
            }
            if (x == p.getRight()) {
                if (g != null && p == g.getRight()) {
                    rotationGauche(p);
                } else {
                    //return;
                }
                rotationGauche(x);
            }
            //p = x.getParent();
            //g = p.getParent();
        } while (p == null);

    }

    public static void zigLeft(Node<Integer> x) {

    }

    public static void zigRight(Node<Integer> y) {

        Node<Integer> temp = new Node<>(y.getParent().getKey());
        temp.setParent(y);
        y.getParent().setKey(y.getKey());
        y.setKey(y.getLeft().getKey());
        y.getLeft().setParent(null);
        y.setLeft(null);
        y.getParent().setRight(temp);

        //y.setParent(null);
        //y.setParent(y);

        //BinaryTreeUtils.Printer.printCompact(y);
//
//
        //Node<Integer> oldZ = y.getParent();
        //Node<Integer> oldY = y;
        //oldZ.setLeft(null);
        //oldY.setParent(null);
//
        //oldY.setRight(oldZ);
        //oldZ.setParent(oldY);

//
        //Node<Integer> oldY = y;
        //oldY.setParent(null);
        //oldY.setRight(oldZ);
//
//
        //y.setParent(oldY);
    }


    public static void rotationDroite(Node<Integer> y) {
        Node<Integer> x = y.getLeft();
        Node<Integer> z = y.getParent();


        if (z == null) {
            return;
        }

        if (z.getLeft() == y) {
            z.setLeft(x);
        }
        if (z.getRight() == y) {
            z.setRight(x);
        }

        y.setLeft(x.getRight());
        y.setParent(x);
        x.setRight(y);
        x.setParent(z);

        if (y.getLeft() == null) {
            return;
        }

        y.getLeft().setParent(y);
    }

    public static void rotationGauche(Node<Integer> y) {
        Node<Integer> x = y.getRight();
        Node<Integer> z = y.getParent();

        if (z == null) {
            return;
        }

        if (z.getLeft() == y) {
            z.setLeft(x);
        }
        if (z.getRight() == y) {
            z.setRight(x);
        }

        y.setRight(x.getLeft());
        y.setParent(x);
        x.setLeft(y);
        x.setParent(z);

        if (y.getRight() == null) {
            return;
        }

        if (y.getRight() != null) {
            y.getRight().setParent(y);
        }

    }


















    static Node<Integer> rightRotate(Node<Integer> x) {
        Node<Integer> y = x.getLeft();
        x.setLeft(y.getRight());
        y.setRight(x);
        return y;
    }

    static Node<Integer> leftRotate(Node<Integer> x) {
        Node<Integer> y = x.getRight();
        x.setRight(y.getLeft());
        y.setLeft(x);
        return y;
    }

    static Node<Integer> splay(Node<Integer> root, int key) {
        if (root == null || root.getKey() == key)
            return root;

        if (root.getKey() > key) {
            if (root.getLeft() == null)
                return root;
            if (root.getLeft().getKey() > key) {
                root.getLeft().setLeft(splay(root.getLeft().getLeft(), key));
                root = rightRotate(root);
            }
            else if (root.getLeft().getKey() < key) {
                root.getLeft().setRight(splay(root.getLeft().getRight(), key));
                if (root.getLeft().getRight() != null)
                    root.setLeft(leftRotate(root.getLeft()));
            }
            return (root.getLeft() == null) ? root : rightRotate(root);
        }
        else {
            if (root.getRight() == null)
                return root;
            if (root.getRight().getKey() > key) {
                root.getRight().setLeft(splay(root.getRight().getLeft(), key));
                if (root.getRight().getLeft() != null)
                    root.setRight(rightRotate(root.getRight()));
            }
            else if (root.getRight().getKey() < key) {
                root.getRight().setRight(splay(root.getRight().getRight(), key));
                root = leftRotate(root);
            }
            return (root.getRight() == null) ? root : leftRotate(root);
        }
    }










}

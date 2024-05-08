package binarytree;

public class Main {
    public static void main(String[] args) {

        //Node<String> root = new Node<>("A");
        //Node<String> nB = new Node<>("B");
        //Node<String> nC = new Node<>("C");
        //Node<String> nD = new Node<>("D");
        //Node<String> nE = new Node<>("E");
        //Node<String> nF = new Node<>("F");
        //Node<String> nG = new Node<>("G");
        //Node<String> nH = new Node<>("H");
        //Node<String> nI = new Node<>("I");
        //Node<String> nJ = new Node<>("J");
        //Node<String> nK = new Node<>("K");
//
        //root.setChildren(nB, nC);
        //nB.setChildren(nD, nE);
        //nE.setChildren(nH, nI);
        //nH.setLeft(nK);
        //nD.setRight(nG);
        //nC.setRight(nF);
        //nF.setLeft(nJ);
//
        //BinaryTreeUtils.Printer.printClean(root);
        //System.out.println(BinaryTreeUtils.hauteur(root));


        //if (true) {
        //    return;
        //}


        //BinaryTreeUtils.Printer.printClean(root);
        //BinaryTreeUtils.Printer.printCompact(root);
//
//
        //BinaryTreeUtils.parcoursDiagonalV2(root);
        //System.out.println();
        //BinaryTreeUtils.parcoursDiagonalV1(root, null);
//
        //System.out.println();
//
//
        //BinaryTreeUtils.parcoursPrefixe(root);
        //System.out.println();
        //BinaryTreeUtils.parcoursInfixe(root);
        //System.out.println();
        //BinaryTreeUtils.parcoursPostfixe(root);
        //System.out.println();


        //Node<String> rootAdd = new Node<>("+");
        //Node<String> nDiv = new Node<>("/");
        //Node<String> nMulti = new Node<>("*");
        //Node<String> n8 = new Node<>("8");
        //Node<String> n2 = new Node<>("2");
        //Node<String> n3 = new Node<>("3");
        //Node<String> n5 = new Node<>("5");
        //Node<String> n22 = new Node<>("2");
        //Node<String> nMinus = new Node<>("-");

        Node<String> rootAdd = new Node<>("∧");
        Node<String> nDiv = new Node<>("p1");
        Node<String> nMulti = new Node<>("∨");
        Node<String> n3 = new Node<>("¬");
        Node<String> n5 = new Node<>("p1");
        Node<String> n22 = new Node<>("false");
        Node<String> nMinus = new Node<>("⇒");
        Node<String> nil = new Node<>("nil");
        Node<String> p2 = new Node<>("p2");
        Node<String> p3 = new Node<>("p3");
        Node<String> v = new Node<>("∨");

        //Node<Integer> rootAdd = new Node<>(10);
        //Node<Integer> nDiv = new Node<>(5);
        //Node<Integer> nMulti = new Node<>(15);
        //Node<Integer> n8 = new Node<>(5);
        //Node<Integer> n2 = new Node<>(7);
        //Node<Integer> n3 = new Node<>(12);
        //Node<Integer> n5 = new Node<>(17);
        //Node<Integer> n22 = new Node<>(20);
        //Node<Integer> nMinus = new Node<>(19);

        rootAdd.setLeft(nDiv);
        rootAdd.setRight(nMulti);

        v.setLeft(p2);
        v.setRight(p3);

        n3.setLeft(v);
        n3.setRight(nil);

        nMulti.setLeft(n3);
        nMulti.setRight(nMinus);

        nMinus.setLeft(n5);
        nMinus.setRight(n22);

        BinaryTreeUtils.Printer.printClean(rootAdd);


        Boolean[] bool = new Boolean[] { true, false, false };

        System.out.println(Exercice.evaluerExpressionBooleenne(rootAdd, bool));

        //System.out.println(BinaryTreeUtils.hauteurDeX(rootAdd, 20));

        //System.out.println(BinaryTreeUtils.hauteur(rootAdd));
        //System.out.println(BinaryTreeUtils.maxFromTree(rootAdd));
        //System.out.println(BinaryTreeUtils.minFromTree(rootAdd));
        //System.out.println(BinaryTreeUtils.isBST(rootAdd));

        if (true) {
            return;
        }

        //BinaryTreeUtils.afficherExpression1(rootAdd);
        //System.out.println();
        //BinaryTreeUtils.parcoursPostfixe(rootAdd);
        //System.out.println();
        //System.out.println(BinaryTreeUtils.evaluerExpression(rootAdd));

        //BinaryTreeUtils.Printer.printClean(BinaryTreeUtils.createTreeFromRPN("8 2 / 3 5 2 - * +"));

        //BinaryTreeUtils.parcoursLargeur(root);

    }
}

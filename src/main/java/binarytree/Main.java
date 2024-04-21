package binarytree;

public class Main {
    public static void main(String[] args) {

        Node<String> root = new Node<>("A");
        Node<String> nB = new Node<>("B");
        Node<String> nC = new Node<>("C");
        Node<String> nD = new Node<>("D");
        Node<String> nE = new Node<>("E");
        Node<String> nF = new Node<>("F");
        Node<String> nG = new Node<>("G");
        Node<String> nH = new Node<>("H");
        Node<String> nI = new Node<>("I");
        Node<String> nJ = new Node<>("J");
        Node<String> nK = new Node<>("K");

        root.setChildren(nB, nC);
        nB.setChildren(nD, nE);
        nE.setChildren(nH, nI);
        nH.setLeft(nK);
        nD.setRight(nG);
        nC.setRight(nF);
        nF.setLeft(nJ);

        BinaryTreeUtils.Printer.printClean(root);
        BinaryTreeUtils.Printer.printCompact(root);


        BinaryTreeUtils.parcoursDiagonalV2(root);
        System.out.println();
        BinaryTreeUtils.parcoursDiagonalV1(root, null);

        System.out.println();


        BinaryTreeUtils.parcoursPrefixe(root);
        System.out.println();
        BinaryTreeUtils.parcoursInfixe(root);
        System.out.println();
        BinaryTreeUtils.parcoursPostfixe(root);
        System.out.println();


        Node<String> rootAdd = new Node<>("+");
        Node<String> nDiv = new Node<>("/");
        Node<String> nMulti = new Node<>("*");
        Node<String> n8 = new Node<>("8");
        Node<String> n2 = new Node<>("2");
        Node<String> n3 = new Node<>("3");
        Node<String> n5 = new Node<>("5");
        Node<String> n22 = new Node<>("2");
        Node<String> nMinus = new Node<>("-");

        rootAdd.setLeft(nDiv);
        rootAdd.setRight(nMulti);

        nDiv.setLeft(n8);
        nDiv.setRight(n2);

        nMulti.setLeft(n3);
        nMulti.setRight(nMinus);

        nMinus.setLeft(n5);
        nMinus.setRight(n22);

        BinaryTreeUtils.Printer.printClean(rootAdd);

        BinaryTreeUtils.afficherExpression(rootAdd);
        System.out.println();
        BinaryTreeUtils.parcoursPostfixe(rootAdd);
        System.out.println();
        System.out.println(BinaryTreeUtils.evaluerExpression(rootAdd));

        BinaryTreeUtils.Printer.printClean(BinaryTreeUtils.createTreeFromRPN("8 2 / 3 5 2 - * +"));

        BinaryTreeUtils.parcoursLargeur(root);

    }
}
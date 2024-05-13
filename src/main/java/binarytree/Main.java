package binarytree;

public class Main {
    public static void main(String[] args) {

        Node<Integer> root = new Node<>(10);
        Node<Integer> n1 = new Node<>(5);
        Node<Integer> n2 = new Node<>(15);
        Node<Integer> n3 = new Node<>(5);
        Node<Integer> n4 = new Node<>(7);
        Node<Integer> n5 = new Node<>(12);
        Node<Integer> n6 = new Node<>(17);
        Node<Integer> n7 = new Node<>(20);
        Node<Integer> n8 = new Node<>(19);

        root.setLeft(n1);
        root.setRight(n2);

        n1.setLeft(n3);
        n1.setRight(n4);

        n2.setLeft(n5);
        n2.setRight(n8);

        n8.setLeft(n6);
        n8.setRight(n7);

        BinaryTreeUtils.Printer.printClean(root);
        //BinaryTreeUtils.insererABR(root, 10);
        //BinaryTreeUtils.supprimerABR(root, 10);
        System.out.println(BinarySearchTreeUtils.insertionIterativeABR(root, 8).getKey());
        BinaryTreeUtils.Printer.printClean(root);
        //BinaryTreeUtils.reverse(root);
        //BinaryTreeUtils.Printer.printClean(root);

    }
}

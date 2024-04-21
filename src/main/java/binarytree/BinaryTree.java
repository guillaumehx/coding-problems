package binarytree;

public class BinaryTree<T extends Comparable<?>> {

    private Node<T> root;

    public BinaryTree() {
    }

    public BinaryTree(Node<T> root) {
        this.root = root;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public void add() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void remove() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void find() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}

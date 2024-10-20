package binarytree;

public class Node<T extends Comparable<?>> implements BinaryTreeUtils.PrintableNode {

    private T key;
    private Node<T> left;
    private Node<T> right;
    private Integer height;

    public Node(T key) {
        this.key = key;
    }

    public Node(T key, Node<T> left, Node<T> right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public void setChildren(Node<T> left, Node<T> right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    @Override
    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    @Override
    public String getText() {
        return String.valueOf(this.key);
    }

    @Override
    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}

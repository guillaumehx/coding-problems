package linkedlist;

public class Link {

    private Integer element;
    private Link next;

    public Link(Integer element) {
        this.element = element;
    }

    public Link(Integer element, Link next) {
        this.element = element;
        this.next = next;
    }

    public Integer getElement() {
        return element;
    }

    public void setElement(Integer element) {
        this.element = element;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }
}

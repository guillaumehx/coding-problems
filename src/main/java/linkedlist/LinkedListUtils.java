package linkedlist;

public class LinkedListUtils {

    public static void insertHead(LinkedList list, int k) {
        Link link = new Link(k);
        link.setNext(list.getHead());
        list.setHead(link);
    }

    public static void deleteHead(LinkedList list) {
        Link link = list.getHead();
        if (link != null) {
            list.setHead(link.getNext());
            link.setNext(null);
        }
    }

    public static void insertFin(LinkedList list, int i) {
        Link link = dernierElement(list);
        if (link == null) {
            insertHead(list, i);
        } else {
            link.setNext(new Link(i));
        }
    }

    public static Link dernierElement(LinkedList list) {
        Link link = list.getHead();
        if (link == null) {
            return null;
        } else {
            while (link.getNext() != null) {
                link = link.getNext();
            }
            return link;
        }
    }

    public static void insertKPosition(LinkedList list, int k, int i) {
        if (k == 1) {
            insertHead(list, i);
        }

        int c = 1;
        Link p = list.getHead();
        while (c < k - 1 && p != null) {
            c = c + 1;
            p = p.getNext();
        }

        if (p == null || p.getNext() == null) {
            System.exit(1);
        }

        Link q = new Link(i);
        q.setNext(p.getNext());
        p.setNext(q);
    }

    public static void deleteKPosition(LinkedList list, int k) {
        if (k == 1) {
            deleteHead(list);
        }

        int c = 1;
        Link p = list.getHead();
        while (c < k - 1 && p != null) {
            c = c + 1;
            p = p.getNext();
        }

        if (p == null || p.getNext() == null) {
            System.exit(1);
        }

        Link q = p.getNext();
        p.setNext(q.getNext());
        q.setNext(null);
        q.setElement(null);

    }

    public static void afficherListe(LinkedList list) {
        Link link = list.getHead();
        while (link != null) {
            System.out.print(link.getElement() + " ");
            link = link.getNext();
        }
    }
}

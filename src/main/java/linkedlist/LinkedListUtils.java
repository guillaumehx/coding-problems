package linkedlist;

public class LinkedListUtils {

    public static void insertTete(LinkedList list, int i) {
        Link link = new Link(i);
        if (list.getHead() == null) {
            list.setHead(link);
        } else {
            link.setNext(list.getHead());
            list.setHead(link);
        }
    }

    public static void insertFin(LinkedList list, int i) {
        Link link = dernierElement(list);
        if (link == null) {
            insertTete(list, i);
        } else {
            link.setNext(new Link(i));
        }
    }

    public static void supprimerTete(LinkedList list) {
        Link link = list.getHead();
        if (link != null) {
            list.setHead(link.getNext());
            link.setNext(null);
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

    public static void insertKElement(LinkedList list, int k, int i) {
        if (k == 1) {
            insertTete(list, i);
        } else {
            int j = 1;
            Link l = list.getHead();
            while (l.getNext() != null && j < k-1) {
                j++;
                l = l.getNext();
            }
            Link newL = new Link(i);
            newL.setNext(l.getNext());
            l.setNext(newL);
        }
    }

    public static void afficherListe(LinkedList list) {
        Link link = list.getHead();
        while (link != null) {
            System.out.print(link.getElement() + " ");
            link = link.getNext();
        }
    }
}

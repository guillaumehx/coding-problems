package linkedlist;

public class Main {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        LinkedListUtils.insertTete(list, 2);
        LinkedListUtils.insertTete(list, 4);
        LinkedListUtils.insertTete(list, 8);
        LinkedListUtils.insertTete(list, 6);
        LinkedListUtils.insertTete(list, 5);

        LinkedListUtils.afficherListe(list);
        LinkedListUtils.insertKPosition(list, 2, 222);
        System.out.println();
        LinkedListUtils.afficherListe(list);
        LinkedListUtils.deleteKPosition(list, 2);
        System.out.println();
        LinkedListUtils.afficherListe(list);

    }

}

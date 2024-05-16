package linkedlist;

public class Main {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        LinkedListUtils.insertTete(list, 2);
        LinkedListUtils.insertFin(list, 4);
        LinkedListUtils.insertFin(list, 8);
        LinkedListUtils.insertFin(list, 10);

        LinkedListUtils.insertKElement(list, 5, 100);
        LinkedListUtils.afficherListe(list);

        System.out.println(LinkedListUtils.dernierElement(list));

    }

}

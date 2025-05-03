package Dia02;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.printList(); // 10 -> 20 -> 30 -> null

        list.delete(20);
        list.printList(); // 10 -> 30 -> null

        System.out.println(list.search(30)); // true
        System.out.println(list.search(40)); // false
    }
}

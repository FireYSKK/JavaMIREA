import java.util.Collections;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for (int i = 0; i < 9; i++) {
            linkedList.add(i);
        }

        printList(linkedList);

        linkedList.remove(2);

        printList(linkedList);

        linkedList.add(-1);
        Collections.sort(linkedList);

        printList(linkedList);

        linkedList.addFirst(-5);
        printList(linkedList);
    }

    public static <T> void printList(LinkedList<T> arrayList){
        for (int i = 0; i < arrayList.size(); i++) {
            if (i != 0) System.out.print(" -> ");
            System.out.print(arrayList.get(i));
        }
        System.out.println();
    }
}


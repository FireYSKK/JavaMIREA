package Task2;

public class Test {
    public static void fill(Queue queue) {
        for (int i = 0; i < 3; i++) {
            queue.push(i);
        }
    }

    public static void dump(Queue queue) {
        while (!queue.isEmpty()) {
            System.out.println(queue.size() + " " +
                    queue.element() + " " + queue.pop());
        }
    }

    public static void test(Queue queue) {
        fill(queue);
        dump(queue);
        System.out.println();

        dump(queue);
        System.out.println("-------");
    }

    public static void main(String[] args) {
        test(new ArrayQueue<Integer>());
        test(new LinkedQueue<Integer>());
    }
}
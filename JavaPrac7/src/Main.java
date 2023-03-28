public class Main {
    public static void main(String[] args) {
        System.out.println("Stack realisation:");
        WithStack stackSolution = new WithStack();
        stackSolution.test();

        System.out.println("Queue realisation:");
        WithQueue queueSolution = new WithQueue();
        queueSolution.test();

        System.out.println("Dequeue realisation:");
        WithDeque dequeSolution = new WithDeque();
        dequeSolution.test();
    }
}

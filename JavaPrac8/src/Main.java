public class Main {

    public static void main(String[] args) {
        BoundedWaitList<Integer> boundedWaitList = new BoundedWaitList<Integer>(3);
        boundedWaitList.add(1);
        boundedWaitList.add(2);
        boundedWaitList.add(3);
        boundedWaitList.add(0);
        if (boundedWaitList.contains(1)) System.out.println("1");;
        System.out.println(boundedWaitList);

        UnfairWaitList<Integer> unfairWaitList = new UnfairWaitList<Integer>();
        unfairWaitList.add(-1);
        unfairWaitList.add(1);
        unfairWaitList.add(2);
        unfairWaitList.add(3);
        unfairWaitList.add(4);
        unfairWaitList.moveToBack(-1);
        System.out.println(unfairWaitList);
        unfairWaitList.remove(2);
        System.out.println(unfairWaitList);
    }
}

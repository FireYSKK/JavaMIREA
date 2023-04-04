package Task1;

import java.util.Arrays;

public class ArrayQueueADT {
    private int size;
    private int[] elements = new int[0];


    public static void enqueue(ArrayQueueADT queue, int element) {
        ensureCapacity(queue, queue.size + 1);
        queue.elements[queue.size++] = element;
    }
    private static void ensureCapacity(ArrayQueueADT queue, int capacity) {
        if (capacity > queue.elements.length) {
            queue.elements = Arrays.copyOf(queue.elements, 2 * capacity);
        }
    }

    public static int element(ArrayQueueADT queue) {
        assert queue.size > 0;
        return queue.elements[0];
    }

    public static int dequeue(ArrayQueueADT queue) {
        assert queue.size > 0;
        int first = queue.elements[0];
        for(int i=1; i<queue.size; i++)
            queue.elements[i-1] = queue.elements[i];
        queue.size--;
        return first;
    }
    public static int size(ArrayQueueADT queue) {
        return queue.size;
    }

    public static boolean isEmpty(ArrayQueueADT queue) {
        return queue.size == 0;
    }

    public static void clear(ArrayQueueADT queue){
        queue.elements = new int[0];
        queue.size=0;
    }

    public static String toString1(ArrayQueueADT queue){
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append("[ ");
        for(int i=0; i<queue.size; i++){
            stringBuffer.append(queue.elements[i]).append(" ");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
package Task1;

import java.util.Arrays;

public class ArrayQueue {
    private int size;
    private int[] elements = new int[0];

    public void enqueue(int element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
    }

    private void ensureCapacity(int capacity) {
        if (capacity > elements.length) {
            elements = Arrays.copyOf(elements, 2 * capacity);
        }
    }

    public int element() {
        assert size > 0;
        return elements[0];
    }

    public int dequeue() {
        assert size > 0;
        int first = elements[0];
        for(int i=1; i<size; i++)
            elements[i-1] = elements[i];
        size--;
        return first;
    }
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear(){
        elements = new int[0];
        size=0;
    }

    public String toString1(){
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append("[ ");
        for(int i=0; i<size; i++){
            stringBuffer.append(elements[i]).append(" ");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
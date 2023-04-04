package Task2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ArrayQueue<E> extends AbstractQueue<E>{
    private ArrayList<E> elements = new ArrayList<>();

    @Override
    protected void pushImpl(E element) {
        elements.add(element);
    }

    @Override
    protected void remove() {
        elements.remove(0);
    }

    @Override
    protected E elementImpl() {
        return elements.get(0);
    }
}
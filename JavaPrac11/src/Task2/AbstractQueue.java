package Task2;

public abstract class AbstractQueue<E> implements Queue<E> {
    protected int size;

    public E element(){
        assert size>0;
        return elementImpl();
    }


    public void push(E element) {
        assert element != null;
        pushImpl(element);
        size++;
    }

    public E pop() {
        assert size > 0;
        E result = element();
        size--;
        remove();
        return result;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    protected abstract void pushImpl(E element);
    protected abstract void remove();
    protected abstract E elementImpl();
}
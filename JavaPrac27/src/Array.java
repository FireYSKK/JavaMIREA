import java.util.Arrays;

public class Array<E> {
    private E[] es;

    public Array() {
    }

    public Array(E[] es) {
        this.es = es;
    }

    public E[] getEs() {
        return es;
    }

    public void test2() {
        Array array = new Array(new Integer[]{1, 2, 3});
        System.out.println(Arrays.toString(array.getEs()));
        array = new Array(new String[]{"a", "b", "c"});
        System.out.println(Arrays.toString(array.getEs()));
    }

    public E get(int index) {
        if (index > es.length - 1 || index < 0)
            throw new ArrayIndexOutOfBoundsException("Invalid index");
        return es[index];
    }

    public void test3() {
        Array array = new Array(new Integer[]{1, 2, 3});
        System.out.println(array.get(1));
        System.out.println(array.get(2));
    }
}
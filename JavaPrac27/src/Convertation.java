import java.util.Arrays;
import java.util.List;

public class Convertation {

    public <E> List<E> convert(E[] array) {
        return Arrays.asList(array);
    }

    public void test() {
        Integer[] integers = new Integer[]{1, 2, 3};
        String[] strings = new String[]{"a", "b", "c"};

        System.out.println(convert(integers));
        System.out.println(convert(strings));
    }
}
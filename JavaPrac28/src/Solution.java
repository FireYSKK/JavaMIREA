import java.util.*;

public class Solution {
    public <T> ArrayList<T> newArrayList(T[] array) {
        return new ArrayList<T>(Arrays.asList(array));
    }

    public <T> HashSet<T> newHashSet(T[] array) {
        HashSet<T> hashSet = new HashSet<>();
        Collections.addAll(hashSet, array);
        return hashSet;
    }

    public <K, V> HashMap<K, V> newHashMap(K[] keys, V[] values) throws IllegalArgumentException {
        if (keys.length != values.length) throw new IllegalArgumentException();
        HashMap<K, V> hashMap = new HashMap<>();

        for (int i = 0; i < keys.length; i++)
            hashMap.put(keys[i], values[i]);

        return hashMap;
    }

    public void test() {
        Integer a[] = new Integer[] {1, 2, 3};
        String b[] = new String[] {"a", "b", "c"};

        ArrayList<Integer> integers = newArrayList(a);
        System.out.println(integers.toString());

        HashSet<Integer> integerHashSet = newHashSet(a);
        System.out.println(integerHashSet);

        HashMap<Integer, String> hashMap = null;
        try {
            hashMap = newHashMap(a, b);
        } catch (IllegalArgumentException e) {
            System.out.println("Illegal arguments");
        }

        System.out.println(hashMap);
    }


}
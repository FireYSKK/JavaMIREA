package orders;

import items.Item;

public interface Order {
    boolean add(Item item);
    void remove(Item item);
    boolean remove(String name);
    Item[] getArray();
    int totalCost();
}
package orders;

import items.Item;

import java.util.Objects;

public class RestaurantOrder implements Order{
    private Item[] items;
    private int capacity = 5;
    private int size = 0;

    public RestaurantOrder(){
        items = new Item[capacity];
    }

    public RestaurantOrder(int capacity) {
        this.capacity = capacity;
        items = new Item[capacity];
    }

    @Override
    public boolean add(Item item){
        if (size > capacity - 1){
            capacity *= 2;
            Item[] newItems = new Item[capacity];
            System.arraycopy(items, 0, newItems, 0, size);
            items = newItems;
        }
        items[size] = item;
        size+=1;
        return true;
    }

    @Override
    public void remove(Item item) {
        for (int i = 0; i < size - 1; i++)
            if (items[i] == item) {
                for (int j = i; j < size - 1; j++) {
                    items[j] = items[j + 1];
                }
                size -= 1;
            }
        if (items[size - 1] == item) {
            {
                items[size - 1] = null;
                size -= 1;
            }
        }
    }

    @Override
    public boolean remove(String name) {
        for (int i = 0; i < size - 1; i++)
            if (Objects.equals(items[i].getTitle(), name)) {
                for (int j = i; j < size - 1; j++) {
                    items[j] = items[j + 1];
                }
                size -= 1;
                return true;
            }
        if (Objects.equals(items[size - 1].getTitle(), name)) {
            items[size - 1] = null;
            size -= 1;
            return true;
        }
        return false;
    }

    @Override
    public Item[] getArray() {
        Item[] itemArray = new Item[size];
        System.arraycopy(items, 0, itemArray, 0, size);
        return itemArray;
    }

    @Override
    public int totalCost() {
        int total = 0;
        for (Item item : items) {
            if (item != null) total += item.getPrice();
        }
        return total;
    }
}
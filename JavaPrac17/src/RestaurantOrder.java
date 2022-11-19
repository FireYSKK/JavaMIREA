import java.util.ArrayList;
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
    public boolean remove(String name) {
        for (int i = 0; i < size - 2; i++)
            if (Objects.equals(items[i].getTitle(), name)) {
                for (int j = i; j < size - 2; j++) {
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
    public int removeAll(String name) {
        int count = 0;
        for (int i = 0; i < size - 1; i++) {
            if (Objects.equals(items[i].getTitle(), name)) {
                remove(name);
                i--;
                size--;
                count++;
            }
        }
        return count;
    }

    @Override
    public int totalCount() {
        return size;
    }

    @Override
    public Item[] getArray() {
        return items;
    }

    @Override
    public int totalCost() {
        int total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public int numberOf(String name) {
        int count = 0;
        for (Item item : items) {
            if (Objects.equals(item.getTitle(), name)) count++;
        }
        return count;
    }

    @Override
    public Item[] getUniqueArray() {
        ArrayList<Item> itemList = new ArrayList<>();
        for (Item item: items) {
            if (!itemList.contains(item)) itemList.add(item);
        }
        return (Item[]) itemList.toArray();
    }

    @Override
    public Item[] SortedDishesByCostDesc() {
        Item[] itemArray = getArray();
        for (int i = 0; i < itemArray.length - 1; i++) {
            for (int j = 0; j < itemArray.length - 1; j++) {
                if (((Dish) itemArray[j]).getPrice() > ((Dish) itemArray[j + 1]).getPrice()) {
                    Item temp = itemArray[j];
                    itemArray[j] = itemArray[j + 1];
                    itemArray[j + 1] = temp;
                }
            }
        }
        return itemArray;
    }
}
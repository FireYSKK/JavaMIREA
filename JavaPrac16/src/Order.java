public class Order {
    private Item[] items;
    private int capacity;
    private int size = 0;

    public Order(int capacity) {
        this.capacity = capacity;
        items = new Item[capacity];
    }

    public Item getItem(int index){
        try {
            return items[index];
        }catch (IndexOutOfBoundsException e) {
            System.out.println("Out of bounds");
        }
        return null;
    }

    public void addItem(Item item){
        if (size == capacity - 1){
            capacity *= 2;
            copy(capacity);
        }
        items[size] = item;
        size+=1;
    }

    public int size(){
        return size;
    }

    private void copy(int newCapacity){
        Item[] newItems = new Item[newCapacity];
        if (size >= 0) System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }

    public void remove(Item item) {
        for (int i = 0; i < size; i++)
            if (items[i] == item)
                for (int j = i; j < size; j++)
                    items[j] = items[j - 1];

        size -= 1;
    }
}
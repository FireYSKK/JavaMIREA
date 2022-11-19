public class TablesOrderManager {
    private Order[] orders;
    private int capacity;
    private int size = 0;

    public TablesOrderManager(int capacity) {
        this.capacity = capacity;
        orders = new Order[capacity];
    }

    public void addOrder(Order order){
        if (size == capacity - 1){
            capacity *= 2;
            copy(capacity);
        }
        orders[size] = order;
        size+=1;
    }

    public Order getOrder(int index) {
        try {
            return orders[index];
        }catch (IndexOutOfBoundsException e) {
            System.out.println("Out of bounds");
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    private void copy(int newCapacity){
        Order[] newOrders = new Order[newCapacity];
        if (size >= 0) System.arraycopy(orders, 0, newOrders, 0, size);
        orders = newOrders;
    }

    public void remove(Order order) {
        for (int i = 0; i < size; i++)
            if (orders[i] == order)
                for (int j = i; j < size; j++)
                    orders[j] = orders[j - 1];

        size -= 1;
    }
}
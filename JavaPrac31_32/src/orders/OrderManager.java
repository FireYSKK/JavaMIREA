package orders;

import items.Item;

import java.util.HashMap;

public class OrderManager {
    private Order[] orders;
    private int capacity = 10;
    private int size = 0;
    private final HashMap<String , Order> hashMap = new HashMap<>();

    public OrderManager() {
        orders = new Order[capacity];
    }

    public OrderManager(int capacity) {
        this.capacity = capacity;
        orders = new Order[capacity];
    }

    // Добавление заказа
    public void add(Order order){
        if (size == capacity - 1){
            capacity *= 2;
            Order[] newOrders = new Order[capacity];
            System.arraycopy(orders, 0, newOrders, 0, size);
            orders = newOrders;
        }
        orders[size] = order;
        size+=1;
    }

    // Добавление заказа в хеш-таблицу
    public void add(String address, Order order) throws Exception {
        if (hashMap.containsKey(address)){
            throw new Exception("OrderAlreadyAddedException");
        }
        this.add(order);
        hashMap.put(address, order);
    }

    // Полученние заказа из хеш-таблицы
    public Order get(String address) {
        return hashMap.get(address);
    }

    // Добавление блюда к заказу по адресу
    public void addToOrder(String address, Item item) {
        hashMap.get(address).add(item);
    }

    // Добавление блюда к заказу по адресу
    public void removeFromOrder(String address, Item item) {
        hashMap.get(address).remove(item);
    }
}
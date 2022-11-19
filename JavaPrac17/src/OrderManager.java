import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class OrderManager {
    private Order[] orders;
    private int capacity;
    private int size = 0;
    private final HashMap<String , Order> hashMap = new HashMap<>();

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
    public boolean add(String address, Order order) throws Exception {
        if (hashMap.containsKey(address)){
            throw new Exception("OrderAlreadyAddedException");
        }
        this.add(order);
        hashMap.put(address, order);
        return true;
    }

    // Полученние заказа
    public Order get(int index) {
        if (size > 0){
            return orders[index];
        }
        return null;
    }

    // Полученние заказа из хеш-таблицы
    public Order get(String address) {
        return hashMap.get(address);
    }

    public int getSize() {
        return size;
    }

    // Удаление элемента
    public void remove(Order order) {
        for (int i = 0; i < size; i++)
            if (orders[i] == order)
                for (int j = i; j < size; j++)
                    orders[j] = orders[j - 1];

        size -= 1;
    }

    // Удаление элемента из хеш-таблицы
    public boolean removeHash(String address) {
        remove(hashMap.get(address));
        hashMap.remove(address);
        return true;
    }

    // Добавление блюда к заказу
    public boolean addToOrder(Order order, Item item) {
        order.add(item);
        return true;
    }

    // Добавление блюда к заказу по адресу
    public boolean addToOrder(String address, Item item) {
        hashMap.get(address).add(item);
        return true;
    }

    // Массив имеющихся на данный момент интернет-заказов
    public InternetOrder[] getInternetOrders() {
        ArrayList<InternetOrder> orderList = new ArrayList<>();
        for (Order order : hashMap.values()) {
            if (order instanceof InternetOrder){
                orderList.add((InternetOrder) order);
            }
        }
        return (InternetOrder[]) orderList.toArray();
    }

    // Общая сумма имеющихся на данный момент интернет-заказов
    public int InternetOrdersTotalCost() {
        int total = 0;
        InternetOrder[] orders = getInternetOrders();
        for (InternetOrder order : orders) {
            total += order.totalCost();
        }
        return total;
    }

    // Общее количество заказов блюда
    public int getItemCount(String itemName) {
        int count = 0;

        for (Order order : orders){
            Item[] orderItems = order.getArray();
            for (Item item : orderItems){
                if (item instanceof Dish && Objects.equals(((Dish) item).getTitle(), itemName)){
                    count += 1;
                }
                else if (item instanceof Drink && Objects.equals(((Drink) item).getTitle(), itemName)) {
                    count += 1;
                }
            }
        }

        return count;
    }

}
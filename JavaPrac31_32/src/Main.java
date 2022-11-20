import orders.OrderManager;
import tables.TableManager;

public class Main {
    public static void main(String[] args) throws Exception {
        OrderManager orderManager = new OrderManager();
        TableManager tableManager = new TableManager();
        new UI(orderManager, tableManager);
    }
}
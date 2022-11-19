import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        OrderManager orderManager = new OrderManager(10);
        TableManager tableManager = new TableManager();

        for (int i = 1; i < 4; i++){
            tableManager.add(new Table("Table " + i));
        }

        RestaurantOrder restaurantOrder = new RestaurantOrder(1);
        restaurantOrder.add(new Drink("Water", "Don't get thirsty while your order is being cooked"));
        restaurantOrder.add(new Dish("Salad", "Nothing special"));
        orderManager.add("Table 2", restaurantOrder);

        Item[] firstOrder = orderManager.get("Table 2").getArray();
        for (Item item : firstOrder){
            System.out.println(item.getTitle());
        }

        System.out.println("--------------");

        Item[] secondOrderItems = {new Dish("Lasagna", "For Garfield", 700), new Drink("Red Wine", "Not that old", 3000)};
        orderManager.add("Somewhere", new InternetOrder(secondOrderItems));

        Item[] secondOrder = orderManager.get("Somewhere").getArray();
        for (Item item : secondOrder){
            System.out.println(item.getTitle());
        }

        System.out.println("--------------");

        try{
            orderManager.add("Somewhere", new InternetOrder());
        }
        catch (Exception e) {
            System.out.println("DDOS with orders! Caught OrderAlreadyAddedException");
        }

        System.out.println("--------------");

        try{
            tableManager.makeOrder("Table 5", new RestaurantOrder());
        }
        catch (Exception e){
            System.out.println("No such table! Caught IllegalTableNumber exception");
        }
    }
}
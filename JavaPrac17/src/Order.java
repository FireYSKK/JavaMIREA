public interface Order {
    boolean add(Item item);
    boolean remove(String name);
    int removeAll(String name);
    int totalCount();
    Item[] getArray();
    int totalCost();
    int numberOf(String name);
    Item[] getUniqueArray();
    Item[] SortedDishesByCostDesc();
}
import java.util.ArrayList;
import java.util.Objects;

public class InternetOrder<Item> {

    InternetOrder() {}

    InternetOrder(Item[] items) {
        for (Item item : items) {
            add(item);
        }
    }

    // Узел списка
    private class Node {
        private Node next;
        private Node prev;
        private final Item value;

        Node(Node next, Node prev, Item value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }

        Node(Item value) {
            this(null, null, value);
        }
    }

    private Node first;
    private int size;

    // Добавление узла
    public boolean add(Item item) {
        if (first == null) {
            first = new Node(item);
            first.prev = first.next = first;
        }
        else {
            Node node = new Node(first, first.prev, item);
            first.prev.next = first.prev = node;
        }
        size++;
        return true;
    }

    // Проверка на пустоту
    private boolean isEmpty() {
        return this.size == 0;
    }

    // Изъятие первого элемента
    private Item removeFirst() {
        Item oldElement = this.first.value;
        if (this.size > 1) {
            Node newFirst = this.first.next;
            newFirst.prev = this.first.prev;
            this.first.prev.next = newFirst;
            this.first = newFirst;
            this.size--;
        }
        return oldElement;
    }

    // Изъятие последнего элемента
    private Item removeLast() {
        Item oldElement = this.first.prev.value;
        if (this.size > 1) {
            this.first.prev = first.prev.prev;
            this.first.prev.next = this.first;
            this.size--;
        }
        return oldElement;
    }

    // Удаление элемента списка
    public boolean remove(String name) {
        boolean result = false;
        if (!isEmpty()) {
            if ( Objects.equals(((Dish) this.first.value).getTitle(), name) ||
                    Objects.equals(((Drink) this.first.value).getTitle(), name) ) {
                removeFirst();
                result = true;
            }
            else {
                Node delete = null;
                for (Node node = this.first.next; node != this.first; node = node.next) {
                    if ( Objects.equals(((Dish) node.value).getTitle(), name) ||
                            Objects.equals(((Drink) node.value).getTitle(), name) ) {
                        delete = node;
                    }
                }
                if (delete != null) {
                    if (delete == this.first.prev) {
                        removeLast();
                        result = true;
                    } else {
                        delete.prev.next = delete.next;
                        delete.next.prev = delete.prev;
                        this.size--;
                        result = true;
                    }
                }
            }
        }
        return result;
    }

    // Проверка на наличие в списке
    private boolean contains(String name) {
        return indexOf(name) != -1;
    }

    // Полученеи индекса в списке
    private int indexOf(String name) {
        int index = -1;
        if (!isEmpty()) {
            if ( Objects.equals(((Dish) this.first.value).getTitle(), name) ||
                    Objects.equals(((Drink) this.first.value).getTitle(), name) ) {
                index = 0;
            } else {
                int count = 1;
                for (Node node = this.first.next; node != this.first; node = node.next) {
                    if ( Objects.equals(((Dish) node.value).getTitle(), name) ||
                            Objects.equals(((Drink) node.value).getTitle(), name) ) {
                        index = count;
                        break;
                    } else {
                        count++;
                    }
                }
            }
        }
        return index;
    }

    // Удаление всех элементов с переданным именем
    public int removeAll(String name) {
        Dish dish = new Dish(name, "");
        int count = 0;
        while (indexOf(name) != -1) {
            count++;
            remove(name);
        }
        return count;
    }

    // Общее число позиций заказа
    public int totalCount() {
        int count = 0;
        for (Node node = this.first.next; node != this.first; node = node.next) {
            count++;
        }
        return count;
    }

    // Общая стоимость заказа
    public int totalCost() {
        int cost = 0;
        for (Node node = this.first.next; node != this.first; node = node.next) {
            cost += ((Dish) node.value).getPrice();
        }
        return cost;
    }

    // Преобразовать список в массив
    public Item[] getArray() {
        ArrayList<Item> itemList = new ArrayList<>();
        for (Node node = this.first.next; node != this.first; node = node.next) {
            itemList.add(node.value);
        }
        return (Item[]) itemList.toArray();
    }

    // Количество элементов списка с указанным именем
    public int numberOf(String name) {
        int count = 0;
        ArrayList<Item> arrayList = new ArrayList<>();
        for (Node node = this.first.next; node != this.first; node = node.next) {
            if (Objects.equals(((Dish) node.value).getTitle(), name)) count++;
        }
        return count;
    }

    // Массив из уникальных элементов списка
    public Item[] getUniqueArray() {
        ArrayList<Item> itemList = new ArrayList<>();
        for (Node node = this.first.next; node != this.first; node = node.next) {
            if (!itemList.contains(node.value)) itemList.add(node.value);
        }
        return (Item[]) itemList.toArray();
    }

    // Массив элементов списка, отсортированных по убыванию цены
    public Item[] SortedDishesByCostDesc() {
        Item[] items = getArray();
        for (int i = 0; i < items.length - 1; i++) {
            for (int j = 0; j < items.length - 1; j++) {
                if (((Dish) items[j]).getPrice() > ((Dish) items[j + 1]).getPrice()) {
                    Item temp = items[j];
                    items[j] = items[j + 1];
                    items[j + 1] = temp;
                }
            }
        }
        return items;
    }
}
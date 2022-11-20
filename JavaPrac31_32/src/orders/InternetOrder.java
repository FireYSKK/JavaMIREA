package orders;

import items.Dish;
import items.Drink;
import items.Item;

import java.util.Objects;

public class InternetOrder implements Order{

    public InternetOrder() {}

    public InternetOrder(Item[] items) {
        for (Item item : items) {
            add(item);
        }
    }

    // Узел списка
    private static class Node {
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
    @Override
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
    private void removeFirst() {
        Item oldElement = this.first.value;
        if (this.size > 1) {
            Node newFirst = this.first.next;
            newFirst.prev = this.first.prev;
            this.first.prev.next = newFirst;
            this.first = newFirst;
            this.size--;
        }
    }

    // Изъятие последнего элемента
    private void removeLast() {
        Item oldElement = this.first.prev.value;
        if (this.size > 1) {
            this.first.prev = first.prev.prev;
            this.first.prev.next = this.first;
            this.size--;
        }
    }

    // Удаление элемента списка
    @Override
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

    @Override
    public void remove(Item item) {
        if (!isEmpty()) {
            if ( this.first.value == item ) {
                removeFirst();
            }
            else {
                Node delete = null;
                for (Node node = this.first.next; node != this.first; node = node.next) {
                    if ( node.value == item) {
                        delete = node;
                    }
                }
                if (delete != null) {
                    if (delete == this.first.prev) {
                        removeLast();
                    } else {
                        delete.prev.next = delete.next;
                        delete.next.prev = delete.prev;
                        this.size--;
                    }
                }
            }
        }
    }

    // Общая стоимость заказа
    @Override
    public int totalCost() {
        int cost = 0;
        for (Node node = this.first.next; node != this.first; node = node.next) {
            cost += ((Dish) node.value).getPrice();
        }
        return cost;
    }

    // Преобразовать список в массив
    @Override
    public Item[] getArray() {
        int i = 1, size = 10;
        Item[] itemList = new Item[size];
        itemList[0] = this.first.value;
        for (Node node = this.first.next; node != this.first; node = node.next) {
            if (i >= size){
                size += 10;
                Item[] newItemList = new Item[size];
                System.arraycopy(itemList, 0, newItemList, 0, i);
                itemList = newItemList;
            }
            itemList[i] = node.value;
            i++;
        }
        if (i < size){
            Item[] newItemList = new Item[i];
            System.arraycopy(itemList, 0, newItemList, 0, i);
            itemList = newItemList;
        }
        return itemList;
    }
}
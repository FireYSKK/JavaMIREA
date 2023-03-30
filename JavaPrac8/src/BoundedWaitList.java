public class BoundedWaitList<E> extends WaitList<E>{
    private final int capacity;

    /**
     * @param capacity Максимальный размер очереди
     */
    public BoundedWaitList(int capacity) {
        this.capacity = capacity;
    }

    /**
     * @return Возвращает максимальный размер очереди
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param element Добавляемый в очередь элемент
     */
    @Override
    public void add(E element) {
        if (concurrentLinkedQueue.size() < capacity)
            concurrentLinkedQueue.add(element);
    }

    /**
     * @return Элементы очереди в виде строки
     */
    public String toString() {
        return concurrentLinkedQueue.toString();
    }
}

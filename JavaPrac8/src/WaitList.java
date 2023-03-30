import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

public class WaitList<E> implements IWaitList<E>{

    protected ConcurrentLinkedQueue<E> concurrentLinkedQueue = new ConcurrentLinkedQueue<E>();

    /**
     * @param element Добавляемый в очередь элемент
     */
    @Override
    public void add(E element) {
        concurrentLinkedQueue.add(element);
    }

    @Override
    public E remove() {
        return null;
    }

    /**
     * @param element Ключевое значение
     * @return bool - Признак наличия в очереди
     */
    @Override
    public boolean contains(E element) {
        return concurrentLinkedQueue.contains(element);
    }

    /**
     * @param c Коллекция значений
     * @return bool - Признак вхождения всех элементов коллекции в очередь
     */
    @Override
    public boolean containsAll(Collection<E> c) {
        return concurrentLinkedQueue.containsAll(c);
    }

    /**
     * @return bool - Признак пустоты очереди
     */
    @Override
    public boolean isEmpty() {
        return concurrentLinkedQueue.isEmpty();
    }

    public WaitList(){};

    public WaitList(Collection<E> c){
        this.concurrentLinkedQueue.addAll(c);
    };

    /**
     * @return Элементы очереди в виде строки
     */
    public String toString() {return concurrentLinkedQueue.toString();};
}
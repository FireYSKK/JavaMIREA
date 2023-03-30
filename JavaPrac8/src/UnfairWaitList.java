public class UnfairWaitList<E> extends WaitList<E> {
    public UnfairWaitList() {
    }

    /**
     * @param element Удаляет переданный элемент
     */
    public void remove(E element) {
        concurrentLinkedQueue.remove(element);
    }

    /**
     * @param element Ставит переданный элемент в конец очереди
     */
    public void moveToBack(E element) {
        if (concurrentLinkedQueue.contains(element)){
            concurrentLinkedQueue.remove(element);
            concurrentLinkedQueue.add(element);
        }
    }
}

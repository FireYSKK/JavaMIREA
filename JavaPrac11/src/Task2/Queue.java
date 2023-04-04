package Task2;

public interface Queue<E> {
    E element();        //Возвращает первый элемент очереди
    void push(E elem);  //Добавляет элемент в конец очереди
    E pop();            //Возвращает первый элемент с удалением
    int size();         //Размер очереди
    boolean isEmpty();  //Проверка на пустоту
}
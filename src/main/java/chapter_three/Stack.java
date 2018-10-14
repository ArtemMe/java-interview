package chapter_three;

/**
 * Основыне операции стека
 * */
public interface Stack<T>{
    T pop(); // достать элемент из стэка
    void push(T item); // положить элемент в стэк
    T peek();  // вернуть элемент находящийся на вершине стека
    boolean isEmpty(); // проверить что стек пустой
}
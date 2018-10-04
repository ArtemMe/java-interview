package chapter_three;

import java.util.EmptyStackException;
/**
 * Основыне операции стека
 * */
interface Stack<T>{
   T pop(); // достать элемент из стэка
   void push(T item); // положить элемент в стэк
   T peek();  // вернуть элемент находящийся на вершине стека
   boolean isEmpty(); // проверить что стек пустой
}

public class MyStack<T> implements Stack<T> {

    private StackNode<T> top;

    @Override
    public T pop() {
        if(top == null) throw new EmptyStackException();
        StackNode<T> oldTop = top;
        top = top.next;
        return oldTop.data;
    }

    @Override
    public void push(T item) {
        StackNode<T> newItem = new StackNode<>(item);
        newItem.next = top;
        top = newItem;
    }

    @Override
    public T peek() {
        if(top == null) throw new EmptyStackException();
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    private static class StackNode<T>{
        T data;
        StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }


}

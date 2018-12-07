package chapter_three;

import java.lang.reflect.Array;
import java.util.EmptyStackException;

/**
 * 3.1 Опишите, как бы вы использовали один одномерный массив для реализации трех стеков.
 *
 * */

public class FixedMultiStack<T> {
    private T stack[];
    private int numberOfStack = 3;
    private int sizes[];
    private int stackCapacity;

    public FixedMultiStack(Class<T> c, int stackSize){
        stackCapacity = stackSize;
        final T[] stack = (T[]) Array.newInstance(c, stackCapacity*numberOfStack);
        this.stack = stack;
        sizes = new int[numberOfStack];
    }

    public T pop(int stackNum) {
        if(this.sizes[stackNum] == 0)
            return (T) new EmptyStackException();

        int sizeOfStack = sizes[stackNum];
        int offset = stackNum*stackCapacity;

        T value = stack[offset+sizeOfStack-1];

        sizes[stackNum] = --sizeOfStack;

        return value;
    }

    public void push(T item, int stackNum) {
        int sizeOfStack = sizes[stackNum];
        sizeOfStack++;
        int offset = stackNum*stackCapacity;
        stack[offset+sizeOfStack-1] = item;
        sizes[stackNum] = sizeOfStack;
    }

    public T peek(int stackNum) {
        int sizeOfStack = sizes[stackNum];
        int offset = stackNum*stackCapacity;

        T value = stack[offset+sizeOfStack-1];
        return value;
    }

    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }
}

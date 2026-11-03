package dev.bosse.datastructures.stack;

public interface StackInterface<T>{
    void push(T element);

    T pop();

    T peek();

    int size();

    boolean isEmpty();

    boolean isFull();
}

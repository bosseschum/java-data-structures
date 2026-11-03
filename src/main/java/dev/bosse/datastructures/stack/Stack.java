package dev.bosse.datastructures.stack;

/**
 * Represents a stack data structure.
 * @param <T> The type of elements stored in the stack.
 */
public class Stack<T> implements StackInterface<T> {
    private final int maxSize;
    private final T[] stackArray;
    private int top;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = (T[]) new Object[maxSize];
        this.top = -1;
    }

    /**
     * Pushes an item onto the stack.
     * Throws an IllegalStateException if the stack is full.
     * @param item The item to be pushed onto the stack.
     */
    public void push(T item) {
        if (top < maxSize - 1) {
            stackArray[++top] = item;
        }
    }

    /**
     * Removes and returns the top item from the stack.
     * Throws an IllegalStateException if the stack is empty.
     * @return The top item from the stack.
     */
    public T pop() {
        if (top >= 0) {
            return stackArray[top--];
        }
        return null;
    }

    /**
     * Returns the top item from the stack without removing it.
     * Throws an IllegalStateException if the stack is empty.
     * @return The top item from the stack.
     */
    public T peek() {
        if (top >= 0) {
            return stackArray[top];
        }
        return null;
    }

    /**
     * Returns the number of items currently in the stack.
     * @return The number of items in the stack.
     */
    public int size() {
        return top + 1;
    }

    /**
     * Checks if the stack is empty.
     * @return True if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Checks if the stack is full.
     * @return True if the stack is full, false otherwise.
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }
}

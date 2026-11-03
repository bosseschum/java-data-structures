package dev.bosse.datastructures.queue;

/**
 * Queue implementation using an array.
 */
public class Queue<Integer>{
    private final int[] elements;
    private int size;
    private final int capacity;
    private int front;
    private int rear;

    public Queue(int capacity) {
        this.elements = new int[capacity];
        this.size = 0;
        this.capacity = capacity;
        this.front = 0;
        this.rear = -1;
    }

    /**
     * Returns the number of elements in the queue.
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Returns true if the queue is full, false otherwise.
     */
    public boolean isFull() {
        return this.size == this.capacity;
    }

    /**
     * Returns the element at the front of the queue without removing it.
     * Throws an IllegalStateException if the queue is empty.
     * @return The element at the front of the queue.
     */
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return this.elements[this.front];
    }

    /**
     * Adds an element to the rear of the queue.
     * Throws an IllegalStateException if the queue is full.
     * @param element The element to be added to the queue.
     */
    public void enqueue(int element) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        this.rear = (this.rear + 1) % this.capacity;
        this.elements[this.rear] = element;
        this.size++;
    }

    /**
     * Removes and returns the element at the front of the queue.
     * Throws an IllegalStateException if the queue is empty.
     * @return The element at the front of the queue.
     */
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int element = this.elements[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size--;
        return element;
    }
}

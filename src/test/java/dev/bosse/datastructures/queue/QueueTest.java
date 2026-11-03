package dev.bosse.datastructures.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

    @Test
    void enqueueAndDequeueFollowFifoOrder() {
        Queue<Integer> queue = new Queue<>(8);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        assertEquals(10, queue.dequeue());
        assertEquals(20, queue.dequeue());
        assertEquals(30, queue.dequeue());
    }

    @Test
    void peekShouldNotRemoveElement() {
        Queue<Integer> queue = new Queue<>(8);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        assertEquals(10, queue.peek());
        assertEquals(3, queue.size());
    }

    @Test
    void emptyQueueShouldBeEmpty() {
        Queue<Integer> queue = new Queue<>(8);

        assertTrue(queue.isEmpty());
    }
}

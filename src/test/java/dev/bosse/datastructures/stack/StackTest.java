
package dev.bosse.datastructures.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void pushAndPopShouldFollowLifoOrder() {
        Stack<Integer> stack = new Stack<>(8);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(30, stack.pop());
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
    }

    @Test
    void peekShouldNotRemoveElement() {
        Stack<Integer> stack = new Stack<>(8);

        stack.push(42);

        assertEquals(42, stack.peek());
        assertEquals(1, stack.size());
    }

    @Test
    void emptyStackShouldBeEmpty() {
        Stack<Integer> stack = new Stack<>(8);

        assertTrue(stack.isEmpty());
    }
}

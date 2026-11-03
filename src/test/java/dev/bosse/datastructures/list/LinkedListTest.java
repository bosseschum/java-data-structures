package dev.bosse.datastructures.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    private LinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
    }

    @Test
    void testInitialListIsEmpty() {
        assertNull(list.getHead());
    }

    @Test
    void testInsertSingleElement() {
        list.insert(10);
        Node head = list.getHead();
        assertNotNull(head);
        assertEquals(10, head.getValue());
        assertNull(head.getNext());
    }

    @Test
    void testInsertMultipleElements() {
        list.insert(10);
        list.insert(20);
        list.insert(30);

        Node first = list.getHead();
        assertNotNull(first);
        assertEquals(10, first.getValue());

        Node second = first.getNext();
        assertNotNull(second);
        assertEquals(20, second.getValue());

        Node third = second.getNext();
        assertNotNull(third);
        assertEquals(30, third.getValue());
        assertNull(third.getNext());
    }

    @Test
    void testInsertAfter() {
        list.insert(10);
        list.insert(30);

        Node head = list.getHead();
        Node newNode = new Node(20);
        list.insertAfter(newNode, head);

        assertEquals(10, head.getValue());
        assertEquals(20, head.getNext().getValue());
        assertEquals(30, head.getNext().getNext().getValue());
        assertNull(head.getNext().getNext().getNext());
    }

    @Test
    void testInsertAfterAtTail() {
        list.insert(10);
        Node head = list.getHead();
        Node newNode = new Node(20);
        list.insertAfter(newNode, head);

        assertEquals(20, head.getNext().getValue());
        assertNull(head.getNext().getNext());
    }

    @Test
    void testInsertAfterWithNull() {
        list.insert(10);
        Node head = list.getHead();

        list.insertAfter(null, head);
        assertNull(head.getNext());

        Node newNode = new Node(20);
        list.insertAfter(newNode, null);
        assertNull(head.getNext());
    }

    @Test
    void testInsertBeforeHead() {
        list.insert(20);
        list.insert(30);

        Node head = list.getHead();
        Node newNode = new Node(10);
        list.insertBefore(newNode, head);

        assertEquals(10, list.getHead().getValue());
        assertEquals(20, list.getHead().getNext().getValue());
        assertEquals(30, list.getHead().getNext().getNext().getValue());
    }

    @Test
    void testInsertBeforeMiddle() {
        list.insert(10);
        list.insert(30);

        Node head = list.getHead();
        Node second = head.getNext();
        Node newNode = new Node(20);
        list.insertBefore(newNode, second);

        assertEquals(10, list.getHead().getValue());
        assertEquals(20, list.getHead().getNext().getValue());
        assertEquals(30, list.getHead().getNext().getNext().getValue());
    }

    @Test
    void testInsertBeforeWithNull() {
        list.insert(10);
        Node head = list.getHead();

        list.insertBefore(null, head);
        assertEquals(head, list.getHead());
        assertNull(head.getNext());

        Node newNode = new Node(5);
        list.insertBefore(newNode, null);
        assertEquals(head, list.getHead());
    }

    @Test
    void testInsertAtEndEmptyList() {
        Node newNode = new Node(10);
        list.insertAtEnd(newNode);

        assertEquals(newNode, list.getHead());
        assertEquals(10, list.getHead().getValue());
        assertNull(list.getHead().getNext());
    }

    @Test
    void testInsertAtEndNonEmptyList() {
        list.insert(10);
        list.insert(20);

        Node newNode = new Node(30);
        list.insertAtEnd(newNode);

        Node first = list.getHead();
        assertEquals(10, first.getValue());
        assertEquals(20, first.getNext().getValue());
        assertEquals(30, first.getNext().getNext().getValue());
        assertNull(first.getNext().getNext().getNext());
    }

    @Test
    void testInsertAtEndWithNull() {
        list.insert(10);
        list.insertAtEnd(null);

        assertEquals(10, list.getHead().getValue());
        assertNull(list.getHead().getNext());
    }

    @Test
    void testRemoveHead() {
        list.insert(10);
        list.insert(20);

        Node head = list.getHead();
        list.remove(head);

        assertNotNull(list.getHead());
        assertEquals(20, list.getHead().getValue());
        assertNull(list.getHead().getNext());
    }

    @Test
    void testRemoveOnlyElement() {
        list.insert(10);
        Node head = list.getHead();
        list.remove(head);

        assertNull(list.getHead());
    }

    @Test
    void testRemoveMiddleElement() {
        list.insert(10);
        list.insert(20);
        list.insert(30);

        Node middle = list.getHead().getNext();
        list.remove(middle);

        Node first = list.getHead();
        assertEquals(10, first.getValue());
        assertEquals(30, first.getNext().getValue());
        assertNull(first.getNext().getNext());
    }

    @Test
    void testRemoveLastElement() {
        list.insert(10);
        list.insert(20);

        Node last = list.getHead().getNext();
        list.remove(last);

        Node first = list.getHead();
        assertEquals(10, first.getValue());
        assertNull(first.getNext());
    }

    @Test
    void testRemoveNullOrEmpty() {
        list.remove(null);
        assertNull(list.getHead());

        list.remove(new Node(10));
        assertNull(list.getHead());

        list.insert(10);
        list.remove(null);
        assertEquals(10, list.getHead().getValue());
    }
}

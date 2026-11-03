package dev.bosse.datastructures.list;

/**
 * Represents a singly linked list.
 */
public class LinkedList<T>{

    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public Node getHead() {
        return head;
    }

    /**
     * Inserts a new node with the given value at the end of the list.
     * @param value The value to be inserted.
     */
    public void insert(T value) {
        if (head == null) {
            head = new Node(value);
            return;
        }
        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(new Node(value));
    }

    /**
     * Inserts a new node after the specified node in the list.
     * @param newNode The new node to be inserted.
     * @param node The node after which the new node is inserted.
     */
    public void insertAfter(Node newNode, Node node) {
        if (newNode == null || node == null) {
            return;
        }
        newNode.setNext(node.getNext());
        node.setNext(newNode);
    }

    /**
     * Inserts a new node before the specified node in the list.
     * @param newNode The new node to be inserted.
     * @param node The node before which the new node is inserted.
     */
    public void insertBefore(Node newNode, Node node) {
        if (newNode == null || node == null) {
            return;
        }
        if (node == head) {
            newNode.setNext(head);
            head = newNode;
            return;
        }
        Node previous = head;
        while (previous != null && previous.getNext() != node) {
            previous = previous.getNext();
        }
        if (previous != null) {
            newNode.setNext(node);
            previous.setNext(newNode);
        }
    }

    /**
     * Inserts a new node at the end of the list.
     * @param newNode The new node to be inserted.
     */
    public void insertAtEnd(Node newNode) {
        if (newNode == null) {
            return;
        }
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
    }

    /**
     * Removes the specified node from the list.
     * @param node The node to be removed.
     */
    public void remove(Node node) {
        if (node == null || head == null)
            return;
        if (node == head) {
            head = node.getNext();
            return;
        }
        Node previous = head;
        while (previous != null && previous.getNext() != node) {
            previous = previous.getNext();
        }
        if (previous != null) {
            previous.setNext(node.getNext());
        }
    }
}

package dev.bosse.datastructures.hash;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A hash table implementation using separate chaining.
 */
public class HashTable<K, V> {
    private ArrayList<HashNode<K, V>> buckets;
    private int size;
    private final int capacity;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            this.buckets.add(null);
        }
    }

    /**
     * Returns the number of key-value pairs in the hash table.
     *
     * @return the number of key-value pairs in the hash table
     */
    public int size() {
        return this.size;
    }

    /**
     * Checks if the hash table is empty.
     *
     * @return true if the hash table is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Computes the hash code for a given key.
     *
     * @param key the key to compute the hash code for
     * @return the hash code for the given key
     */
    private int hashCode(K key) {
        return Objects.hashCode(key);
    }

    /**
     * Computes the bucket index for a given key.
     *
     * @param key the key to compute the bucket index for
     * @return the bucket index for the given key
     */
    private int getBucketIndex(K key) {
        int index = hashCode(key) % this.capacity;
        return index < 0 ? index + this.capacity : index;
    }

    /**
     * Removes the key-value pair associated with the given key from the hash table.
     *
     * @param key the key to remove
     * @return the value associated with the given key, or null if the key is not found
     */
    public V remove(K key) {
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);

        HashNode<K, V> head = this.buckets.get(bucketIndex);
        HashNode<K, V> prev = null;

        while (head != null && head.key != key) {
            prev = head;
            head = head.next;
        }

        if (head == null) {
            return null;
        }

        this.size--;
        if (prev != null) {
            prev.next = head.next;
        } else {
            this.buckets.set(bucketIndex, head.next);
        }

        return head.value;
    }

    /**
     * Retrieves the value associated with the given key from the hash table.
     *
     * @param key the key to retrieve the value for
     * @return the value associated with the given key, or null if the key is not found
     */
    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);

        HashNode<K, V> head = this.buckets.get(bucketIndex);

        while (head != null && head.key != key && head.hashCode != hashCode) {
            head = head.next;
        }

        return head == null ? null : head.value;
    }

    /**
     * Inserts a key-value pair into the hash table.
     *
     * @param key   the key to insert
     * @param value the value to insert
     */
    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);

        HashNode<K, V> head = this.buckets.get(bucketIndex);

        while (head != null) {
            if (head.key.equals(key) && head.hashCode == hashCode) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        HashNode<K, V> newNode = new HashNode<>(key, value, hashCode);
        newNode.next = this.buckets.get(bucketIndex);
        this.buckets.set(bucketIndex, newNode);
        this.size++;

        if ((size * 1.0) / capacity >= 0.7 ) {
            ArrayList<HashNode<K, V>> temp = buckets;
            buckets = new ArrayList<>(2 * capacity);

            for (HashNode<K, V> node : temp) {
                while (node != null) {
                    put(node.key, node.value);
                    node = node.next;
                }
            }
        }
    }
}

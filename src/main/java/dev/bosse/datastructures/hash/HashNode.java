package dev.bosse.datastructures.hash;

/**
 * Represents a node in a hash table.
 *
 * @param <K> the type of the key
 * @param <V> the type of the value
 */
public class HashNode<K, V>{
    K key;
    V value;
    final int hashCode;
    HashNode<K, V> next;

    public HashNode(K key, V value, int hashCode){
        this.key = key;
        this.value = value;
        this.next = null;
        this.hashCode = hashCode;
    }
}

package dev.bosse.datastructures.hash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {

    private HashTable<String, Integer> hashTable;

    @BeforeEach
    void setUp() {
        hashTable = new HashTable<>(4);
    }

    @Test
    void testInitialHashTableIsEmpty() {
        assertTrue(hashTable.isEmpty());
        assertEquals(0, hashTable.size());
    }

    @Test
    void testPutAndGetSingleEntry() {
        hashTable.put("one", 1);
        assertEquals(1, hashTable.get("one"));
        assertEquals(1, hashTable.size());
        assertFalse(hashTable.isEmpty());
    }

    @Test
    void testPutMultipleEntries() {
        hashTable.put("one", 1);
        hashTable.put("two", 2);
        hashTable.put("three", 3);

        assertEquals(1, hashTable.get("one"));
        assertEquals(2, hashTable.get("two"));
        assertEquals(3, hashTable.get("three"));
        assertEquals(3, hashTable.size());
    }

    @Test
    void testPutUpdatesExistingKey() {
        hashTable.put("one", 1);
        assertEquals(1, hashTable.get("one"));

        hashTable.put("one", 10);
        assertEquals(10, hashTable.get("one"));
        assertEquals(1, hashTable.size());
    }

    @Test
    void testGetNonExistentKey() {
        hashTable.put("one", 1);
        assertNull(hashTable.get("missing"));
    }

    @Test
    void testGetFromEmptyHashTable() {
        assertNull(hashTable.get("key"));
    }

    @Test
    void testRemoveExistingKey() {
        hashTable.put("one", 1);
        hashTable.put("two", 2);

        Integer removed = hashTable.remove("one");
        assertEquals(1, removed);
        assertNull(hashTable.get("one"));
        assertEquals(1, hashTable.size());
        assertEquals(2, hashTable.get("two"));
    }

    @Test
    void testRemoveOnlyElement() {
        hashTable.put("one", 1);
        hashTable.remove("one");

        assertTrue(hashTable.isEmpty());
        assertEquals(0, hashTable.size());
        assertNull(hashTable.get("one"));
    }

    @Test
    void testRemoveNonExistentKey() {
        hashTable.put("one", 1);
        Integer removed = hashTable.remove("missing");
        assertNull(removed);
        assertEquals(1, hashTable.size());
        assertEquals(1, hashTable.get("one"));
    }

    @Test
    void testRemoveFromEmptyHashTable() {
        assertNull(hashTable.remove("key"));
        assertTrue(hashTable.isEmpty());
    }

    @Test
    void testSizeIncreasesOnPut() {
        assertEquals(0, hashTable.size());
        hashTable.put("a", 1);
        assertEquals(1, hashTable.size());
        hashTable.put("b", 2);
        assertEquals(2, hashTable.size());
        hashTable.put("c", 3);
        assertEquals(3, hashTable.size());
    }

    @Test
    void testSizeDecreasesOnRemove() {
        hashTable.put("a", 1);
        hashTable.put("b", 2);
        hashTable.put("c", 3);
        assertEquals(3, hashTable.size());

        hashTable.remove("b");
        assertEquals(2, hashTable.size());
    }

    @Test
    void testSizeDoesNotChangeOnUpdate() {
        hashTable.put("one", 1);
        assertEquals(1, hashTable.size());

        hashTable.put("one", 2);
        assertEquals(1, hashTable.size());

        hashTable.put("one", 3);
        assertEquals(1, hashTable.size());
        assertEquals(3, hashTable.get("one"));
    }

    @Test
    void testIsEmptyAfterPut() {
        assertTrue(hashTable.isEmpty());
        hashTable.put("key", 1);
        assertFalse(hashTable.isEmpty());
    }

    @Test
    void testIsEmptyAfterRemove() {
        hashTable.put("key", 1);
        assertFalse(hashTable.isEmpty());
        hashTable.remove("key");
        assertTrue(hashTable.isEmpty());
    }

    @Test
    void testNullKey() {
        hashTable.put(null, 42);
        assertEquals(42, hashTable.get(null));
        assertEquals(1, hashTable.size());

        Integer removed = hashTable.remove(null);
        assertEquals(42, removed);
        assertNull(hashTable.get(null));
    }

    @Test
    void testNullValue() {
        hashTable.put("key", null);
        assertNull(hashTable.get("key"));
        assertEquals(1, hashTable.size());
    }

    @Test
    void testIntegerKeys() {
        HashTable<Integer, String> intTable = new HashTable<>(4);
        intTable.put(10, "ten");
        intTable.put(20, "twenty");
        intTable.put(30, "thirty");

        assertEquals("ten", intTable.get(10));
        assertEquals("twenty", intTable.get(20));
        assertEquals("thirty", intTable.get(30));
        assertEquals(3, intTable.size());
    }

    @Test
    void testManyEntriesExceedingCapacity() {
        HashTable<String, Integer> table = new HashTable<>(2);
        for (int i = 0; i < 10; i++) {
            table.put("key" + i, i);
        }

        assertEquals(10, table.size());
        for (int i = 0; i < 10; i++) {
            assertEquals(i, table.get("key" + i));
        }
    }

    @Test
    void testRemoveAllEntries() {
        hashTable.put("a", 1);
        hashTable.put("b", 2);
        hashTable.put("c", 3);

        hashTable.remove("a");
        hashTable.remove("b");
        hashTable.remove("c");

        assertTrue(hashTable.isEmpty());
        assertEquals(0, hashTable.size());
    }

    @Test
    void testPutAfterRemove() {
        hashTable.put("one", 1);
        hashTable.remove("one");

        hashTable.put("two", 2);
        assertEquals(2, hashTable.get("two"));
        assertEquals(1, hashTable.size());
    }
}

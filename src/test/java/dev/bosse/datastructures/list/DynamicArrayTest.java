package dev.bosse.datastructures.list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicArrayTest {

    @Test
    public void testAdd() {
        DynamicArray array = new DynamicArray(4);
        array.add(1);
        array.add(2);
        array.add(3);
        assertEquals(3, array.get(2));
    }

    @Test
    public void testInsertAt() {
        DynamicArray array = new DynamicArray(8);
        array.add(1);
        array.add(2);
        array.add(3);
        array.insertAt(1, 4);
        assertEquals(4, array.get(1));
        assertEquals(2, array.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> array.insertAt(4, 5));
    }

    @Test
    public void testRemoveAt() {
        DynamicArray array = new DynamicArray(4);
        array.add(1);
        array.add(2);
        array.add(3);
        array.removeAt(1);
        assertEquals(3, array.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> array.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> array.removeAt(3));
    }

    @Test
    public void testGet() {
        DynamicArray array = new DynamicArray(4);
        array.add(1);
        array.add(2);
        array.add(3);
        assertEquals(2, array.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> array.get(3));
    }

    @Test
    public void testSearch() {
        DynamicArray array = new DynamicArray(4);
        array.add(1);
        array.add(2);
        array.add(3);
        assertEquals(1, array.search(2));
        assertEquals(-1, array.search(4));
    }
}

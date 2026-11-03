package dev.bosse.datastructures.list;

/**
 * A dynamic array implementation that automatically resizes itself when necessary.
 */
public class DynamicArray {
    private int[] array;
    private int count;

    public DynamicArray(int size) {
        this.array = new int[size];
        this.count = 0;
    }

    /**
     * Adds the given value to the end of the array.
     * If the array is full, it will be resized.
     */
    public void add(int value) {
        if (this.array.length == this.count) {
            resizeArray();
        }
        this.array[this.count] = value;
        this.count++;
    }

    /**
     * Returns the value at the given index in the array.
     * Throws an IndexOutOfBoundsException if the index is out of bounds.
     */
    public int get(int index) {
        if (index < 0 || index >= this.count) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return this.array[index];
    }

    /**
     * Inserts the given value at the specified index in the array.
     * Throws an IndexOutOfBoundsException if the index is out of bounds.
     */
    public void insertAt(int index, int value) {
        if (index < 0 || index >= this.count) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (this.array.length == this.count) {
            resizeArray();
        }
        for (int i = this.count; i > index; i--) {
            this.array[i] = this.array[i - 1];
        }
        this.array[index] = value;
        this.count++;
    }

    /**
     * Removes the element at the given index from the array.
     * Throws an IndexOutOfBoundsException if the index is out of bounds.
     */
    public void removeAt(int index) {
        if (index < 0 || index >= this.count) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for (int i = index; i < this.count - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.count--;
    }

    /**
     * Searches for the given value in the array and returns its index.
     * Returns -1 if the value is not found.
     */
    public int search(int value) {
        for (int i = 0; i < this.count; i++) {
            if (this.array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Resizes the array to double its current size.
     */
    private void resizeArray() {
        int[] newArray = new int[this.array.length * 2];
        System.arraycopy(this.array, 0, newArray, 0, this.count);
        this.array = newArray;
    }
}

package dev.bosse.datastructures.list;

public interface Collection<T>{
    void add(T element);

    T get(int index);

    T remove(int index);

    boolean contains(T element);

    int size();

    boolean isEmpty();

    void clear();
}

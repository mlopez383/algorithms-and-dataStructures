package com.avantica.tutorial.algorithmsdatastructures.queue;

public interface Queue<T> {
    void enqueue(T item);
    T dequeue();
    boolean isEmpty();
    int size();
}

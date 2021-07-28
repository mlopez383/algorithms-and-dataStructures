package com.avantica.tutorial.algorithmsdatastructures.stack;

public interface Stack<T> {
    void push(T item);
    T pop();
    boolean isEmpty();
    int size();
}

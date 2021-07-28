package com.avantica.tutorial.algorithmsdatastructures.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyStack<T> implements Stack<T> {

    protected Node<T> first = null;
    private int count = 0;

    protected class Node<T>{
        private T item;
        private Node<T> next;
    }

    public MyStack(){}

    public void push(T item) {
        if (item == null) throw new IllegalArgumentException("Item is null");
        Node<T> oldNext = first;
        first = new Node<T>();
        first.item = item;
        first.next = oldNext;
        count++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("The stack is empty");
        }

        T value = first.item;
        first = first.next;
        count--;
        return value;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return count;
    }

    public T peek()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException("The stack is empty");
        }
        return first.item;
    }

    public Iterator<T> stackIterator() {
        return new ListIterator<T>(first);
    }

    private class ListIterator<T> implements Iterator<T> {
        private Node<T> current;

        public ListIterator(Node<T> head) {
            current = head;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}

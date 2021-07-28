package com.avantica.tutorial.algorithmsdatastructures.queue;

import java.util.NoSuchElementException;

public class MyQueue<T> implements Queue<T>{

    private Node<T> head = null, tail = null;
    private int count = 0;


    private class Node<T>{
        private T item;
        private Node<T> next;

        public Node (T item) {
            this.item = item;
        }
    }

    public MyQueue(){}

    public void enqueue(T item) {
        if (isEmpty()) {
            head = tail = new Node(item);
        }else{
            tail.next = tail = new Node(item);
        }
        count++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty");
        }

        T item = head.item;

        head = head.next;
        count--;

        if (isEmpty()) {
            tail = null;
        }

        return item;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return count;
    }
}
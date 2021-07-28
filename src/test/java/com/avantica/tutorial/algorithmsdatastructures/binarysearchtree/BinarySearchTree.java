package com.avantica.tutorial.algorithmsdatastructures.binarysearchtree;

import java.util.List;

public interface BinarySearchTree<K, T> {
    T find(K key);
    void add(K key, T value);
    T delete(K key);
    List<T> inOrder();
    List<T> postOrder();
    List<T> preOrder();
}

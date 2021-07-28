package com.avantica.tutorial.algorithmsdatastructures.binarysearchtree;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MyBinarySearchTree<K extends Comparable<K>, T> implements BinarySearchTree<K,T> {

    private Node root;

    private class Node{
        private K key;
        private T value;
        private Node left, right;
        private int size;

        public Node(K key, T value, int size){
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        else return node.size;
    }

    public MyBinarySearchTree(){
    }

    public T find(K key) {
        if (key == null)
            throw new IllegalArgumentException("BST: Key is null");
        else{
            T value = find(root, key);
            if(value == null)
                throw new NoSuchElementException("BST: Value not exists");
            else
                return value;
        }
    }

    private T find(Node node, K key) {
        if (node == null) return null;
        int comparisonKeys = key.compareTo(node.key);
        if      (comparisonKeys < 0)  return find(node.left, key);
        else if (comparisonKeys > 0)  return find(node.right, key);
        else                          return node.value;
    }

    public void add(K key, T value) {
        if (key == null)
            throw new IllegalArgumentException("BST: Key is null");
        if (value == null)
            throw new IllegalArgumentException("BST: Value is null");
        root = add(root, key, value);
    }

    private Node add(Node node, K key, T value) {
        if (node == null) return new Node(key, value, 1);
        int comparisonKeys = key.compareTo(node.key);
        if      (comparisonKeys < 0)  node.left  = add(node.left, key, value);
        else if (comparisonKeys > 0)  node.right = add(node.right, key, value);
        else                          node.value = value;
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    public T delete(K key) {
        T deletedElement = find(key);
        if (key == null) throw new IllegalArgumentException("BST: Key is null");
        root = delete(root, key);
        return deletedElement;
    }

    private Node delete(Node node, K key) {
        if (node == null) return null;

        int comparisonKeys = key.compareTo(node.key);
        if      (comparisonKeys < 0) node.left  = delete(node.left, key);
        else if (comparisonKeys > 0) node.right = delete(node.right, key);
        else {
            if (node.right == null) return node.left;
            if (node.left  == null) return node.right;
            Node t = node;
            node = getMinimumNode(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    private Node getMinimumNode(Node node) {
        if (node.left == null)
            return node;
        else
            return getMinimumNode(node.left);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public List<T> inOrder() {
        List<T> list = new ArrayList<T>();
        inOrder(root, list);
        return list;
    }

    private void inOrder(Node node, List<T> list){
        if(node != null){
            inOrder(node.left, list);
            list.add(node.value);
            inOrder(node.right, list);
        }
    }

    public List<T> postOrder() {
        List<T> list = new ArrayList<T>();
        postOrder(root, list);
        return list;
    }

    private void postOrder(Node node, List<T> list){
        if(node != null){
            postOrder(node.left, list);
            postOrder(node.right, list);
            list.add(node.value);
        }
    }

    public List<T> preOrder() {
        List<T> list = new ArrayList<T>();
        preOrder(root, list);
        return list;
    }

    private void preOrder(Node node, List<T> list){
        if(node != null){
            list.add(node.value);
            preOrder(node.left, list);
            preOrder(node.right, list);
        }
    }

    public K getMaxItem() {
        if (size() == 0) throw new NoSuchElementException("BST: tree is empty");
        return getMaxItem(root).key;
    }

    private Node getMaxItem(Node x) {
        if (x.right == null) return x;
        else                 return getMaxItem(x.right);
    }
}

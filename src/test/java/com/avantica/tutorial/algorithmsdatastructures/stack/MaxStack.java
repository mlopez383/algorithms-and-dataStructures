package com.avantica.tutorial.algorithmsdatastructures.stack;

import com.avantica.tutorial.algorithmsdatastructures.binarysearchtree.MyBinarySearchTree;
import java.util.NoSuchElementException;

public class MaxStack<T extends Comparable>  extends MyStack<T>{
    private MyBinarySearchTree<Integer, String> myBST = new MyBinarySearchTree<Integer, String>();

    public T getMaxItem (){
        return (T)myBST.getMaxItem();
    }

    public MaxStack(){
        super();
    }

    @Override
    public void push(T item) {
        myBST.add((Integer) item, item.toString());
        super.push(item);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("The stack is empty");
        }

        T deleted = peek();
        myBST.delete((Integer)deleted);

        return super.pop();
    }
}

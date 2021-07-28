package com.avantica.tutorial.algorithmsdatastructures.stack;


public class SortableStack <T extends Comparable>  extends MyStack<T>{
    public SortableStack(){
        super();
    }

    public MyStack<T> sort() {
        MyStack<T> tmp = new MyStack<T>();

        while(!isEmpty()){
            T value = peek();
            pop();

            while(!tmp.isEmpty() && (tmp.peek()).compareTo(value) > 0) {
               push(tmp.peek());
               tmp.pop();
            }

            tmp.push(value);
        }

        return tmp;
    }
}





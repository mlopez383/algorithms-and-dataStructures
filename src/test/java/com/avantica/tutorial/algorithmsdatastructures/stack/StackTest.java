package com.avantica.tutorial.algorithmsdatastructures.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class StackTest {
    private static final char[] CHAR_STACK_VALUES  = {'A', 'B', 'C'};
    private static final int[] INTEGER_STACK_VALUES  = {1, 7, 15, 50, 80};
    private static final int[] MIXED_INTEGER_STACK_VALUES  = {-5, -1, 0, 1, 7};

    @Test
    public void stackTest(){
        MyStack<Character> myStack = new MyStack<Character>();
        assertEquals("Failure - expected stack is not empty", true, myStack.isEmpty());
        myStack.push(CHAR_STACK_VALUES[0]);
        myStack.push(CHAR_STACK_VALUES[2]);
        myStack.push(CHAR_STACK_VALUES[1]);
        assertEquals("Failure - expected stack size does not match", 3, myStack.size());
        assertEquals("Failure - expected retrieved element does not match", CHAR_STACK_VALUES[1], (char)myStack.pop());
        assertEquals("Failure - expected retrieved element does not match", CHAR_STACK_VALUES[2], (char)myStack.pop());
        assertEquals("Failure - expected stack size does not match", 1, myStack.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void insertNullToStackTest(){
        MyStack<Character> myStack = new MyStack<Character>();
        myStack.push(null);
    }

    @Test
    public void insertNegativeValuesToStackTest(){
        MaxStack<Integer> myStack = new MaxStack<Integer>();
        for (int i=0; i<MIXED_INTEGER_STACK_VALUES.length; i++)
            myStack.push(MIXED_INTEGER_STACK_VALUES[i]);

        assertEquals("Failure - expected stack size does not match", 5, myStack.size());
        assertEquals("Failure - expected retrieved element does not match", MIXED_INTEGER_STACK_VALUES[4], (int)myStack.pop());
    }

    @Test
    public void pushAndPopStackTest(){
        MyStack<Character> myStack = new MyStack<Character>();
        myStack.push(CHAR_STACK_VALUES[0]);
        myStack.push(CHAR_STACK_VALUES[1]);
        assertEquals("Failure - expected stack size does not match", 2, myStack.size());
        assertEquals("Failure - expected retrieved element does not match", CHAR_STACK_VALUES[1], (char)myStack.pop());
        myStack.push(CHAR_STACK_VALUES[2]);
        assertEquals("Failure - expected retrieved element does not match", CHAR_STACK_VALUES[2], (char)myStack.pop());
        assertEquals("Failure - expected stack size does not match", 1, myStack.size());
    }

    @Test
    public void infixToPrefixTest(){
        InfixToPrefix infixToPrefix = new InfixToPrefix();
        String exp = "((1*2)+(3/4))";
        String prefix = infixToPrefix.convert(exp);
        assertEquals("Failure - expected conversion infix to prefix does not match", "(+(*12)(/34))", prefix);
    }

    @Test
    public void infixToPrefixTest2(){
        InfixToPrefix infixToPrefix = new InfixToPrefix();
        String exp = "((9*2)+(1/2)-(4*6))";
        String prefix = infixToPrefix.convert(exp);
        assertEquals("Failure - expected conversion infix to prefix does not match", "(+(*92)(-(/12)(*46)))", prefix);
    }

    @Test
    public void getMaxItemTest(){
        MaxStack<Integer> myStack = new MaxStack<Integer>();
        myStack.push(INTEGER_STACK_VALUES[1]);
        myStack.push(INTEGER_STACK_VALUES[2]);
        myStack.push(INTEGER_STACK_VALUES[4]);
        myStack.push(INTEGER_STACK_VALUES[3]);

        int maxElement = myStack.getMaxItem();
        assertEquals("Failure - expected max element does not match", INTEGER_STACK_VALUES[4], maxElement);
    }

    @Test
    public void sortStackTest(){
        SortableStack<Integer> sortableStack = new SortableStack<Integer>();
        sortableStack.push(INTEGER_STACK_VALUES[1]);
        sortableStack.push(INTEGER_STACK_VALUES[0]);
        sortableStack.push(INTEGER_STACK_VALUES[2]);
        sortableStack.push(INTEGER_STACK_VALUES[4]);
        sortableStack.push(INTEGER_STACK_VALUES[3]);

        MyStack<Integer> myStack = sortableStack.sort();
        assertTrue("Failure - expected sorted stack does not match", checkStackInDescendingOrder(myStack));
    }

    private boolean checkStackInDescendingOrder(MyStack<Integer> myStack){
        Integer maxElement = myStack.pop();
        while (!myStack.isEmpty()) {
            Integer current = myStack.pop();
            if( current > maxElement ){
                return false;
            }
        }
        return true;
    }
}

package com.avantica.tutorial.algorithmsdatastructures.binarysearchtree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class BinarySearchTreeTest {
    private MyBinarySearchTree<Integer, String> myBST = new MyBinarySearchTree<Integer, String>();
    private static final int BINARY_TREE_SIZE = 5;

    @Before
    public void initBST() {
        myBST.add(4, "4");
        myBST.add(5, "5");
        myBST.add(2, "2");
        myBST.add(1, "1");
        myBST.add(3, "3");
    }

    @Test
    public void findValue() {
        String value = myBST.find(3);
        assertEquals("Failure - expected value does not match", value, "3");
    }

    @Test
    public void inOrder() {
        List<String> inOrderList = myBST.inOrder();
        assertEquals("Failure - expected binary tree size does not match", myBST.size(), BINARY_TREE_SIZE);
        assertTrue("Failure - expected inOrder tree does not match",
                inOrderList.get(0) == "1" &&
                inOrderList.get(1) == "2" &&
                inOrderList.get(2) == "3" &&
                inOrderList.get(3) == "4" &&
                inOrderList.get(4) == "5");
    }

    @Test
    public void preOrder() {
        List<String> preOrderList = myBST.preOrder();
        assertEquals("Failure - expected binary tree size does not match", myBST.size(), BINARY_TREE_SIZE);
        assertTrue("Failure - expected preOrder tree does not match",
                preOrderList.get(0) == "4" &&
                preOrderList.get(1) == "2" &&
                preOrderList.get(2) == "1" &&
                preOrderList.get(3) == "3" &&
                preOrderList.get(4) == "5");
    }

    @Test
    public void postOrder() {
        List<String> postOrderList = myBST.postOrder();
        assertEquals("Failure - expected binary tree size does not match", myBST.size(), BINARY_TREE_SIZE);
        assertTrue("Failure - expected postOrder tree does not match",
                postOrderList.get(0) == "1" &&
                postOrderList.get(1) == "3" &&
                postOrderList.get(2) == "2" &&
                postOrderList.get(3) == "5" &&
                postOrderList.get(4) == "4");
    }

    @Test
    public void deleteNode() {
        String deletedNode = myBST.delete(2);
        List<String> inOrderList = myBST.inOrder();
        assertEquals("Failure - expected deleted node does not match", deletedNode, "2");
        assertFalse("Failure - expected deleted node was not removed", inOrderList.contains(deletedNode));
        assertEquals("Failure - expected binary tree size does not match", myBST.size(), BINARY_TREE_SIZE -1);
    }
}

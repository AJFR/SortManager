package com.m3c.ajfr;

import com.m3c.ajfr.binaryTree.Node;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class NodeTest {
    Node testNode;
    @Before
    public void nodeSetup(){
        testNode = new Node(100);
    }

    @Test
    public void getValueTest(){
        assertEquals(100,testNode.getValue());
    }

    @Test
    public void getLeftChildNullTest(){
        assertEquals(null,testNode.getLeftChild());
    }

    @Test
    public void getRightChildNullTest(){
        assertEquals(null, testNode.getRightChild());
    }

    @Test
    public void getLeftChildTest(){
        Node leftChild = new Node(7);
        testNode.setLeftChild(leftChild);
        assertEquals(7,testNode.getLeftChild().getValue());
    }

    @Test
    public void getRightChildTest(){
        Node rightChild = new Node(10);
        testNode.setRightChild(rightChild);
        assertEquals(10,testNode.getRightChild().getValue());
    }
}

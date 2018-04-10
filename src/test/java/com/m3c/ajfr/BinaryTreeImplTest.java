package com.m3c.ajfr;

import com.m3c.ajfr.binaryTree.BinaryTree;
import com.m3c.ajfr.binaryTree.BinaryTreeImpl;
import com.m3c.ajfr.binaryTree.ElementNotFoundException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;


public class BinaryTreeImplTest {

    @Test
    public void getNumberOfElementsTest() {
        BinaryTree bt = new BinaryTreeImpl(2);
        assertEquals(1,bt.getNumberOfElements());
    }

    @Test
    public void buildBinaryTreeSingleElementTest(){
        BinaryTree bt = new BinaryTreeImpl(2);
        assertEquals(1,bt.getNumberOfElements());
    }

    @Test
    public void buildBinaryTreeManyElementsTest(){
        int[] arrayOfElements = {1,2,3,4,5,6,7,8,9,10};
        BinaryTree bt = new BinaryTreeImpl(arrayOfElements);
        assertEquals(10,bt.getNumberOfElements());
    }

    @Test
    public void getRootElementTest(){
        BinaryTree bt = new BinaryTreeImpl(1);
        assertEquals(1,bt.getRootElement());
    }

    @Test
    public void addElementRecLeftTest() throws ElementNotFoundException {
        BinaryTree bt = new BinaryTreeImpl(2);
        bt.addElement(1);
        assertEquals(1, bt.getLeftChild(2));
    }

    @Test
    public void addElementRecRightTest() throws ElementNotFoundException {
        BinaryTree bt = new BinaryTreeImpl(2);
        bt.addElement(3);
        assertEquals(3, bt.getRightChild(2));
    }

    @Test
    public void addElementLeftTest() throws ElementNotFoundException{
        BinaryTree bt = new BinaryTreeImpl(2);
        bt.addElement(1);
        assertEquals(1, bt.getLeftChild(2));
    }

    @Test
    public void addElementRightTest() throws ElementNotFoundException{
        BinaryTree bt = new BinaryTreeImpl(2);
        bt.addElement(3);
        assertEquals(3, bt.getRightChild(2));
    }

    @Test(expected = ElementNotFoundException.class)
    public void getLeftChildExceptionTest() throws ElementNotFoundException{
        BinaryTree bt = new BinaryTreeImpl(2);
        bt.getLeftChild(2);
    }

    @Test(expected = ElementNotFoundException.class)
    public void getRightChildExceptionTest() throws ElementNotFoundException{
        BinaryTree bt = new BinaryTreeImpl(2);
        bt.getRightChild(2);
    }

    @Test
    public void getLeftChildTest() throws ElementNotFoundException{
        BinaryTree bt = new BinaryTreeImpl(2);
        bt.addElement(1);
        assertEquals(1,bt.getLeftChild(2));
    }

    @Test
    public void getRightChildTest() throws ElementNotFoundException{
        BinaryTree bt = new BinaryTreeImpl(2);
        bt.addElement(3);
        assertEquals(3,bt.getRightChild(2));
    }

    @Test
    public void findElementTest(){
        BinaryTree bt = new BinaryTreeImpl(2);
        bt.addElement(3);
        assertEquals(true,bt.findElement(3));
    }

    @Test
    public void getSortedTreeAscTest(){
        BinaryTree bt = new BinaryTreeImpl(2);
        bt.addElement(3);
        bt.addElement(1);
        int[] sortedArray = {1,2,3};
        List<Integer> sortedTreeAsc = bt.getSortedTreeAsc();
        assertArrayEquals(sortedArray,sortedTreeAsc.stream().mapToInt(i -> i).toArray());
    }

    @Test
    public void getSortedTreeDescTest(){
        BinaryTree bt = new BinaryTreeImpl(2);
        bt.addElement(3);
        bt.addElement(1);
        int[] sortedArray = {3,2,1};
        List<Integer> sortedTreeDesc = bt.getSortedTreeDesc();
        assertArrayEquals(sortedArray,sortedTreeDesc.stream().mapToInt(i -> i).toArray());
    }
}

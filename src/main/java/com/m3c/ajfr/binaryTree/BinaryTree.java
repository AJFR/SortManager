package com.m3c.ajfr.binaryTree;

import java.util.List;

/**
 * Created by alumniCurie01 on 03/04/2018.
 */
public interface BinaryTree {

    int getRootElement();

    int getNumberOfElements();

    void addElement(int element);

    void addElements(int[] elements);

    boolean findElement(int value);

    int getLeftChild(int element) throws ElementNotFoundException;

    int getRightChild(int element) throws ElementNotFoundException;

    List<Integer> getSortedTreeAsc();

    List<Integer> getSortedTreeDesc();
}

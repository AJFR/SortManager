package com.m3c.ajfr.sorters;

import com.m3c.ajfr.binaryTree.BinaryTree;
import com.m3c.ajfr.binaryTree.BinaryTreeImpl;

import java.util.List;

public class BinaryTreeSorter implements Sorter {
    BinaryTree binaryTree;
    @Override
    public int[] sortArray(int[] array) {
        binaryTree = new BinaryTreeImpl(array);
        List<Integer> sortedTree = binaryTree.getSortedTreeAsc();
        int[] sortedTreeIntArray = new int[binaryTree.getNumberOfElements()];
        for (int i = 0; i<binaryTree.getNumberOfElements();i++) {
            sortedTreeIntArray[i] = sortedTree.get(i);
        }
        return sortedTreeIntArray;
    }
}

package com.m3c.ajfr.display;

import com.m3c.ajfr.binaryTree.BinaryTree;

import java.util.List;

/**
 * Created by alumniCurie01 on 03/04/2018.
 */
public class DisplayManager {

    public void displayException(String message){
        System.out.println(message);

    }
    public void displayUnsortedArray(int[] unsortedArray){
        System.out.println("Unsorted Array:");
        printArray(unsortedArray);
    }

    public void displaySortedArray(int[] sortedArray, long timeTaken){
        System.out.println("Sorted Array:");
        printArray(sortedArray);
        System.out.println("Time Taken to Sort: "+ timeTaken/1000000+" ms");
    }

    public void printArray(int[] array){
        String arrayString = "";
        for (int ele:array) {
            arrayString += ele+",";
        }
        System.out.println(arrayString.substring(0,arrayString.length()-1));
    }

    public void viewTreeAsc(BinaryTree binaryTree) {
        List<Integer> treeAsc = (List<Integer>) binaryTree.getSortedTreeAsc();
        printArray(treeAsc);
    }

    public void viewTreeDesc(BinaryTree binaryTree) {
        List<Integer> treeDesc = (List<Integer>) binaryTree.getSortedTreeDesc();
        printArray(treeDesc);
    }

    public void printArray(List<Integer> arrayToPrint) {
        for (int element : arrayToPrint) {
            System.out.println(element);
        }
    }
}

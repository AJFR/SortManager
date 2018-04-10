package com.m3c.ajfr.controller;

import com.m3c.ajfr.sorters.BinaryTreeSorter;
import com.m3c.ajfr.sorters.BubbleSorter;
import com.m3c.ajfr.sorters.MergeSorter;
import com.m3c.ajfr.sorters.Sorter;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by alumniCurie01 on 03/04/2018.
 */
public class SortFactory {

    private static final String TYPE_NOT_FOUND = "Please enter a valid sorting algorithm in the properties file with Key sorter=";
    private static final String CONFIG_ERROR = "No Properties File is found in the given path.";

    public Sorter getInstance() throws SortFactoryException{
        String type;
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("resources/factory.properties"));
            type = properties.getProperty("sorter");
            if(type==null){
                type = "";
            }
            System.out.println("Sorter Type: "+ type);
        } catch (IOException e) {
            throw new SortFactoryException(CONFIG_ERROR);
        }
        switch (type) {
            case "BubbleSorter":
                return new BubbleSorter();
            case "bubble":
                return new BubbleSorter();
            case "Bubble":
                return new BubbleSorter();
            case "bubbleSorter":
                return new BubbleSorter();
            case "MergeSorter":
                return new MergeSorter();
            case "Merge":
                return new MergeSorter();
            case "merge":
                return new MergeSorter();
            case "mergeSorter":
                return new MergeSorter();
            case "binaryTree":
                return new BinaryTreeSorter();
            case "BinaryTree":
                return new BinaryTreeSorter();
            case "binary":
                return new BinaryTreeSorter();
            case "Binary":
                return new BinaryTreeSorter();
            default:
                throw new SortFactoryException(TYPE_NOT_FOUND);
        }

    }
}

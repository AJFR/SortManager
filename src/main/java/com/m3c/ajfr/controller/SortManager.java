package com.m3c.ajfr.controller;
import java.util.Random;

import com.m3c.ajfr.display.DisplayManager;
import com.m3c.ajfr.sorters.Sorter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



/**
 * Created by alumniCurie01 on 03/04/2018.
 */
public class SortManager {
    private static final Logger logger = LogManager.getLogger("SortManager");

    public void sortArray(){
        logger.info("Hello");
        logger.debug("World");
        int[] arrayToSort = createArray(10);
        //int[] arrayToSort = {27,9,31,11,6};
        DisplayManager displayManager = new DisplayManager();
        SortFactory factory = new SortFactory();
        Sorter sorter;
        try {
            sorter = factory.getInstance();
            displayManager.displayUnsortedArray(arrayToSort);
            long start = System.nanoTime();
            arrayToSort = sorter.sortArray(arrayToSort);
            long end = System.nanoTime();
            long timeTaken = (end-start);
            displayManager.displaySortedArray(arrayToSort, timeTaken);
        } catch (SortFactoryException e) {
            displayManager.displayException(e.getMessage());
        }
    }

    private int[] createArray(int size){
        Random random = new Random();
        int[] unsortedArray = new int[size];
        for(int i = 0; i<size;i++){
            unsortedArray[i] = random.nextInt(size*10)+1;
        }
        return unsortedArray;
    }

}

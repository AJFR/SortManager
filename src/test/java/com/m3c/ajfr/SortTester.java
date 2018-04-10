package com.m3c.ajfr;

import com.m3c.ajfr.sorters.BubbleSorter;
import com.m3c.ajfr.sorters.Sorter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by alumniCurie01 on 03/04/2018.
 */
public class SortTester {

    public Sorter sorter;

    @Before
    public void setup(){
        sorter = new BubbleSorter();
    }

    @Test
    public void testEmptyArray(){
        int[] array = {};
        sorter.sortArray(array);
        assertEquals(array.length,0);
    }

    @Test
    public void testSortedArray(){
        int[] array = {1,2,3,4,5};
        int[] sortedArray = sorter.sortArray(array);
        assertArrayEquals(sortedArray,array);
    }

    @Test
    public void testUnsortedArray(){
        int[] unsortedArray = {7,9,1,24,2,3,29,5};
        unsortedArray = sorter.sortArray(unsortedArray);
        int[] sortedArray = {1,2,3,5,7,9,24,29};
        assertArrayEquals(unsortedArray,sortedArray);
    }

    @Test
    public void testDuplicates(){
        int[] unsortedArray = {2,2,2,2,2,2,2,2,2,3,3,3,4,4,4,2,2,2,2,2,2,2,2};
        unsortedArray = sorter.sortArray(unsortedArray);
        int[] sortedArray = {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3,3,3,4,4,4};
        assertArrayEquals(unsortedArray,sortedArray);
    }

    @Test
    public void testSingle(){
        int[] unsortedArray = {1};
        unsortedArray = sorter.sortArray(unsortedArray);
        int[] sortedArray = {1};
        assertArrayEquals(sortedArray,unsortedArray);
    }

    @Test
    public void testOddArray(){
        int[] unsortedArray = {5,2,4,3,1};
        unsortedArray = sorter.sortArray(unsortedArray);
        int[] sortedArray = {1,2,3,4,5};
        assertArrayEquals(unsortedArray,sortedArray);
    }

    @Test
    public void testEvenArray(){
        int[] unsortedArray = {5,2,4,3,1,6};
        unsortedArray = sorter.sortArray(unsortedArray);
        int[] sortedArray = {1,2,3,4,5,6};
        assertArrayEquals(unsortedArray,sortedArray);
    }
}

package com.m3c.ajfr.sorters;

/**
 * Created by alumniCurie01 on 03/04/2018.
 */
public class BubbleSorter implements Sorter{

    @Override
    public int[] sortArray(int[] array){
        if(array.length<2){
            return array;
        }
        boolean sorted = false;
        while(!sorted){
            sorted = true;
            for(int arrayCnt = 0; arrayCnt<array.length - 1; arrayCnt++){
                int arrayVar1 = array[arrayCnt];
                int arrayVar2 = array[arrayCnt+1];
                if(arrayVar1>arrayVar2){
                    array[arrayCnt] = arrayVar2;
                    array[arrayCnt+1] = arrayVar1;
                    sorted = false;
                }
            }
        }
        return array;
    }

}


package com.m3c.ajfr.sorters;

/**
 * Created by alumniCurie01 on 03/04/2018.
 */
public class MergeSorter implements Sorter{

    @Override
    public int[] sortArray(int[] array) {
        int arrayLength = array.length;
        int[] leftHalf;
        int[] rightHalf;
        int[] mergedArray = new int[arrayLength];
        if (arrayLength % 2 == 0) {
            leftHalf = new int[(arrayLength / 2)];
            rightHalf = new int[(arrayLength / 2)];
            System.arraycopy(array, 0, leftHalf, 0, arrayLength / 2);
            System.arraycopy(array, (arrayLength / 2), rightHalf, 0, (arrayLength / 2));
        } else {
            leftHalf = new int[(arrayLength / 2) + 1];
            rightHalf = new int[(arrayLength / 2)];
            System.arraycopy(array, 0, leftHalf, 0, (arrayLength / 2) + 1);
            System.arraycopy(array, (arrayLength / 2) + 1, rightHalf, 0, (arrayLength / 2));
        }
        if(leftHalf.length>1) {
            leftHalf = sortArray(leftHalf);
            rightHalf = sortArray(rightHalf);

        }
        mergedArray = mergeArray(leftHalf, rightHalf);
        return mergedArray;
    }

    public int[] mergeArray(int[] l,int[] r){
        int lLength = l.length;
        int rLength = r.length;
        int[] mergedArray = new int[lLength+rLength];
        int lCnt = 0;
        int rCnt = 0;
        int mACnt = 0;

        while(rCnt<rLength && lCnt<lLength){
            if(l[lCnt]<=r[rCnt]){
                mergedArray[mACnt] = l[lCnt];
                lCnt++;
            }
            else{
                mergedArray[mACnt] = r[rCnt];
                rCnt++;
            }
            mACnt++;
        }
        if(lCnt==lLength){
            while(rCnt<rLength){
                mergedArray[mACnt] = r[rCnt];
                rCnt++;
                mACnt++;
            }
        }
        if(rCnt==rLength){
            while(lCnt<lLength){
                mergedArray[mACnt] = l[lCnt];
                lCnt++;
                mACnt++;
            }
        }
        return mergedArray;
    }

    public void printArray(int[] array){
        String arrayString = "";
        for (int ele:array) {
            arrayString += ele+",";
        }
        System.out.println(arrayString.substring(0,arrayString.length()-1));
    }
}


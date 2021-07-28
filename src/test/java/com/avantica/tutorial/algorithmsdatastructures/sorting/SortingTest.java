package com.avantica.tutorial.algorithmsdatastructures.sorting;

import org.junit.Before;
import org.junit.Test;

public class SortingTest {

    private Sorting sorting = new Sorting();
    private Integer[] integerArray;
    private static final int arraySize = 10000;
    private long startTime, endTime;

    @Before
    public void initialize(){
        integerArray = generateRandomIntegers(arraySize);
        startTime = System.nanoTime();
    }

    @Test
    public void selectionSortTest()
    {
        sorting.selectionSort(integerArray);
        calculateDurationAndCheckSorting("Selection");
    }

    @Test
    public void insertionSortTest()
    {
        sorting.insertionSort(integerArray);
        calculateDurationAndCheckSorting("Insertion");
    }

    @Test
    public void mergeSortTest()
    {
        sorting.mergeSort(integerArray);
        calculateDurationAndCheckSorting("MergeSort");
    }

    @Test
    public void quickSortTest()
    {
        sorting.quickSort(integerArray);
        calculateDurationAndCheckSorting("QuickSort");
    }

    @Test
    public void bubbleSortTest(){
        sorting.bubbleSort(integerArray);
        calculateDurationAndCheckSorting("BubbleSort");
    }

    private void calculateDurationAndCheckSorting(String nameSorting){
        endTime = System.nanoTime();
        System.out.print("Duration Time " + nameSorting + " : " + (endTime-startTime)/1e6 + " ms ");
        System.out.println(IsAscOrderValid(integerArray) ? "(VALID ORDER)" : "(INVALID ORDER)");
    }

    private Integer[] generateRandomIntegers(int arraySize){
        Integer[] numbers = new Integer[arraySize];

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random()*100 + 1);
        }
        return numbers;
    }

    private boolean IsAscOrderValid(Comparable[] items)
    {
        for (int i = 0; i < items.length-1; i++) {
            if (items[i].compareTo(items[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
}

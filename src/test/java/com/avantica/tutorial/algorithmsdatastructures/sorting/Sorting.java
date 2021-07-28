package com.avantica.tutorial.algorithmsdatastructures.sorting;

public class Sorting {
    /*************INSERTION SORT ALGORITHM*************/
    public void insertionSort (final Comparable[] items) {
        int SIZE = items.length;
        for (int itemsIndex = 1; itemsIndex < SIZE; itemsIndex++)
        {
            for (int currentIndex = itemsIndex; currentIndex > 0 && items[currentIndex].compareTo(items[currentIndex-1])<0; currentIndex--){
                swap(items, currentIndex, currentIndex-1);
            }
        }
    }

    /*************BUBBLE SORT ALGORITHM*************/
    public void bubbleSort (Comparable[] items) {
        boolean swapped = true;
        for(int itemsIndex = items.length - 1; itemsIndex > 0 && swapped; itemsIndex--) {
            swapped = false;
            for (int currentIndex = 0; currentIndex < itemsIndex; currentIndex++) {
                if (items[currentIndex+1].compareTo(items[currentIndex])<0){
                    swap (items, currentIndex, currentIndex+1);
                    swapped = true;
                }
            }
        }
    }

    /*************SELECTION SORT ALGORITHM*************/
    public void selectionSort (Comparable[] items) {
        int min, SIZE = items.length;
        for (int itemsIndex = 0; itemsIndex < SIZE; itemsIndex++)
        {
            min = itemsIndex;
            for (int currentIndex = itemsIndex+1; currentIndex < SIZE; currentIndex++) {
                if (items[currentIndex].compareTo(items[min]) < 0)
                    min = currentIndex;
            }
            swap(items, itemsIndex, min);
        }
    }

    /*************QUICK SORT ALGORITHM*************/
    public static void quickSort(Comparable[] items) {
        quickSort(items, 0, items.length - 1);
    }

    private static void quickSort(Comparable[] items, int left, int right) {
        if (right <= left) return;
        int indexPartition = partition(items, left, right);
        quickSort(items, left, indexPartition-1);
        quickSort(items, indexPartition+1, right);
    }

    private static int partition(Comparable[] items, int left, int right) {
        int leftIndex = left;
        int rightIndex = right + 1;
        Comparable v = items[left];
        while (true) {
            while (items[++leftIndex].compareTo(v) < 0) {
                if (leftIndex == right) break;
            }

            while (v.compareTo(items[--rightIndex]) < 0) {
                if (rightIndex == left) break;
            }

            if (leftIndex >= rightIndex) break;
            swap(items, leftIndex, rightIndex);
        }
        swap(items, left, rightIndex);
        return rightIndex;
    }

    /*************MERGE SORT ALGORITHM*************/
    private static void merge(Comparable[] items, Comparable[] tmp, int left, int center, int right) {
        for (int itemsIndex = left; itemsIndex <= right; itemsIndex++) {
            tmp[itemsIndex] = items[itemsIndex];
        }

        int leftIndex = left, centerIndex = center + 1;
        for (int currentIndex = left; currentIndex <= right; currentIndex++) {
            if      (leftIndex > center)                                items[currentIndex] = tmp[centerIndex++];
            else if (centerIndex > right)                               items[currentIndex] = tmp[leftIndex++];
            else if (tmp[centerIndex].compareTo(tmp[leftIndex]) < 0)    items[currentIndex] = tmp[centerIndex++];
            else                                                        items[currentIndex] = tmp[leftIndex++];
        }
    }

    private static void mergeSort(Comparable[] items, Comparable[] tmp, int left, int right) {
        if (right <= left) return;
        int center = left + (right - left) / 2;
        mergeSort(items, tmp, left, center);
        mergeSort(items, tmp, center + 1, right);
        merge(items, tmp, left, center, right);
    }

    public static void mergeSort(Comparable[] items) {
        Comparable[] tmp = new Comparable[items.length];
        mergeSort(items, tmp, 0, items.length-1);
    }


    /*************helper algorithm*************/
    private static void swap(Comparable[] array, final int firstItem, final int secondItem) {
        Comparable swap = array[firstItem];
        array[firstItem] = array[secondItem];
        array[secondItem] = swap;
    }
}

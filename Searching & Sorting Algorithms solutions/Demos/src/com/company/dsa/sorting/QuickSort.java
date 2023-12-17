package com.company.dsa.sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] list = new int[10];
        Random random = new Random();
        for (int i = 0; i < list.length; i++) {
            list[i] = random.nextInt(10000);
        }

        System.out.println(Arrays.toString(list));
        long startTime = System.currentTimeMillis();
        quickSort(list);
        long endTime = System.currentTimeMillis();

        System.out.println(Arrays.toString(list));
        System.out.println("Took " + (endTime - startTime) + "ms");
    }

    // https://www.youtube.com/watch?v=h8eyY7dIiN4&t=17s
    private static void quickSort(int[] list) {
        int lowIndex = 0;
        int highIndex = list.length - 1;

        quickSortRecursion(list, lowIndex, highIndex);
    }

    private static void quickSortRecursion(int[] list, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }
        //choosing a random pivot and puting it as the last element of the array
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = list[pivotIndex];
        swap(list, pivotIndex, highIndex);
        //partitioning step to put the lower elements compared with the pivot to the left and the biger elements compared with the pivot to the right!!!!!!!!!!
        int leftPointer = partition(list, lowIndex, highIndex, pivot);

        //now we need to recursively call the left side of the pivot
        quickSortRecursion(list, lowIndex, leftPointer - 1);
        //now we need to recursively call the right side of the pivot
        quickSortRecursion(list, leftPointer + 1, highIndex);

    }

    private static int partition(int[] list, int lowIndex, int highIndex, int pivot) {
        // we create 2 indexes left&right pointers
        int leftPointer = lowIndex;
        int rightPointer = highIndex;
        // we increment the leftPointer till we find a number that is higher than the pivot or we hit the rightPointer(both pointers point to the same place/element)
        while (leftPointer < rightPointer) {
            while (list[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (list[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(list, leftPointer, rightPointer);
        }
        //when left & right elements are swaped we need to swap the pivot(highIndex) since we took it on random and put it as the last element
        swap(list, leftPointer, highIndex);
        return leftPointer;
    }

    private static void swap(int[] list, int index1, int index2) {
        int temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }


//    public static void quickSort(int[] list) {
//        quickSortRec(list, 0, list.length - 1);
//    }
//
//    private static void quickSortRec(int[] list, int start, int end) {
//        if (start >= end) {
//            return;
//        }
//
//        int partitionIndex = partition(list, start, end);
//        quickSortRec(list, start, partitionIndex - 1);
//        quickSortRec(list, partitionIndex, end);
//    }
//
//    private static int partition(int[] array, int start, int end) {
//        int pivot = array[(start + end) / 2];
//
//        while (start <= end) {
//            while (array[start] < pivot) {
//                start++;
//            }
//
//            while (array[end] > pivot) {
//                end--;
//            }
//
//            if (start <= end) {
//                int temp = array[start];
//                array[start] = array[end];
//                array[end] = temp;
//
//                start++;
//                end--;
//            }
//        }
//
//        return start;
//    }
}

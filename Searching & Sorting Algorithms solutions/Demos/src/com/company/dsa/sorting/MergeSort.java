package com.company.dsa.sorting;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        int[] list = new int[100000000];
        Random random = new Random();
        for (int i = 0; i < list.length; i++) {
            list[i] = random.nextInt(1000000000);
        }

//        System.out.println(Arrays.toString(list));
        long startTime = System.currentTimeMillis();
        mergeSort(list);
        long endTime = System.currentTimeMillis();

//        System.out.println(Arrays.toString(list));
        System.out.println("Took " + (endTime - startTime) + "ms");
    }
    // https://www.youtube.com/watch?v=bOk35XmHPKs

    private static void mergeSort(int[] list) {
        int length = list.length;
        if (list.length < 2) {
            return;
        }
        int midIndex = list.length / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[list.length - midIndex];
        for (int i = 0; i < leftHalf.length; i++) {
            leftHalf[i] = list[i];
        }
        for (int i = midIndex; i < list.length; i++) {
            rightHalf[i - midIndex] = list[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);
        merge(list, leftHalf, rightHalf);


    }

    private static void merge(int[] list, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                list[k] = leftHalf[i];
                i++;
            } else {
                list[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        while (i < leftSize){
            list[k] = leftHalf[i];
            i++;
            k++;
        }
        while(j < rightSize){
            list[k] = rightHalf[j];
            j++;
            k++;
        }
    }


//    public static void mergeSort(int[] list) {
//        mergeSortRec(list, 0, list.length - 1);
//    }
//
//    private static void mergeSortRec(int[] list, int start, int end) {
//        if (start >= end) {
//            return;
//        }
//
//        int middleIndex = (start + end) / 2;
//        mergeSortRec(list, start, middleIndex);
//        mergeSortRec(list, middleIndex + 1, end);
//        merge(list, start, middleIndex, end);
//    }
//
//    private static void merge(int[] list, int start, int middle, int end) {
//        int[] mergedArr = new int[end - start + 1];
//
//        int leftIndex = start;
//        int rightIndex = middle + 1;
//        int mergeIndex = 0;
//
//        while (leftIndex <= middle && rightIndex <= end) {
//            if (list[leftIndex] < list[rightIndex]) {
//                mergedArr[mergeIndex++] = list[leftIndex++];
//            } else {
//                mergedArr[mergeIndex++] = list[rightIndex++];
//            }
//        }
//
//        while (leftIndex <= middle) {
//            mergedArr[mergeIndex++] = list[leftIndex++];
//        }
//        while (rightIndex <= end) {
//            mergedArr[mergeIndex++] = list[rightIndex++];
//        }
//
//        for (int i = 0; i < mergedArr.length; i++) {
//            list[start + i] = mergedArr[i];
//        }
//    }
}
package com.company.dsa.sorting;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) {
        int[] list = new int[10];
        Random random = new Random();
        for (int i = 0; i < list.length; i++) {
            list[i] = random.nextInt(100000);
        }

        System.out.println(Arrays.toString(list));
        long startTime = System.currentTimeMillis();
        selectionSort(list);
        long endTime = System.currentTimeMillis();
        System.out.println("Took " + (endTime - startTime) + "ms");

        System.out.println(Arrays.toString(list));
    }
    //https://www.youtube.com/watch?v=dsqsnngsoD8

    public static void selectionSort(int[] list) {
        int length = list.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (list[j] < list[i]) {
                    int temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
    }
}

//    public static void selectionSort(int[] list) {
//        for (int i = 0; i < list.length; i++) {
//            for (int j = i+1; j < list.length; j++) {
//                if (list[j] < list[i]) {
//                    int t = list[i];
//                    list[i] = list[j];
//                    list[j] = t;
//                }
//            }
//        }
//    }
//}

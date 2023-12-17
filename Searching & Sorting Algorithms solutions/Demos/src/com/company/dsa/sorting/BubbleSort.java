package com.company.dsa.sorting;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        int[] list = new int[100];
        Random random = new Random();
        for (int i = 0; i < list.length; i++) {
            list[i] = random.nextInt(1000000);
        }

        System.out.println(Arrays.toString(list));
        long startTime = System.currentTimeMillis();
        bubbleSort(list);
        long endTime = System.currentTimeMillis();
        System.out.println("Took " + (endTime - startTime) + "ms");
        System.out.println(Arrays.toString(list));
    }

    // https://www.youtube.com/watch?v=g8qeaEd2jTc
    public static void bubbleSort(int[] list) {
        boolean isInOrder = true;
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] > list[i + 1]) {
                int temp = list[i];
                list[i] = list[i + 1];
                list[i + 1] = temp;
                isInOrder = false;
            }
            if (!isInOrder) {
                bubbleSort(list);
            }
        }


//    public static void bubbleSort(int[] list) {
//        boolean inOrder = false;
//        while (!inOrder) {
//            inOrder = true;
//            for (int i = 0; i < list.length - 1; i++) {
//                if (list[i] > list[i + 1]) {
//                    int t = list[i];
//                    list[i] = list[i + 1];
//                    list[i + 1] = t;
//                    inOrder = false;
//                }
//            }
//        }
    }
}

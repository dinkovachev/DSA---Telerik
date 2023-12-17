package com.company.dsa.searching;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] list = {6, 8, 9, 11, 14, 17, 22, 23, 25, 28, 30};
        System.out.println(binarySearch(22, list));
        System.out.println(Arrays.binarySearch(list, 22));
    }

    private static int binarySearch(int x, int[] list) {
        int startIndex = 0;
        int endIndex = list.length - 1;
        return binarySearchRecursive(x, list, startIndex, endIndex);

    }

    // https://www.youtube.com/watch?v=NFhOrxtXXcM

    private static int binarySearchRecursive(int x, int[] list, int startIndex, int endIndex) {
        int middleIndex = startIndex + (endIndex - startIndex) / 2;
        if (startIndex > endIndex) {
            return -1;
        }
        if (x == list[middleIndex]){
            return middleIndex;
        }
        if (x<list[middleIndex]){
            return binarySearchRecursive(x,list,startIndex,middleIndex - 1);
        }
        return binarySearchRecursive(x,list,middleIndex+1,endIndex);
    }


//    private static int binarySearch(int x, int[] list){
//        int startIndex = 0;
//        int endIndex = list.length - 1;
//
//        while (startIndex<=endIndex){
//            int middlePosition = (startIndex + endIndex) / 2;
//            int middleNumber = list[middlePosition];
//
//            if (x == middleNumber){
//                return middlePosition;
//            }
//            if (x < middleNumber){
//                endIndex = middlePosition - 1;
//            } else {
//                startIndex = middlePosition + 1;
//            }
//        }
//        return -1;
//    }

//    public static int binarySearch(int x, int[] list) {
//        return binarySearchRec(x, list, 0, list.length - 1);
//    }
//
//    public static int binarySearchRec(int x, int[] list, int startIndex, int endIndex) {
//        if (startIndex > endIndex) {
//            return -1;
//        }
//
//        int middleIndex = (startIndex + endIndex) / 2;
//        if (list[middleIndex] == x) {
//            return middleIndex;
//        }
//        if (x < list[middleIndex]) {
//            return binarySearchRec(x, list, startIndex, middleIndex - 1);
//        }
//
//        return binarySearchRec(x, list, middleIndex + 1, endIndex);
//    }
}

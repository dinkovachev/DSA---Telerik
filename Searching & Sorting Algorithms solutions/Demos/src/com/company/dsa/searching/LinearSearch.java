package com.company.dsa.searching;

public class LinearSearch {
    public static void main(String[] args) {
        int[] list = {11, 23, 8, 14, 30, 9, 6, 17, 22, 28};
        System.out.println(linearSearch(9, list));
    }

    public static int linearSearch(int x, int[] list) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == x) {
                return i;
            }
        }
        return -1;
    }
}

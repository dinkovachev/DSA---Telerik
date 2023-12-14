package com.company.dsa;

import com.sun.source.tree.BinaryTree;

public class Main {

    public static <E extends Comparable<E>> void main(String[] args) {
        BinarySearchTree testTree = new BinarySearchTreeImpl<>(50);
        testTree.insert(30);
        testTree.insert(20);
        testTree.insert(40);
        testTree.insert(70);
        testTree.insert(60);
        testTree.insert(80);
        testTree.insert(72);
        testTree.insert(71);


        testTree.search(60);


    }

}

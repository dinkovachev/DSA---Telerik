package com.company.dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTreeImpl<E extends Comparable<E>> implements BinarySearchTree<E> {
    private E value;
    private BinarySearchTreeImpl<E> left;
    private BinarySearchTreeImpl<E> right;

    public BinarySearchTreeImpl(E value) {
        this.value = value;
        left = null;
        right = null;
    }

    @Override
    public E getRootValue() {
        return value;
    }

    @Override
    public BinarySearchTree<E> getLeftTree() {
        return left;
    }

    @Override
    public BinarySearchTree<E> getRightTree() {
        return right;
    }

    @Override
    public void insert(E value) {
        insertRecursive(value);
    }

    public void insertRecursive(E valueToAdd) {

        if (valueToAdd.compareTo(this.value) <= 0) {
            if (this.left != null) {
                this.left.insertRecursive(valueToAdd);
            } else {
                this.left = new BinarySearchTreeImpl<>(valueToAdd);
            }
        } else if (this.right != null) {
            this.right.insertRecursive(valueToAdd);
        } else {
            this.right = new BinarySearchTreeImpl<>(valueToAdd);
        }
    }

    @Override
    public boolean search(E value) {

        return searchRecursive(value);
    }

    public boolean searchRecursive(E valueToSearch) {
        boolean valueExist = false;
        if (valueToSearch.compareTo(this.value) == 0) {
            valueExist = true;
        }
        if (this.left == null && this.right == null) {
            if (valueToSearch.compareTo(this.value) == 0) {
                valueExist = true;
            }
        }
        if (this.left != null && valueToSearch.compareTo(this.value) <= 0) {
            return this.left.searchRecursive(valueToSearch);

        } else if (this.right != null && valueToSearch.compareTo(this.value) > 0) {
            return this.right.searchRecursive(valueToSearch);
        }
        return valueExist;
    }

    @Override
    public List<E> inOrder() {
        List<E> orderOfElements = new ArrayList<>();
        inOrderRecursive(orderOfElements, this);
        return orderOfElements;
    }

    public void inOrderRecursive(List<E> orderOfElements, BinarySearchTreeImpl<E> root) {
        if (root != null) {
            inOrderRecursive(orderOfElements, root.left);
            orderOfElements.add(root.value);
            inOrderRecursive(orderOfElements, root.right);
        }
    }

    @Override
    public List<E> postOrder() {
        List<E> orderOfElements = new ArrayList<>();
        postOrderRecursive(orderOfElements, this);
        return orderOfElements;
    }

    public void postOrderRecursive(List<E> orderOfElements, BinarySearchTreeImpl<E> root) {
        if (root != null) {
            postOrderRecursive(orderOfElements, root.left);
            postOrderRecursive(orderOfElements, root.right);
            orderOfElements.add(root.value);
        }
    }

    @Override
    public List<E> preOrder() {
        List<E> orderOfElements = new ArrayList<>();
        preOrderRecursive(orderOfElements, this);
        return orderOfElements;
    }

    public void preOrderRecursive(List<E> orderOfElements, BinarySearchTreeImpl<E> root) {
        if (root != null) {
            orderOfElements.add(root.value);
            preOrderRecursive(orderOfElements, root.left);
            preOrderRecursive(orderOfElements, root.right);
        }
    }

    @Override
    public List<E> bfs() {
        List<E> bfsList = new ArrayList<>();
        bfsRecursive(bfsList, this);
        return bfsList;
    }

    public void bfsRecursive(List<E> bfsList, BinarySearchTreeImpl<E> root) {
        Queue<BinarySearchTreeImpl<E>> queue = new LinkedList<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            BinarySearchTreeImpl<E> current = queue.poll();
            bfsList.add(current.value);
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    @Override
    public int height() {

        return heightRecursion(this);

    }

    public int heightRecursion(BinarySearchTreeImpl<E> root) {
        if (root == null){
            return -1;
        }
        if (this.left == null && this.right == null) {
            return 0;
        }
        int leftHeight = heightRecursion(root.left);
        int rightHeight = heightRecursion(root.right);
        return Math.max(leftHeight + 1, rightHeight + 1);
    }
}

// Advanced task: implement remove method. To test, uncomment the commented tests in BinaryTreeImplTests
//    @Override
//    public boolean remove(E value) {
//        throw new UnsupportedOperationException();
//    }


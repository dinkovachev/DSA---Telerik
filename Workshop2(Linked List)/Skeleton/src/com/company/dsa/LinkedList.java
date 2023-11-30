package com.company.dsa;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {
    private Node head;
    private Node tail;
    private int size = 0;


    public LinkedList() {
    }

    public LinkedList(Iterable<T> iterable) {

        iterable.forEach(this::addLast);
    }

    @Override
    public void addFirst(T value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        tail = head;
        size++;
    }

    @Override
    public void addLast(T value) {
        Node newNode = new Node(value);
        newNode.next = null;
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    @Override
    public void add(int index, T value) {
        if (index < 0 || index > size) {
            throw new NoSuchElementException();
        }
        Node newNode = new Node(value);
        newNode.next = tail;
        tail.prev = newNode;
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.next = newNode;
        size++;
    }

    @Override
    public T getFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return head.value;
    }

    @Override
    public T getLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return tail.value;
    }

    @Override
    public T get(int index) {
        Node targetElement = head;
        for (int i = 0; i < index; i++) {
            targetElement = targetElement.next;
        }
        ;
        return targetElement.value;
    }

    @Override
    public int indexOf(T value) {
        if (size == 0) {
            return -1;
        }
        Node targetElement = head;
        int index = 0;
        for (int i = 0; i < size; i++) {
            targetElement = targetElement.next;
            if (targetElement.value == value) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node firstElement = head;
        for (int i = 0; i < 1; i++) {
            firstElement = firstElement.next;
        }
        head = firstElement;
        size--;
        return firstElement.value;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node previousToLast = head;
        for (int i = 0; i < size - 1; i++) {
            previousToLast = previousToLast.next;
        }
        previousToLast.next = null;
        tail = previousToLast;
        size--;
        return previousToLast.value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new iteratorLinkedList();
    }

    private class Node {
        T value;
        Node prev;
        Node next;

        Node(T value) {
            this.value = value;
        }
    }

    public class iteratorLinkedList implements Iterator<T> {
        private Node currentIndex;

        public iteratorLinkedList() {
            currentIndex = head;
        }

        @Override
        public boolean hasNext() {
            return currentIndex.next != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T result = currentIndex.value;
                currentIndex = currentIndex.next;
                return result;
            }
            throw new NoSuchElementException();
        }
    }

}
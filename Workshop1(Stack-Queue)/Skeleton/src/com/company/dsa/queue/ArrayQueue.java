package com.company.dsa.queue;

import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E> {
    private E[] items;
    private int head;
    private int tail;
    private int size;
    private final int maximumCapacity = 10;

    public ArrayQueue() {
        head = 0;
        tail = 0;
        size = 0;
        items = (E[]) new Object[maximumCapacity];
    }


    @Override
    public void enqueue(E element) {
        if (tail == maximumCapacity - 1) {
            E[] newArray = (E[]) new Object[maximumCapacity * 2];
            System.arraycopy(items, 0, newArray, 0, maximumCapacity * 2);
            items = newArray;
            items[tail] = element;
            size++;
            tail++;
        } else if (isEmpty()) {
            items[tail] = element;
            size++;
            tail++;
        } else {
            items[tail] = element;
            size++;
            tail++;
        }
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            E deletedItem = items[head];
            head++;
            return deletedItem;
        }
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return items[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}

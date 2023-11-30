package com.company.dsa.stack;

import java.util.NoSuchElementException;


public class ArrayStack<E> implements Stack<E> {

    private E[] items;
    private int top;
    private final int maxSize = 10;

    public ArrayStack() {
        items = (E[]) new Object[maxSize];
    }

    @Override
    public void push(E element) {
        if (top == maxSize - 1) {
            E[] newArray = (E[]) new Object[maxSize * 2];
            System.arraycopy(items, 0, newArray, 0, maxSize * 2);
            items = newArray;
        }
        top++;
        items[top] = element;
    }

    @Override
    public E pop() {
        if (!isEmpty()) {
            E poppedElement = items[top];
            top--;
            return poppedElement;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return items[top];
    }

    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return top;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }
}


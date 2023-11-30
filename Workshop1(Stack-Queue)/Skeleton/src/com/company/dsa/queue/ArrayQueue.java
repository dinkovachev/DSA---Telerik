package com.company.dsa.queue;

public class ArrayQueue<E> implements Queue<E> {
    private E[] items;
    private int head, tail, size;

    public ArrayQueue(){
        head = 0;
        tail = 0;
        size = 0;
        items = (E[]) new Object[size];
    }


    @Override
    public void enqueue(E element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E dequeue() {
        throw new UnsupportedOperationException();
    }

    @Override
    public E peek() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

}

package com.company.dsa.stack;

import com.company.dsa.Node;

import java.util.NoSuchElementException;

public class LinkedStack<E> implements Stack<E> {

    private Node<E> top;
    private int size;


    public LinkedStack() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public void push(E element) {
        if (top == null) {
            top = new Node<>();
            top.data = element;
            top.next = null;
        } else {
            Node<E> tempNode = new Node<>();
            tempNode.data = element;
            tempNode.next = top;
            top = tempNode;
        }
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E temp = top.data;
        top = top.next;
        size--;
        return temp;
    }

    @Override
    public E peek() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return top.data;
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

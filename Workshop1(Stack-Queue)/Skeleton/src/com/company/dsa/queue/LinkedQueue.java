package com.company.dsa.queue;

import com.company.dsa.Node;

import java.util.NoSuchElementException;

public class LinkedQueue<E> implements Queue<E> {
    private Node<E> head, tail;
    private int size;

    public LinkedQueue(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    @Override
    public void enqueue(E element) {
        if (tail == null){
            tail = new Node<>();
            tail.data = element;
            tail.next = null;
            head = tail;
        } else {
            Node<E> tempNode = new Node<>();
            tempNode.data = element;
            tempNode.next = null;
            tail = tempNode;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (head == null){
            throw new NoSuchElementException();
        } else {
            E tempNode = head.data;
            head = head.next;
            size--;
            return tempNode;
        }
    }

    @Override
    public E peek() {
        if (head==null){
            throw new NoSuchElementException();
        }
        return head.data;
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

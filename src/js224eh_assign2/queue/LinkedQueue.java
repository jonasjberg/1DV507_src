// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 2: Data Structures, JUnit, and JavaFX1
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-02-06.

package js224eh_assign2.queue;


import java.util.Iterator;


public class LinkedQueue implements Queue
{
    private static final int QUEUE_INITIAL_SIZE = 4;
    private static final int QUEUE_RESIZE_INCREMENT = 8;

    private int size;
    private Node head;
    private Node tail;

    public LinkedQueue()
    {
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * Resizes the queue in order to accommodate additional elements.
     *
     *
     */
    private void resize()
    {
        /* TODO: Implement .. */
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        return head == null;
    }

    @Override
    public void enqueue(Object element)
    {
        Node newNode = new Node(element);

        /* If the queue is empty, both head and tail point to the single new
         * Node "newNode". Otherwise, update the "next" pointer in the tail to
         * point at the new Node "newNode", then let the new node be the
         * tail itself.
         */
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    @Override
    public Object dequeue()
    {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("The queue is empty");
        }

        Object returnValue = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }

        size--;
        return returnValue;
    }

    @Override
    public Object first()
    {
        Object first = null;
        boolean foundFirst = false;

        do {




        } while (!foundFirst);

        return first;
    }

    @Override
    public Object last()
    {
        /* TODO: Implement .. */
        return null;
    }

    @java.lang.Override
    public String toString()
    {
        return null;
    }

    @Override
    public Iterator<Object> iterator()
    {
        /* TODO: Implement .. */
        return null;
    }

    class Node {
        Object data;
        Node next;

        public Node(Object data)
        {
            this.data = data;
            next = null;
        }
    }
}

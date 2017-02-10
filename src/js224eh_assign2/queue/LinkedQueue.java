// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 2: Data Structures, JUnit, and JavaFX1
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-02-06.

package js224eh_assign2.queue;


import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedQueue implements Queue
{
    /* Number of elements in the queue. */
    private int  size;

    /* The first element in the queue. */
    private Node head;

    /* The last element in the queue. */
    private Node tail;

    /**
     * Instantiates a new instance of the "LinkedQueue" class.
     */
    public LinkedQueue()
    {
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * Gets the current size of the queue, I.E. the number of enqueued elements.
     *
     * @return The number of elements stored in this queue.
     */
    @Override
    public int size()
    {
        return size;
    }

    /**
     * Returns whether the queue is empty or not.
     *
     * @return True if this queue is empty, otherwise False.
     */
    @Override
    public boolean isEmpty()
    {
        return head == null;
    }

    /**
     * Adds an element to the queue. The element is added to the back of
     * the queue; FIFO -- First In First Out.
     *
     * @param element The element to add to this queue.
     */
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

    /**
     * Removes an element from the queue. The element that was enqueued first
     * is returned; FIFO -- First In First Out.
     *
     * @return The next element in line in this queue.
     */
    @Override
    public Object dequeue()
    {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Queue underflow (is empty)");
        }

        Object returnValue = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }

        size--;
        return returnValue;
    }

    /**
     * Returns the first element of the queue, without removing it.
     *
     * @return The first element in this queue.
     */
    @Override
    public Object first()
    {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("The queue is empty");
        }

        return head.data;
    }

    /**
     * Returns the last element of the queue, without removing it.
     *
     * @return The last element in this queue.
     */
    @Override
    public Object last()
    {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("The queue is empty");
        }

        return tail.data;
    }

    /**
     * Returns a human readable textual representation of the queue.
     *
     * @return A string representation of this queue.
     */
    @java.lang.Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("[ ");


        return sb.append("]").toString();
    }

    /**
     * Returns an element iterator for the queue.
     *
     * @return An element iterator for this queue.
     */
    @Override
    public Iterator<Object> iterator()
    {
        return new LinkedQueueIterator();
    }

    private class LinkedQueueIterator implements Iterator<Object> {
        private Node current = head;

        @Override
        public boolean hasNext(){
            return current != null;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Object data = current.data;
            current = current.next;
            return data;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


    /**
     * Class Node holds an entry in the queue as well as a pointer to the
     * following queue entry.
     */
    class Node {
        Object data;
        Node next;

        /**
         * Creates a new queue Node containing the Object "data".
         *
         * @param data The data contained within this node.
         */
        Node(Object data)
        {
            this.data = data;
            next = null;
        }
    }
}

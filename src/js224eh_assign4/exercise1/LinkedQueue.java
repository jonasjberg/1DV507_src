// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 4: Generic Classes and More Algorithms
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-15.

/*
 * Exercise 1
 * ==========
 */
package js224eh_assign4.exercise1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<T> implements Queue<T> {
    /* Number of elements in the queue. */
    private int size;

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
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Adds an element to the queue. The element is added to the back of
     * the queue; FIFO -- First In First Out.
     *
     * @param element The element to add to this queue.
     */
    @Override
    public void enqueue(T element) {
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
    public T dequeue() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Queue underflow (is empty)");
        }

        T returnValue = head.data;
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
    public T first() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Queue underflow (is empty)");
        }

        return head.data;
    }

    /**
     * Returns the last element of the queue, without removing it.
     *
     * @return The last element in this queue.
     */
    @Override
    public T last() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Queue underflow (is empty)");
        }

        return tail.data;
    }

    /**
     * Returns an element iterator for the queue.
     *
     * @return An element iterator for this queue.
     */
    @Override
    public Iterator<T> iterator() {
        return new QueueIterator<T>(head);
    }

    private class QueueIterator<X> implements Iterator<X> {
        private int count = 0;
        private Node current;

        public QueueIterator(Node head) {
            current = head;
        }

        @Override
        public boolean hasNext()
        {
            return current != null;
        }

        @Override
        public X next()
        {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            X data = (X) current.data;
            current = current.next;
            return data;
        }

        @Override
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Returns a human readable textual representation of the queue.
     *
     * @return A string representation of this queue.
     */
    @java.lang.Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        Iterator<T> iterator = iterator();

        if (!iterator.hasNext()) {
            sb.append("(empty)");
        } else {
            while (iterator.hasNext()) {
                Object o = iterator.next();
                sb.append("[").append(o).append("] ");
            }
        }

        return sb.toString();
    }

    /**
     * Class Node holds an entry in the queue as well as a pointer to the
     * following queue entry.
     */
    class Node
    {
        T data;
        Node   next;

        /**
         * Creates a new queue Node containing the Object "data".
         *
         * @param data The data contained within this node.
         */
        Node(T data)
        {
            this.data = data;
            next = null;
        }
    }
}

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

    private Object[] elements;
    private int size;

    public LinkedQueue()
    {
        elements = new Object[QUEUE_INITIAL_SIZE];
        size = 0;
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
        return size == 0;
    }

    @Override
    public void enqueue(Object element)
    {
        /* TODO: Implement .. */
    }

    @Override
    public Object dequeue()
    {
        /* TODO: Implement .. */
        return null;
    }

    @Override
    public Object first()
    {
        /* TODO: Implement .. */
        return null;
    }

    @Override
    public Object last()
    {
        /* TODO: Implement .. */
        return null;
    }

    @Override
    public Iterator<Object> iterator()
    {
        /* TODO: Implement .. */
        return null;
    }
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 2: Data Structures, JUnit, and JavaFX1
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-02-09.

// Exercise 1

package js224eh_assign2.queue;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;


/**
 * Created by Jonas Sjöberg (js224eh) on 2017-02-09.
 */
public class LinkedQueueTest
{
    private LinkedQueue queue;

    @Before
    public void setUp() throws Exception
    {
        queue = new LinkedQueue();
    }

    @After
    public void tearDown() throws Exception { }

    @Test
    public void testSize() throws Exception
    {
        assertEquals(0, queue.size());

        queue.enqueue(new Object());
        assertEquals(1, queue.size());

        queue.enqueue(new Object());
        queue.enqueue(new Object());
        queue.enqueue(new Object());
        assertEquals(4, queue.size());
    }

    @Test
    public void testIsEmpty() throws Exception
    {
        assertTrue(queue.isEmpty());

        queue.enqueue(new Object());
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testEnqueue() throws Exception
    {
        queue.enqueue("Object 1");
        assertEquals("Object 1", queue.first());

        queue.enqueue("Object 2");
        queue.enqueue("Object 3");
        assertEquals("Object 1", queue.first());
        assertEquals("Object 3", queue.last());
    }

    @Test
    public void testDequeue() throws Exception
    {
        queue.enqueue("Object 1");

        Object o1 = queue.dequeue();
        assertEquals(o1, "Object 1");

        queue.enqueue("Object 2");
        queue.enqueue("Object 3");
        queue.enqueue("Object 4");

        Object o2 = queue.dequeue();
        Object o3 = queue.dequeue();
        assertEquals(o2, "Object 2");
        assertEquals(o3, "Object 3");

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testFirst() throws Exception
    {
        queue.enqueue("Object 1");
        assertEquals("Object 1", queue.first());

        queue.enqueue("Object 2");
        queue.enqueue("Object 3");
        assertEquals("Object 1", queue.first());
    }

    @Test
    public void testLast() throws Exception
    {
        queue.enqueue("Object 1");
        assertEquals("Object 1", queue.last());

        queue.enqueue("Object 2");
        assertEquals("Object 2", queue.last());

        queue.enqueue("Object 3");
        assertEquals("Object 3", queue.last());

        queue.dequeue();
        assertEquals("Object 3", queue.last());
    }

    @Test
    public void testToString() throws Exception
    {
        queue.enqueue("object 1");
        queue.enqueue("object 2");
        queue.enqueue("object 3");

        String expect = "[object 1] [object 2] [object 3] ";
        assertEquals(expect, queue.toString());
    }

    @Test
    public void testIterator() throws Exception
    {
        Iterator<Object> iterator = queue.iterator();
        assertFalse(iterator.hasNext());

        boolean threwException = false;
        try {
            iterator.next();
        } catch (NoSuchElementException e) {
            threwException = true;
        }
        assertTrue(threwException);

        queue.enqueue("Object 1");
        iterator = queue.iterator();
        assertTrue(iterator.hasNext());

        assertEquals("Object 1", iterator.next());
    }
}
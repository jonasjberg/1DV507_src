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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class QueueTest {
    final static double DELTA = 0.001;

    private LinkedQueue<String> stringLinkedQueue;
    private LinkedQueue<Integer> integerLinkedQueue;

    @Before
    public void setUp() throws Exception {
        stringLinkedQueue = new LinkedQueue<>();
        integerLinkedQueue = new LinkedQueue<>();
    }

    @After
    public void tearDown() throws Exception {
        stringLinkedQueue = null;
        integerLinkedQueue = null;
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(0, stringLinkedQueue.size());
        assertEquals(0, integerLinkedQueue.size());

        stringLinkedQueue.enqueue("MJAO");
        integerLinkedQueue.enqueue(42);
        assertEquals(1, stringLinkedQueue.size());
        assertEquals(1, integerLinkedQueue.size());

        stringLinkedQueue.enqueue("oajmmjao");
        integerLinkedQueue.enqueue(24);
        assertEquals(2, stringLinkedQueue.size());
        assertEquals(2, integerLinkedQueue.size());

        stringLinkedQueue.dequeue();
        integerLinkedQueue.dequeue();
        assertEquals(1, stringLinkedQueue.size());
        assertEquals(1, integerLinkedQueue.size());

        stringLinkedQueue.dequeue();
        integerLinkedQueue.dequeue();
        assertEquals(0, stringLinkedQueue.size());
        assertEquals(0, integerLinkedQueue.size());
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertTrue(stringLinkedQueue.isEmpty());
        assertTrue(integerLinkedQueue.isEmpty());

        stringLinkedQueue.enqueue("MJAO");
        integerLinkedQueue.enqueue(42);
        assertFalse(stringLinkedQueue.isEmpty());
        assertFalse(integerLinkedQueue.isEmpty());

        stringLinkedQueue.dequeue();
        integerLinkedQueue.dequeue();
        assertTrue(stringLinkedQueue.isEmpty());
        assertTrue(integerLinkedQueue.isEmpty());
    }

    @Test
    public void testEnqueue() throws Exception {
        stringLinkedQueue.enqueue("Object 1");
        assertEquals("Object 1", stringLinkedQueue.first());

        stringLinkedQueue.enqueue("Object 2");
        stringLinkedQueue.enqueue("Object 3");
        assertEquals("Object 1", stringLinkedQueue.first());
        assertEquals("Object 3", stringLinkedQueue.last());

        integerLinkedQueue.enqueue(42);
        assertEquals(42, integerLinkedQueue.first(), DELTA);

        integerLinkedQueue.enqueue(420);
        integerLinkedQueue.enqueue(667);
        assertEquals(42, integerLinkedQueue.first(), DELTA);
        assertEquals(667, integerLinkedQueue.last(), DELTA);
    }

    @Test
    public void testDequeue() throws Exception {
        stringLinkedQueue.enqueue("Object 1");

        Object o1 = stringLinkedQueue.dequeue();
        assertEquals(o1, "Object 1");

        stringLinkedQueue.enqueue("Object 2");
        stringLinkedQueue.enqueue("Object 3");
        stringLinkedQueue.enqueue("Object 4");

        Object o2 = stringLinkedQueue.dequeue();
        Object o3 = stringLinkedQueue.dequeue();
        assertEquals(o2, "Object 2");
        assertEquals(o3, "Object 3");

        stringLinkedQueue.dequeue();
        assertTrue(stringLinkedQueue.isEmpty());

        integerLinkedQueue.enqueue(42);

        Integer i1 = integerLinkedQueue.dequeue();
        assertEquals(i1, 42, DELTA);

        integerLinkedQueue.enqueue(10);
        integerLinkedQueue.enqueue(20);
        integerLinkedQueue.enqueue(30);

        Integer i2 = integerLinkedQueue.dequeue();
        Integer i3 = integerLinkedQueue.dequeue();
        assertEquals(i2, 10, DELTA);
        assertEquals(i3, 20, DELTA);

        integerLinkedQueue.dequeue();
        assertTrue(integerLinkedQueue.isEmpty());
    }

    @Test
    public void testFirst() throws Exception {
        stringLinkedQueue.enqueue("Object 1");
        assertEquals("Object 1", stringLinkedQueue.first());

        stringLinkedQueue.enqueue("Object 2");
        stringLinkedQueue.enqueue("Object 3");
        assertEquals("Object 1", stringLinkedQueue.first());

        integerLinkedQueue.enqueue(11);
        assertEquals(11, integerLinkedQueue.first(), DELTA);

        integerLinkedQueue.enqueue(22);
        integerLinkedQueue.enqueue(33);
        assertEquals(11, integerLinkedQueue.first(), DELTA);
    }

    @Test
    public void testLast() throws Exception {
        stringLinkedQueue.enqueue("Object 1");
        assertEquals("Object 1", stringLinkedQueue.last());

        stringLinkedQueue.enqueue("Object 2");
        assertEquals("Object 2", stringLinkedQueue.last());

        stringLinkedQueue.enqueue("Object 3");
        assertEquals("Object 3", stringLinkedQueue.last());

        stringLinkedQueue.dequeue();
        assertEquals("Object 3", stringLinkedQueue.last());

        integerLinkedQueue.enqueue(111);
        assertEquals(111, integerLinkedQueue.last(), DELTA);

        integerLinkedQueue.enqueue(222);
        assertEquals(222, integerLinkedQueue.last(), DELTA);

        integerLinkedQueue.enqueue(333);
        assertEquals(333, integerLinkedQueue.last(), DELTA);

        integerLinkedQueue.dequeue();
        assertEquals(333, integerLinkedQueue.last(), DELTA);
    }

    @Test
    public void testIterator() throws Exception {
        Iterator<String> stringIterator = stringLinkedQueue.iterator();
        assertFalse(stringIterator.hasNext());

        boolean stringThrewException = false;
        try {
            stringIterator.next();
        } catch (NoSuchElementException e) {
            stringThrewException = true;
        }
        assertTrue(stringThrewException);

        stringLinkedQueue.enqueue("Object 1");
        stringIterator = stringLinkedQueue.iterator();
        assertTrue(stringIterator.hasNext());

        assertEquals("Object 1", stringIterator.next());

        Iterator<Integer> intIterator = integerLinkedQueue.iterator();
        assertFalse(intIterator.hasNext());

        boolean intThrewException = false;
        try {
            intIterator.next();
        } catch (NoSuchElementException e) {
            intThrewException = true;
        }
        assertTrue(intThrewException);

        integerLinkedQueue.enqueue(42);
        intIterator = integerLinkedQueue.iterator();
        assertTrue(intIterator.hasNext());

        assertEquals(42, intIterator.next(), DELTA);
    }

    @Test
    public void testToString() throws Exception {
        stringLinkedQueue.enqueue("object 1");
        stringLinkedQueue.enqueue("object 2");
        stringLinkedQueue.enqueue("object 3");

        String expectStrStr = "[object 1] [object 2] [object 3] ";
        assertEquals(expectStrStr, stringLinkedQueue.toString());

        integerLinkedQueue.enqueue(1);
        integerLinkedQueue.enqueue(42);
        integerLinkedQueue.enqueue(3);

        String expectIntStr = "[1] [42] [3] ";
        assertEquals(expectIntStr, integerLinkedQueue.toString());
    }

}
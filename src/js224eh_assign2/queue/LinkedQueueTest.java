package js224eh_assign2.queue;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

    }

    @Test
    public void testDequeue() throws Exception
    {

    }

    @Test
    public void testFirst() throws Exception
    {

    }

    @Test
    public void testLast() throws Exception
    {

    }

    @Test
    public void testToString() throws Exception
    {

    }

    @Test
    public void testIterator() throws Exception
    {

    }
}
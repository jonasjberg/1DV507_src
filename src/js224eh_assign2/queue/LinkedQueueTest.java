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
    public void size() throws Exception
    {
        assertEquals(0, queue.size());

        String o1 = "object1";
        queue.enqueue(o1);
        assertEquals(1, queue.size());
    }

    @Test
    public void isEmpty() throws Exception
    {

    }

    @Test
    public void enqueue() throws Exception
    {

    }

    @Test
    public void dequeue() throws Exception
    {

    }

    @Test
    public void first() throws Exception
    {

    }

    @Test
    public void last() throws Exception
    {

    }

    @Test
    public void toString() throws Exception
    {

    }

    @Test
    public void iterator() throws Exception
    {

    }
}
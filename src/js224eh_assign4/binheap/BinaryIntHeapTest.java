// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 4: Generic Classes and More Algorithms
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-20.

package js224eh_assign4.binheap;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryIntHeapTest
{
    private BinaryIntHeap binaryIntHeap;
    private final int[] ARRAY_1 = new int[] { -1, -2, 2, 42, 13, -4, -2, 4 };

    @Before
    public void setUp() throws Exception
    {
        binaryIntHeap = new BinaryIntHeap();
    }

    @After
    public void tearDown() throws Exception
    {
        binaryIntHeap = null;
    }

    @Test
    public void testInsert() throws Exception
    {

    }

    @Test
    public void testPullHighest() throws Exception
    {

    }

    @Test
    public void testSize() throws Exception
    {
        assertEquals(0, binaryIntHeap.size());

        binaryIntHeap.insert(1);
        assertEquals(1, binaryIntHeap.size());

        binaryIntHeap.insert(2);
        assertEquals(2, binaryIntHeap.size());
    }

    @Test
    public void testIsEmpty() throws Exception
    {

    }
}
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 3: Algorithms, Hashing/BSTs and GUI #2
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-01.

// Exercise 2

package js224eh_assign3;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


import static org.junit.Assert.*;

public class SortTest {
    private int[] unsortedIntArray = { 6, -7, 9, -12, -2, 5 };
    private int[] sortedIntArray = { -12, -7, -2, 5, 6, 9 };
    SortingAlgorithms sortingAlgorithms;

    @Before
    public void setUp() throws Exception {
        sortingAlgorithms = new SortingAlgorithms();
    }

    @After
    public void tearDown() throws Exception {
        sortingAlgorithms = null;
    }

    @Test
    public void testIntInsertionSort() throws Exception {
        int[] actual = sortingAlgorithms.insertionSort(unsortedIntArray);
        assertArrayEquals(sortedIntArray, actual);
    }

    @Test
    @Ignore
    public void testIntMergeSort() throws Exception {
        // TODO: Add integer merge sort test.
    }

    @Test
    @Ignore
    public void testStringInsertionSort() throws Exception {
        // TODO: Add string insertion sort test.
    }

    @Test
    @Ignore
    public void testStringMergeSort() throws Exception {
        // TODO: Add string merge sort test.
    }

}
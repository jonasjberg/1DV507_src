// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 3: Algorithms, Hashing/BSTs and GUI #2
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-01.

// Exercise 2

package js224eh_assign3.sort;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.*;

public class SortTest {
    private final int[] TEST_ARRAY_1_PRE = { 6, -7, 9, -12, -2, 5 };
    private final int[] TEST_ARRAY_1_POST = { -12, -7, -2, 5, 6, 9 };
    private final String[] TEST_ARRAY_2_PRE = { "cat", "katt", "a", "b", "c" };
    private final String[] TEST_ARRAY_2_POST = { "a", "b", "c", "cat", "katt" };

    private int[] unsortedIntArray;
    private int[] sortedIntArray;
    private String[] unsortedStringArray;
    private String[] sortedStringArray;

    SortingAlgorithms sortingAlgorithms;

    @Before
    public void setUp() throws Exception {
        sortingAlgorithms = new SortingAlgorithms();

        unsortedIntArray = Arrays.copyOf(TEST_ARRAY_1_PRE, TEST_ARRAY_1_PRE.length);
        sortedIntArray = Arrays.copyOf(TEST_ARRAY_1_POST, TEST_ARRAY_1_POST.length);

        unsortedStringArray = Arrays.copyOf(TEST_ARRAY_2_PRE, TEST_ARRAY_2_PRE.length);
        sortedStringArray = Arrays.copyOf(TEST_ARRAY_2_POST, TEST_ARRAY_2_POST.length);
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
    public void testIntMergeSort() throws Exception {
        int[] actual = sortingAlgorithms.mergeSort(unsortedIntArray);
        assertArrayEquals(sortedIntArray, actual);
    }

    @Test
    public void testStringInsertionSort() throws Exception {
        final Comparator<String> c =  (s1, s2) -> s2.length() - s1.length();

        String[] actual = sortingAlgorithms.insertionSort(unsortedStringArray, c);
        assertArrayEquals(sortedStringArray, actual);
    }

    @Test
    public void testStringMergeSort() throws Exception {
        final Comparator<String> c =  (s1, s2) -> s2.length() - s1.length();

        String[] actual = sortingAlgorithms.mergeSort(unsortedStringArray, c);
        assertArrayEquals(sortedStringArray, actual);
    }

}
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 3: Algorithms, Hashing/BSTs and GUI #2
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-01.

// Exercise 4
// ==========

package js224eh_assign3.count_words;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class TestWord
{
    private Word wordOne;
    private Word wordTwo;
    private Word wordThree;

    @Before
    public void setUp() throws Exception
    {
        wordOne = new Word("History");
        wordTwo = new Word("programming");
        wordThree = new Word("history");

    }

    @After
    public void tearDown() throws Exception { }

    @Test
    public void testGetNormalizedString() throws Exception
    {
        assertEquals("history", wordOne.getNormalizedString());
        assertEquals("programming", wordTwo.getNormalizedString());
    }

    @Test
    public void testToString() throws Exception
    {
        assertEquals("History", wordOne.toString());
        assertEquals("programming", wordTwo.toString());
    }

    @Test
    public void testHashCode() throws Exception
    {
        // TODO: Implement test (?)
    }

    @Test
    public void testEquals() throws Exception
    {
        assertFalse(wordOne.equals(wordTwo));
        assertTrue(wordOne.equals(wordThree));
    }

    @Test
    public void testCompareTo() throws Exception
    {
        // TODO: Implement test ..
    }
}
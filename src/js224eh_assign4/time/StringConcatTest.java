// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 4: Generic Classes and More Algorithms
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-16.

package js224eh_assign4.time;

/**
 * Created by jonas on 2017-03-16.
 */
public class StringConcatTest {
    final static String SHORT_STRING = "a";
    final static String LONG_STRING = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

    private long startTime;
    private long stopTime;
    private long estimatedTime;
    private boolean running;

    public StringConcatTest()
    {

    }

    public void testConcatShortStrings()
    {
        startTime = System.nanoTime();

        stopTime = System.nanoTime();
        running = false;
        estimatedTime = stopTime - startTime;

        // Get number of concatenations and final string length when concatenating short strings.
        // Get number of concatenations and final string length when concatenating long strings.
        // Get number of concatenations and final string length when appending short strings.
        // Get number of concatenations and final string length when appending long strings.
    }
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 4: Generic Classes and More Algorithms
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-16.

package js224eh_assign4.time;

/*
 * Exercise 2
 * ==========
 * Repeated string concatenations can be done in two ways:
 *
 * 1. Using the plus operator you can construct a long string by constantly
 *    increasing the length as: `str = str + "..."`
 * 2. Using the `StringBuilder` class and repeated use of method `append("...").`
 *
 * Your task is to find the fastest approach by measuring how many concatenations,
 * and the length of the final string, each of them can compute in 1 second when:
 *
 * 1. Adding short strings containg only one character
 * 2. Adding long strings representing a row with 80 characters
 *
 * __Notice 1:__ We are interested in eight different numbers. The number of
 * concatenations, and the final string length when:
 *
 * 1. Concatenating short strings,
 * 2. Concatenating long string,
 * 3. Appending short strings, and
 * 4. Appending long strings.
 *
 * Make sure to include the final `toString()` call when measuring the time for
 * the `StringBuilder` approach.
 *
 * __Notice 2:__ Trustworthy experiments using computers is not based on a single
 * testConcatShortStrings of the program. Use repeated runs (say 5) having an average of about 1
 * second.

 */

public class StringConcatMain
{
    static StringConcatTest stringConcatTest = new StringConcatTest();

    public static void main(String[] args)
    {
        // TODO: Implement ..

        // Get number of concatenations and final string length when concatenating short strings.
        // Get number of concatenations and final string length when concatenating long strings.
        // Get number of concatenations and final string length when appending short strings.
        // Get number of concatenations and final string length when appending long strings.

        stringConcatTest.testConcatShortStrings();
    }
}

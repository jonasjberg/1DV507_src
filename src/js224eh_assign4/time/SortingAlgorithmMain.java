// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 4: Generic Classes and More Algorithms
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-20.

package js224eh_assign4.time;

/*
 * Exercise 3
 * ==========
 * (50% VG Exercise)
 * In Assignment 3 you implemented 4 different sorting algorithms:
 *   Insertion Sort (for both strings and integers) and
 *   Merge Sort (for both strings and integers).
 *
 * How many strings and integers can be sorted in 1 second using these four
 * algorithms?
 *
 * For integers: Sort arrays with random generated integers. The range used by
 *               the random generator should be larger than the array size in
 *               order to reduce the number of duplicate elements.
 *
 * For strings: Sort arrays in alphabetic order using arrays of random
 *              generated strings where each string contains 10 randomly
 *              generated characters.
 *
 * Notice: Handling Merge Sort is a VG Exercise
 *         (since implementing it was a VG Exercise in Assignment 3)
 */

public class SortingAlgorithmMain
{
    static SortingAlgorithmTest sortingAlgorithmTest = new SortingAlgorithmTest();

    public static void main(String[] args)
    {
        //sortingAlgorithmTest.testStringInsertionSort();

        sortingAlgorithmTest.testIntegerInsertionSort();
    }
}

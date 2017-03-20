// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 4: Generic Classes and More Algorithms
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-20.

package js224eh_assign4.time;


import static js224eh_assign4.time.TestUtils.getRandomStringArray;


public class SortingAlgorithmTest
{
    final static int NUMBER_TEST_RUNS = 5;
    final static int STRING_CHAR_COUNT = 10;

    public void testStringInsertionSort()
    {
        /* Sort arrays in alphabetic order using arrays of random generated
         * strings where each string contains 10 randomly generated characters.
         */

        String[] strArr = getRandomStringArray(5, STRING_CHAR_COUNT);
        for (String s : strArr) {
            System.out.println(s);
        }

    }

    public void testIntegerInsertionSort()
    {
        /* Sort arrays with randomly generated strings.
         * The range used by the random generator should be larger than the
         * array size in order to reduce the number of duplicate elements.
         */
    }

    public void testStringMergeSort()
    {
        /* Sort arrays in alphabetic order using arrays of random generated
         * strings where each string contains 10 randomly generated characters.
         */

    }

    public void testIntegerMergeSort()
    {
        /* Sort arrays with randomly generated strings.
         * The range used by the random generator should be larger than the
         * array size in order to reduce the number of duplicate elements.
         */
    }
}

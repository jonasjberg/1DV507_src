// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 4: Generic Classes and More Algorithms
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-20.

package js224eh_assign4.time;


import js224eh_assign3.sort.SortingAlgorithms;

import java.util.Comparator;

import static js224eh_assign4.time.TestUtils.getRandomIntegerArray;
import static js224eh_assign4.time.TestUtils.getRandomStringArray;
import static js224eh_assign4.time.TestUtils.printTestStatusMessage;


public class SortingAlgorithmTest
{
    final static int NUMBER_TEST_RUNS  = 5;
    final static int STRING_CHAR_COUNT = 10;

    /* Used by the insertion sort algorithm. */
    final Comparator<String> insComp = (s1, s2) -> s2.length() - s1.length();

    private Stopwatch stopwatch;
    private SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();

    public void testStringInsertionSort()
    {
        /* Sort arrays in alphabetic order using arrays of random generated
         * strings where each string contains 10 randomly generated characters.
         */

        double averageSortCount = 0;
        printTestStatusMessage("STARTING TEST", "String Insertion Sort");

        final int ELEMENT_COUNT = 5;
        for (int i = 0; i < NUMBER_TEST_RUNS; i++) {
            int sortCount = 0;

            stopwatch = new Stopwatch();
            stopwatch.start();
            do {
                String[] randomArray = getRandomStringArray(ELEMENT_COUNT,
                                                            STRING_CHAR_COUNT);
                String[] sorted = sortingAlgorithms.insertionSort(randomArray,
                                                                  insComp);
                sortCount++;
            } while (stopwatch.hasTimeLeft());

            averageSortCount += sortCount;
        }

        averageSortCount /= NUMBER_TEST_RUNS;
        printTestStatusMessage("", "Average number of completed sorts: " + averageSortCount);
        printTestStatusMessage("FINISHED TEST", "String Insertion Sort");
    }

    public void testIntegerInsertionSort()
    {
        /* Sort arrays with random generated integers. The range used by the
         * random generator should be larger than the array size in order to
         * reduce the number of duplicate elements. */

        for (int e = 10; e <= 1000; e += 10) {
            double averageSortCount = 0;
            printTestStatusMessage("STARTING TEST", "Integer Insertion Sort of " + e + " elements");

            final int elementCount = 10;
            for (int i = 0; i < NUMBER_TEST_RUNS; i++) {
                int sortCount = 0;

                stopwatch = new Stopwatch();
                stopwatch.start();
                do {
                    int[] randomArray = getRandomIntegerArray(elementCount,
                                                              elementCount * 2);
                    int[] sorted = sortingAlgorithms.insertionSort(randomArray);
                    sortCount++;
                } while (stopwatch.hasTimeLeft());

                averageSortCount += sortCount;
            }

            averageSortCount /= NUMBER_TEST_RUNS;
            printTestStatusMessage("", "Average number of completed sorts: " + averageSortCount);
            printTestStatusMessage("FINISHED TEST", "Integer Insertion Sort of " + e + " elements");
        }
    }

    public void testStringMergeSort()
    {
        /* Sort arrays in alphabetic order using arrays of random generated
         * strings where each string contains 10 randomly generated characters.
         */

    }

    public void testIntegerMergeSort()
    {
        /* Sort arrays with random generated integers. The range used by the
         * random generator should be larger than the array size in order to
         * reduce the number of duplicate elements. */
    }
}

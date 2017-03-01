// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 3: Algorithms, Hashing/BSTs and GUI #2
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-01.

package js224eh_assign3;

import java.util.Arrays;

/**
 * Sorts an array of integers with the "merge sort" algorithm.
 * <p>
 * This code is based on the example implementation in
 * "Big Java, Late Objects 4th Edition" by C. Horstmann (Wiley, 2010), page 646.
 * Some of the comments are also lifted as-is, some with modifications.
 *
 * This class sorts an array, using the merge sort algorithm.
 */
public class MergeSorter {
    private int[] a;

    /**
     * Constructs a merge sorter.
     *
     * @param anArray The array to sort.
     */
    public MergeSorter(int[] anArray)
    {
        a = anArray;
    }

    public int[] getA()
    {
        return a;
    }

    public void sort()
    {
        if (a.length <= 1) {
            return;
        }

        int[] first = new int[a.length / 2];
        int[] second = new int[a.length - first.length];

        /* Copy the first half of "intArray" into "first",
         * the second half into "second".
         */
        for (int i = 0; i < first.length; i++) {
            first[i] = a[i];
        }
        for (int i = 0; i < second.length; i++) {
            second[i] = a[first.length + i];
        }

        MergeSorter firstSorter = new MergeSorter(first);
        MergeSorter secondSorter = new MergeSorter(second);
        firstSorter.sort();
        secondSorter.sort();
        merge(first, second);
    }

    /**
     * Merges two sorted arrays into the array managed by this merge sorter.
     *
     * @param first  The first sorted array.
     * @param second The second sorted array.
     */
    private void merge(int[] first, int[] second) {
        int iFirst = 0;  // Next element to consider in the first array.
        int iSecond = 0; // Next element to consider in the second array.
        int j = 0;       // Next open position in "intArray".

        /* As long as neither "iFirst" nor "iSecond" passed the end,
         * move the smaller element into "intArray".
         */
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                a[j] = first[iFirst];
                iFirst++;
            } else {
                a[j] = second[iSecond];
                iSecond++;
            }

            j++;

            /* Note that only of of the two loops below copies entries (due to the fact that either "iFirst" or "iSecond" must have reached the end in order to get here) */
            while (iFirst < first.length) {
                a[j] = first[iFirst];
                iFirst++;
                j++;
            }

            /* Copy any remaining entries of the second half. */
            while (iSecond < second.length) {
                a[j] = second[iSecond];
                iSecond++;
                j++;
            }
        }
    }
}

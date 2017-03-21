// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 3: Algorithms, Hashing/BSTs and GUI #2
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-01.

// Exercise 2
// ==========

package js224eh_assign3.sort;


import java.util.Comparator;

/**
 * Sorts an array of integers with the "merge sort" algorithm.
 * <p>
 * This code is based on the example implementation in
 * "Big Java, Late Objects 4th Edition" by C. Horstmann (Wiley, 2010), page 646.
 * Some of the comments are also lifted as-is, some with modifications.
 * <p>
 * This class sorts an array, using the merge sort algorithm.
 */
public class MergeSorter {

    /**
     * Sorts an array, using the "merge sort" algorithm.
     *
     * @param a The integer array to sort.
     */
    public static void sort(int[] a) {
        if (a.length <= 1) {
            return;
        }

        int[] first = new int[a.length / 2];
        int[] second = new int[a.length - first.length];

        // Copy the first half of "intArray" into "first", then
        // the second half into "second".
        for (int i = 0; i < first.length; i++) {
            first[i] = a[i];
        }
        for (int i = 0; i < second.length; i++) {
            second[i] = a[first.length + i];
        }

        sort(first);
        sort(second);
        merge(first, second, a);
    }

    /**
     * Merges two sorted arrays into an array.
     *
     * @param first  The first sorted array.
     * @param second The second sorted array.
     * @param a      The array into which to merge "first" and "second".
     */
    private static void merge(int[] first, int[] second, int[] a) {
        int iFirst = 0;  // Next element to consider in the first array.
        int iSecond = 0; // Next element to consider in the second array.
        int j = 0;       // Next open position in "a".

        // As long as neither "iFirst" nor "iSecond" passed the end,
        // move the smaller element into "a".
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                a[j] = first[iFirst];
                iFirst++;
            } else {
                a[j] = second[iSecond];
                iSecond++;
            }

            j++;
        }

        // Note that only of of the two loops below copies entries (due to the
        // fact that either "iFirst" or "iSecond" must have reached the end in
        // order to get here)
        while (iFirst < first.length) {
            a[j] = first[iFirst];
            iFirst++;
            j++;
        }

        // Copy any remaining entries of the second half.
        while (iSecond < second.length) {
            a[j] = second[iSecond];
            iSecond++;
            j++;
        }
    }

    /**
     * Merges two sorted arrays into an array.
     *
     * @param left  The left sorted array.
     * @param right The right sorted array.
     * @param out   The array into which to merge "left" and "right".
     */
    private static void merge(String[] out, String[] left, String[] right, Comparator<String> c) {
        int i = 0;  // Next element to consider in the left array.
        int j = 0; // Next element to consider in the right array.
        int k = 0;       // Next open position in "out".

        // As long as neither "i" nor "j" passed the end,
        // move the smaller element into "out".
        while (i < left.length && j < right.length) {
            if (c.compare(left[i], right[j]) < 0) {
                out[k++] = left[i++];
            } else {
                out[k++] = right[j++];
            }
        }

        // Note that only of of the two loops below copies entries (due to the
        // fact that either "i" or "j" must have reached the end in
        // order to get here)
        while (i < left.length) {
            out[k++] = left[i++];
        }

        // Copy any remaining entries of the right half.
        while (j < right.length) {
            out[k++] = right[j++];
        }
    }

    /**
     * Sorts an array, using the "merge sort" algorithm.
     *
     * @param in The String array to sort.
     */
    public static String[] sort(String[] in, Comparator<String> c) {
        if (in.length <= 1) {
            return in;
        }

        /* Split input array "in" into two parts, "left" and "right". */
        String[] left = new String[in.length / 2];
        String[] right = new String[in.length - left.length];

        for (int i = 0; i < left.length; i++) {
            left[i] = in[i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = in[left.length + i];
        }

        /* Perform recursive sorting. */
        left = sort(left, c);
        right = sort(right, c);

        merge(in, left, right, c);

        return in;
    }
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 3: Algorithms, Hashing/BSTs and GUI #2
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-01.

// Exercise 2
// ==========
// This exercise is about sorting arrays of integer and strings.
// Create one class SortingAlgorithms containing four static methods:
//
//   public int[] insertionSort(int[] in)
//   public int[] mergeSort(int[] in)                             // VG Exercise
//   public String[] insertionSort(String[] in, Comparator<String> c)
//   public String[] mergeSort(String[] in, Comparator<String> c) // VG Exercise
//
// All methods return a new sorted array where all elements are sorted in
// ascending order (lowest first) in the first two integer array methods, as
// defined by the Comparator in the final two String array methods. The input
// arrays in should not be changed. The methods should of course use the
// Insertion Sort and Merge Sort algorithms.
// 
// You should also provide a JUnit test class SortTest that tests each method.
//
// Notice:
//   * Our suggestion is that you start to implement (and test) the integer
//     versions.
//   * Both algorithms are described in the lecture slides and in the textbook
//     by Horstmann. You can also find plenty of information on the Internet.
//   * The textbook (and Internet) also describes how to implement these
//     algorithms (integer version) in Java. Feel free to take any such
//     implementation as your starting point. However, in this case you must
//     clearly state in your assignments submission which implementation you
//     have used. Provide a web site if you have taken it from the Internet.

package js224eh_assign3.sort;

import java.util.Arrays;
import java.util.Comparator;


public class SortingAlgorithms {

    /**
     * Sorts an array of integers with the "insertion sort" algorithm.
     * <p>
     * This code is based on the example implementation in
     * "Big Java, Late Objects" by C. Horstmann (Wiley, 2013), page 638.
     *
     * @param in The integer array to sort.
     * @return A sorted copy of the integer array "in".
     */
    public int[] insertionSort(int[] in) {
        int[] intArray = Arrays.copyOf(in, in.length);

        for (int i = 1; i < intArray.length; i++) {
            int next = intArray[i];

            // Move all larger elements up.
            int j = i;
            while (j > 0 && intArray[j - 1] > next) {
                intArray[j] = intArray[j - 1];
                j--;
            }

            //  Insert the element.
            intArray[j] = next;
        }

        return intArray;
    }

    /**
     * (VG Exercise)
     * Sorts an array of integers with the "merge sort" algorithm.
     * <p>
     * This code is based on the example implementation in
     * "Big Java, Late Objects 4th Edition" by C. Horstmann (Wiley, 2010), page 646.
     * "Big Java, Late Objects ?th Edition" by C. Horstmann (Wiley, 2013), page 640.
     * Some of the comments are also lifted as-is, some with modifications.
     *
     * @param in The integer array to sort.
     * @return A sorted copy of the integer array "in".
     */
    public int[] mergeSort(int[] in) {
        int[] inCopy = Arrays.copyOf(in, in.length);

        MergeSorter.sort(inCopy);
        return inCopy;
    }

    public String[] insertionSort(String[] in, Comparator<String> c) {
        // TODO: Implement insertionSort for string arrays.
        return null;
    }

    // VG Exercise
    public String[] mergeSort(String[] in, Comparator<String> c) {
        // TODO: Implement mergeSort for string arrays.
        return null;
    }

}

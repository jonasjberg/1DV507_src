// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 1: Inheritance, Recursion and Java 1.8
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-01-28.


/*
 * Exercise 3
 * ==========
 * Write a program SumMain, that includes a recursive method computing the sum
 * of the integers 1, 2, 3, ..., N.
 * The computation should be based on the following principle: the sum of the
 * integers from 1 to N is equal to the sum of the integers from 1 to N/2 added
 * with the sum of the integers from N/2+1 to N.
 * Is this a good solution strategy? Motivate your answer!
 */

package js224eh_assign1;


public class SumMain
{
    public static void main(String[] args)
    {
        int n = 3;

        int m = n / 2;
        int o = n / 2 + 1;

        System.out.printf("n: %d  n/2: %d  n/2+1: %d%n", n, m, o);

        System.out.println(recursiveSum(1, 1));
        System.out.println(recursiveSum(1, 2));
        System.out.println(recursiveSum(1, 3));
        System.out.println(recursiveSum(1, 4));
        System.out.println(recursiveSum(1, 5));
        System.out.println();
        System.out.println(recursiveSumTwo(1, 1));
        System.out.println(recursiveSumTwo(1, 2));
        System.out.println(recursiveSumTwo(1, 3));
        System.out.println(recursiveSumTwo(1, 4));
        System.out.println(recursiveSumTwo(1, 5));
    }

    /*
     *      sum [1..N]  =  sum [1 .. N/2]  +  sum [N/2+1 .. N]
     *
     *
     *      Full range, 1 to N:     1, 2, 3, 4, 5, 6, 7, 8, 9, 10
     *                              |                           |
     *                              1 ......................... N
     *
     *      Halved, with N = 6:     1, 2, 3, 4, 5, 6, 7, 8, 9, 10
     *                              |              |  |         |
     *                              1 .......... N/2  N/2+1 ... N
     *
     *      Gives:
     *          sum [1..6]  =  sum [1 .. 6/2]  +  sum [6/2+1 .. 6]
     *                      =  sum [1 .. 3]    +  sum [4 .. 6]
     *
     *      Recursion breaks down the terms:
     *          First term:
     *              sum [1..3]  =  sum [1 .. 3/2]  +  sum [3/2+1 .. 3]
     *                          =  sum [1 .. 1]    +  sum [2 .. 3]
     *          Second term:
     *              sum [4..6]  =  sum [1 .. 6/2]  +  sum [6/2+1 .. 6]
     *                          =  sum [1 .. 3]    +  sum [4 .. 6]
     *
     *
     *                              1,  2,  3,  4,  5,  6,  7,  8,  9,  10
     *                              |                   |   |            |
     *                              1 ............... N/2   N/2+1 ...... N
     *
     *                              1,  2,  3,  4,  5,  6,  7,  8,  9,   10
     *                              |       |   |       |   |   |   |     |
     *                              1 ... N/2   N/2+1 . N   1 N/2   N/2+1 N
     *
     *     1,      2,     3,     4,      5,     6,     7,      8,     9,     10
     *     |   |   |      |      |   |   |      |      |   |   |      |
     *     1 N/2   N/2+1  N      1 N/2   N/2+1  N      1 N/2   N/2+1  N
     *
     *
     */
    private static int recursiveSum(int rangeLow, int rangeHigh)
    {
        if (rangeHigh > rangeLow) {
            return rangeHigh + recursiveSum(rangeLow, rangeHigh - 1);
        }

        if (rangeHigh < rangeLow) {
            return rangeLow + recursiveSum(rangeHigh, rangeLow - 1);
        }

        return rangeHigh;
    }

    public static int recursiveSumTwo(int rangeLow, int rangeHigh)
    {
        if (rangeHigh == rangeLow) {
            return rangeHigh;
        }

        int partOneLow = rangeLow;
        int partOneHigh = rangeHigh / 2;
        int partTwoLow = rangeLow / 2 + 1;
        int partTwoHigh = rangeHigh;

        int partOneSum = recursiveSumTwo(partOneLow, partOneHigh);
        int partTwoSum = recursiveSumTwo(partTwoLow, partTwoHigh);

        return partOneSum + partTwoSum;

    }
}

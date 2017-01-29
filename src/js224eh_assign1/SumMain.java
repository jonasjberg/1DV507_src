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
        getIntegerSumFromOneToN(6);
    }

    /*
     *      sum [1..N]  =  sum [1 .. N/2]  +  sum [N/2+1 .. N]
     *
     *
     *      1 to N, with N = 10:    1, 2, 3, 4, 5, 6, 7, 8, 9, 10
     *                              |                           |
     *                              1 ......................... N
     *
     *      Halved, with N = 10:    1, 2, 3, 4, 5, 6, 7, 8, 9, 10
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

    public static int getIntegerSumFromOneToN(int n)
    {
        if (n == 1) {
            return n;
        }

        return recursiveSum(1, n);
    }

    public static int recursiveSum(int rangeLow, int rangeHigh)
    {
        if (rangeHigh == rangeLow) {
            return rangeHigh;
        }

        if (rangeHigh == 1) {
            return 1;
        }

        if (rangeHigh - rangeLow == 1) {
            return rangeHigh + rangeLow;

        }

        int firstHalfLow = rangeLow;
        int firstHalfHigh = rangeHigh / 2;
        if (rangeHigh % 2 != 0) {
            //firstHalfHigh++;
        }

        int secondHalfLow = rangeHigh / 2 + 1;
        int secondHalfHigh = rangeHigh;
        if (rangeHigh % 2 != 0) {
            //secondHalfLow++;
        }

        return recursiveSum(firstHalfLow, firstHalfHigh) + recursiveSum(secondHalfLow, secondHalfHigh);
    }
}

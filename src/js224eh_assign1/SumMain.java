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
    final static int DEFAULT_N = 21;

    public static void main(String[] args)
    {
        // Check command line argument, fall back to default if checks fail.
        int n = -1;

        if (args.length == 1) {
            try {
                n = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.printf("[ERROR] %s%n", e.toString());
            }
        }

        if (n < 0) {
            System.out.printf("%n(Using default: N = %d)%n", DEFAULT_N);
            n = DEFAULT_N;
        }

        int sum = getIntegerSumFromOneToN(n);
        System.out.printf("The sum of integers {1..%d} = %d%n", n, sum);
    }

    // TODO: FIX EVERYTHING !!!

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
     *                              L       C       H
     *  partLow:  2             1,  2,  3,  4,  5,  6,  7,  8,  9,  10
     *  partHigh: 6                 |               |
     *                              '...............'
     *                              pL             pH
     *
     *                              L       C       H
     *  Split into two parts:   1,  2,  3,  4,  5,  6,  7,  8,  9,  10
     *                              |   |   |       |
     *                              '...'   '.......'
     *
     *                            p1L  p1H  p2L   p2H
     *
     *      p1L = partLow
     *      p1H =
     *
     *                              L       C           H
     *  Split into two parts:   1,  2,  3,  4,  5,  6,  7,  8,  9,  10
     *                              |   |   |           |
     *                              '...'   '...........'
     *
     *                            p1L  p1H  p2L      p2H
     *
     *
     */

    public static int getIntegerSumFromOneToN(int n)
    {
        if (n < 1) {
            throw new IllegalArgumentException("n must be >= 1");
        } else if (n == 1) {
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

        int center = rangeHigh - rangeLow;

        if (center == 1) {
            return rangeHigh + rangeLow;
        }

        int firstHalfSum = recursiveSum(rangeLow, center);
        int secondHalfSum = recursiveSum(center + 1, rangeHigh);
        return firstHalfSum + secondHalfSum;
    }
}

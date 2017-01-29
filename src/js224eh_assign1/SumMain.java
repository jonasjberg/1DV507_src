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

    }

    /*
     *      sum [1..N]  =  sum [1 .. N/2]  +  sum [N/2+1 .. N]
     *
     *
     *
     *      Full range:     1, 2, 3, 4, 5, 6, 7, 8, 9, 10
     *
     *      with N = 6:     1, 2, 3, 4, 5, 6, 7, 8, 9, 10
     *                      1 .............N
     *
     *      gives:
     *          sum [1..6]  =  sum [1 .. 6/2]  +  sum [6/2+1 .. 6]
     *                      =  sum [1 .. 3]    +  sum [4 .. 6]
     *
     */
    private int recursiveSum(int n)
    {
        int sum;

        if (n == 1) {
            sum = 1;
        }


        return sum;
    }
}

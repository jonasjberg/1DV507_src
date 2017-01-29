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

/*
 * ANSWER
 * ======
 * The algorithm does not seem hopelessly slow.
 * I did some experiments and generated a plot of the number of method calls
 * as a function of N, for N from 1 to 10000.
 *
 * The graph is included in this folder as "sumMain_n-from-1-to-10000_graph.png".
 * I also did some very simple curve-fitting, and it seems that the number of
 * method calls is not linear to N, but it is not as bad as exponential or some
 * kind of power law either.
 *
 * I am vaguely familiar with this kind of algorithm.
 * https://en.wikipedia.org/wiki/Divide_and_conquer_algorithm
 *
 * But I lack the math skills necessary to dig much deeper into this.
 * I'd guess to say that each comparison takes the same amount of time.
 *
 * This method results in many simple computations of small numbers.
 * I have a feeling this _might_ linearize the execution time, as compared to
 * calculating the sum with a simple traversal and continuous increment of a
 * running tally. The running sum would grow to become a very large number
 * that might require more than a single CPU/JavaVM instruction to process.
 * On second thought, maybe this wouldn't happen for < 64-bit numbers ..
 *
 * I'd say it is a convoluted solution for this simple problem.
 * The divide and conquer apporach fits other kinds of problems better and
 * is probably even required to solve some of them.
 * Instinctively, I would prefer to calculate the sum using a simpler method.
 *
 * But it is tough to determine the suitability of a solution without a
 * greater context and/or some defined set of requirements.
 */

package js224eh_assign1;


public class SumMain
{
    final static int DEFAULT_N = 21;

    static int numberCallsToRecursiveSum = 0;

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
            System.out.printf("Using default: N = %d%n", DEFAULT_N);
            n = DEFAULT_N;
        }

        int sum = getIntegerSumFromOneToN(n);
        System.out.printf("Sum of integers {1..%d} = %d%n", n, sum);
        System.out.printf("Number of method calls: %d%n",
                          numberCallsToRecursiveSum);

        // // Simpler output format used to save CSV data to generate the graph
        // // "sumMain_n-from-1-to-10000_graph.png".
        // for (int i = 1; i <= 10000; i++) {
        //     int sum = getIntegerSumFromOneToN(i);
        //     System.out.printf("%d:%d:%d%n", i, sum, numberCallsToRecursiveSum);
        // }
    }


    public static int getIntegerSumFromOneToN(int n)
    {
        if (n < 1) {
            throw new IllegalArgumentException("n must be >= 1");
        } else if (n == 1) {
            return n;
        }

        return recursiveSum(1, n);
    }

    /**
     * Calculates the sum of integers from "rangeLow" to "rangeHigh".
     *
     * Recursively splits the range of integers into two halves and calculates
     * the sum of the halves individually.
     *
     *      sum [1..N]  =  sum [1 .. N/2]  +  sum [N/2+1 .. N]
     *
     * The number of calls is tracked with the static variable
     * "numberCallsToRecursiveSum".
     *
     * @param rangeLow Lower bound of range to calculate.
     * @param rangeHigh Upper bound of range to calculate.
     * @return The sum of the integers in the range {rangeLow..rangeHigh}.
     */
    public static int recursiveSum(int rangeLow, int rangeHigh)
    {
        numberCallsToRecursiveSum++;

        if (rangeHigh == rangeLow) {
            return rangeHigh;
        } else if (rangeHigh == 1) {
            return 1;
        }

        int center = rangeHigh - rangeLow;
        if (center == 1) {
            return rangeHigh + rangeLow;
        } else {
            return recursiveSum(rangeLow, center) +
                   recursiveSum(center + 1, rangeHigh);
        }
    }
}

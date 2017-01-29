// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 1: Inheritance, Recursion and Java 1.8
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-01-29.

/*
 *  Exercise 5
 *  ----------
 *  Write a program PascalMain that prints the n:th row of Pascals Triangle.
 *  The program should include a recursive method int[] pascalRow(int n)
 *  computing the n:th row of the triangle. Notice, your program only needs to
 *  print line n, not necessarily the whole triangle.
 */

package js224eh_assign1;


public class PascalMain
{
    final static int DEFAULT_N = 6;

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
            System.out.printf("%nUsing default: N = %d%n%n", DEFAULT_N);
            n = DEFAULT_N;
        }

        print(n);

        // Do the calculation. Uses a recursive method.
/*        int[] row = pascalRow(n);

        // Prepare and print results.
        StringBuilder sb = new StringBuilder("[ ");
        for (Integer i : row) {
            sb.append(i).append(" ");
        }
        sb.append("]");
        System.out.printf("Line %d  -->  %s%n", n, sb.toString());*/
    }

    public static void print(int n)
    {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n - row; col++) {
                // print space for triangle like structure
                System.out.print(" ");
            }

            for (int j = 0; j <= row; j++) {
                System.out.print(pascal(row, j) + " ");
            }
            System.out.println();
        }
    }

    public static int pascal(int row, int col)
    {
        if (col == 0 || col == row) {
            return 1;
        } else {
            return pascal(row - 1, col - 1) + pascal(row - 1, col);
        }
    }

    static private int pascalRow(int row, int column)
    {
        if (column == 0 || column == row) {
            return 1;
        }

        return pascalRow(row - 1, column - 1) +
               pascalRow(row - 1, column);
    }
}

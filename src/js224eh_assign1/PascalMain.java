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

        // Do the calculation. Uses a recursive method.
        int[] row = pascalRow(n);

        // Prepare and print results.
        StringBuilder sb = new StringBuilder("[ ");
        for (Integer i : row) {
            sb.append(i).append(" ");
        }
        sb.append("]");
        System.out.printf("Line %d  -->  %s%n", n, sb.toString());
    }

    static private int[] pascalRow(int n)
    {
        int[] rows = new int[5000];

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 1; j++) {
                rows[index++] = recursePascalTriangle(i, j);
            }
        }

        return rows;
    }

    static private int recursePascalTriangle(int row, int column)
    {
        if (column == 0 || row == column + 1 || column == row) {
            return 1;
        }

        return recursePascalTriangle(row - 1, column - 1) +
               recursePascalTriangle(row - 1, column);
    }
}

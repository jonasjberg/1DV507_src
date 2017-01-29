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

    /**
     * Get row N in a Pascal triangle.
     *
     * @param n The row to get.
     * @return The triangle row as an array of integers.
     */
    static private int[] pascalRow(int n)
    {
        if (n == 0) {
            return new int[]{1};
        } else {

            int[] row = new int[n + 1];

            for (int i = 0; i < row.length; i++) {
                row[i] = pascalTriangleEntry(n, i);
            }

            return row;
        }
    }

    /**
     * Calculate the number at a specific row and column in a Pascal triangle.
     *
     * .     .        .         .       .         .
     * |  row  |  ==  |  row - 1  |  +  |  row - 1  |
     * |  col  |  ==  |  col      |  +  |  col - 1  |
     * '     '        '         '       '         '
     *
     * @param row    The row of the entry.
     * @param column The column of the entry.
     * @return The number at the specified row and column.
     */
    static private int pascalTriangleEntry(int row, int column)
    {
        if (column == 0 || column == row) {
            return 1;
        }

        return pascalTriangleEntry(row - 1, column - 1) +
               pascalTriangleEntry(row - 1, column);
    }
}

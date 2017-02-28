// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 3: Algorithms, Hashing/BSTs and GUI #2
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-02-28.

// Exercise 1
// ==========
// Every Computer Science course involving algorithms should include the
// Euclidean algorithm! The Euclidean algorithm is an algorithm to decide the
// greatest common divisor of two positive integers. The greatest common
// divisor of N and M, in short GCD(M,N), is the largest integer X such as M
// and N are evenly dividable with X.  Some examples:
//
//     GCD(18,12) = 6
//     GCD(42,56) = 14
//     GCD(9,28) = 1
//
// Write a program EuclideanMain that takes two integers as input and
// calculates (and presents) their GCD using this algorithm.
// More information about the Euclidean algorithm can be found on the Internet.
// In Swedish: Euklides algoritm


package js224eh_assign3;

import java.util.Scanner;

/**
 * Created by jonas on 2017-02-28.
 */
public class EuclideanMain {

    public static void main(String[] args) {
        System.out.println("This program calculates the greatest common " +
                           "divisor X of two positive integres, N and M; ");
        System.out.println("X = GCD(M,N)");
        System.out.println();

        int m = getPositiveIntegerFromUser("Enter the integer M: ");
        int n = getPositiveIntegerFromUser("Enter the integer N: ");
        int x = getGreatestCommonDivisor(m, n);

        System.out.println();
        System.out.printf("The greatest common divisor of %d and %d = %d%n",
                          m, n, x);
    }


    /**
     * Calculates the greatest common divisor of 'n' and 'm'; the largest
     * integer 'X' such as 'm' and 'n' are evenly dividable with 'X'.
     * <p>
     * First written 2016-12-08 21:04:44 as part of 1DV506 Assignment 3,
     * Exercise 7 "Fraction.java". Modified to accept parameters instead of
     * directly act on class fields.
     *
     * @return The greatest common divisor of 'n' and 'm'.
     */
    private static int getGreatestCommonDivisor(int m, int n) {
        int tmp;
        int t = Math.abs(m);
        int v = Math.abs(n);

        while (t > 0) {
            tmp = t;
            t = v % t;
            v = tmp;
        }

        return v;
    }

    /**
     * First created 2015-06-24 during the course DV017a at Högskolan i Gävle.
     * https://github.com/jonasjberg/DV017A_lab2/commit/057fc2e41f79b3458b09d5678176c9ae6423728e
     * <p>
     * Prompts the user for a positive whole number.
     * <p>
     * The message is shown continuously until the user has entered a valid
     * whole number. Any leading and trailing whitespace is removed.
     *
     * @param message The message to display when prompting for input.
     * @return The number entered by the user.
     */
    private static int getPositiveIntegerFromUser(String message) {
        Scanner scan = new Scanner(System.in);
        String msg = message + ": ";
        int number;

        do {
            System.out.print(msg);

            while (!scan.hasNextInt()) {
                System.out.print(msg);
                scan.next();
            }
            number = scan.nextInt();
        } while (number <= 0);

        scan.close();
        return number;
    }
}

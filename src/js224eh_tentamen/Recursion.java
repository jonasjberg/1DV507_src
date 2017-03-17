package js224eh_tentamen;


import java.util.Arrays;


/**
 * Examination in Computer Science, 1DV507.  Exercise 1.
 *
 * Created by Jonas Sjöberg (js224eh) on 2017-03-17.
 */
public class Recursion
{
    private static void printBackwards(int[] arr, int n)
    {
        int arrayLength = arr.length;
        int index       = arrayLength - n - 1;

        if (index < arrayLength && index >= 0) {
            System.out.printf("%d, ", arr[index]);
            printBackwards(arr, n + 1);
        }
    }

    private static int intDivideNonRec(int a, int b)
    {
        if (a < 0 || b < 0) {
            throw new RuntimeException("Both a and b must be positive");
        } else {

            int result = 0;
            while (a > b) {
                result++;
                a = a - b;
            }

            return result;
        }
    }

    private static int intDivide(int a, int b)
    {
        /*  From personal lecture notes:   a * b = a + (b - 1)a
         *                                 a / b = a - (b - 1)a  (?)
         *
         *  Used recursive function:   return(a + mul(a, b - 1))
         *    So possibly maybe (?):   return(1 + div(a - b, b))
         */
        if (a < 0 || b < 0) {
            throw new RuntimeException("Both a and b must be positive");
        }

        if (b == 0) {
            /* Division by zero is not allowed. */
            return 0;
        } else if (a - b == 0) {
            /* Expression can be reduced to 1. */
            return 1;
        } else if (a < b) {
            /* Case where a cannot be divided evenly by b. */
            /* Just ignore all decimals instead of handling it properly. */
            return 0;
        } else {
            /* None of the above base cases apply, keep going. */
            return 1 + intDivide(a - b, b);
        }
    }

    private static void printIntDivideResults(int a, int b)
    {
        System.out.printf("intDivide(%d, %d) = %d%n", a, b, intDivide(a, b));
    }

    public static void main(String[] args)
    {
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
                    18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32,
                    33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47,
                    48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62,
                    63, 64 };

        System.out.println("Demonstration of method \"printBackwards\":");
        System.out.println("Original integer Array:");
        System.out.println(Arrays.toString(a));
        System.out.println("Reversed integer Array:");
        printBackwards(a, 0);

        System.out.println();
        System.out.println();
        System.out.println("Demonstration of method \"intDivide\":");
        printIntDivideResults(420, 42);
        printIntDivideResults(666, 3);
        printIntDivideResults(2, 1);
    }
}

package js224eh_tentamen;


/**
 * Examination in Computer Science, 1DV507.  Exercise 1A.
 *
 * Created by Jonas Sjöberg (js224eh) on 2017-03-17.
 */
public class Recursion
{
    private static void printBackwards(int[] arr, int n)
    {
        int arrayLength = arr.length;
        int index = arrayLength - n - 1;

        if (index < arrayLength && index >= 0) {
            System.out.printf("%d, ", arr[index]);
            printBackwards(arr, n + 1);
        }
    }

    private static int intDivide(int a, int b)
    {

    }

    public static void main(String[] args)
    {
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
                    18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32,
                    33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47,
                    48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62,
                    63, 64 };

        printBackwards(a, 0);
    }
}

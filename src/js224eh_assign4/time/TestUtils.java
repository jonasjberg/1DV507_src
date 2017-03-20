// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 4: Generic Classes and More Algorithms
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-20.

package js224eh_assign4.time;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class TestUtils
{
    /**
     * Prints a timestamped status message.
     *
     * @param status Status "header" of sorts, uppercase and constant width.
     * @param message The message to print.
     */
    public static void printTestStatusMessage(String status, String message)
    {
        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String     FMT        = "[%s] %-15.15s %s%n";

        if (!status.isEmpty()) {
            status = status.toUpperCase();
        }

        System.out.printf(FMT, dateFormat.format(new Date()), status, message);
    }

    /**
     * Returns a randomized array of Strings with a specified number of elements
     * that each have a specified length, I.E. number of letters.
     *
     * @param elementCount The number of strings in the array.
     * @param elementLength The length of each string contained in the array.
     * @return A randomized array of strings.
     */
    public static String[] getRandomStringArray(int elementCount, int elementLength)
    {
        if (elementCount <= 0) {
            throw new IndexOutOfBoundsException();
        }
        if (elementLength <= 0) {
            throw new IndexOutOfBoundsException();
        }

        Random   random = new Random();
        String[] result = new String[elementCount];

        for (int i = 0; i < elementCount; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < elementLength; j++) {
                /* Add random integer 0-25 to 'a' (ASCII-symbol with decimal
                   value 97) to get random ASCII characters in the range a-z. */
                char randomChar = (char) (random.nextInt(26) + 'a');
                sb.append(randomChar);
            }

            result[i] = sb.toString();
        }

        return result;
    }
}

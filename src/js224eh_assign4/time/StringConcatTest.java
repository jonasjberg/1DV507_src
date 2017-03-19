// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 4: Generic Classes and More Algorithms
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-16.

package js224eh_assign4.time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jonas on 2017-03-16.
 */
public class StringConcatTest {
    final static int NUMBER_TEST_RUNS = 5;
    final static String SHORT_STRING = "a";
    final static String LONG_STRING = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

    private Stopwatch stopwatch;

    public StringConcatTest() {}

    /**
     * Performs string concatenation of a provided string, "NUMBER_TEST_RUNS"
     * times. It then calculates and prints the average number of concatenations
     * and the average final string length.
     *
     * @param string The string that is repeatedly concatenated.
     */
    private void testConcatenation(String string)
    {
        double averageConcatCount = 0;
        double averageStringLength = 0;

        for (int i = 0; i < NUMBER_TEST_RUNS; i++) {
            String resultString = "";
            int concatCount = 0;

            stopwatch = new Stopwatch();
            stopwatch.start();
            do {
                resultString += string;
                concatCount++;
            } while (stopwatch.hasTimeLeft());

            averageConcatCount += concatCount;
            averageStringLength += resultString.length();
        }

        averageConcatCount /= NUMBER_TEST_RUNS;
        averageStringLength /= NUMBER_TEST_RUNS;
        printTestStatusMessage("", "Average Concatenations: " + averageConcatCount);
        printTestStatusMessage("", "Average Final string length: " + averageStringLength);
    }

    /**
     * Performs appending of a provided string, "NUMBER_TEST_RUNS" times.
     * It then calculates and prints the average number of concatenations
     * and the average final string length.
     *
     * @param string The string that is repeatedly concatenated.
     */
    private void testAppending(String string)
    {
        double averageConcatCount = 0;
        double averageStringLength = 0;

        for (int i = 0; i < NUMBER_TEST_RUNS; i++) {
            StringBuilder sb = new StringBuilder();
            int concatCount = 0;
            String resultString;

            stopwatch = new Stopwatch();
            stopwatch.start();

            while (true) {
                sb.append(string);
                concatCount++;

                if (!stopwatch.hasTimeLeft()) {
                    resultString = sb.toString();
                    break;
                }
            }

            averageConcatCount += concatCount;
            averageStringLength += resultString.length();
        }

        averageConcatCount /= NUMBER_TEST_RUNS;
        averageStringLength /= NUMBER_TEST_RUNS;
        printTestStatusMessage("", "Average Concatenations: " + averageConcatCount);
        printTestStatusMessage("", "Average Final string length: " + averageStringLength);

    }

    /**
     * Get number of concatenations and final string length when concatenating short strings.
     */
    public void testConcatShortStrings() {
        printTestStatusMessage("STARTING TEST", "Concatenating short strings");
        testConcatenation(SHORT_STRING);
        printTestStatusMessage("FINISHED TEST", "Concatenating short strings");
    }

    /**
     * Get number of concatenations and final string length when concatenating long strings.
     */
    public void testConcatLongStrings() {
        printTestStatusMessage("STARTING TEST", "Concatenating long strings");
        testConcatenation(LONG_STRING);
        printTestStatusMessage("FINISHED TEST", "Concatenating long strings");
    }

    /**
     * Get number of concatenations and final string length when appending short strings.
     */
    public void testAppendShortStrings() {
        printTestStatusMessage("STARTING TEST", "Appending short strings");
        testAppending(SHORT_STRING);
        printTestStatusMessage("FINISHED TEST", "Appending short strings");
    }

    /**
     * Get number of concatenations and final string length when appending long strings.
     */
    public void testAppendLongStrings() {
        printTestStatusMessage("STARTING TEST", "Appending long strings");
        testAppending(LONG_STRING);
        printTestStatusMessage("FINISHED TEST", "Appending long strings");
    }

    /**
     * Prints a timestamped status message.
     *
     * @param status Status "header" of sorts, uppercase and constant width.
     * @param message The message to print.
     */
    private void printTestStatusMessage(String status, String message)
    {
        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String FMT = "[%s] %-15.15s %s%n";

        if (!status.isEmpty()) {
            status = status.toUpperCase();
        }

        System.out.printf(FMT, dateFormat.format(new Date()), status, message);
    }
}

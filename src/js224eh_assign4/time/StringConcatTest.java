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
    final static String SHORT_STRING = "a";
    final static String LONG_STRING = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    public static final int NUMBER_TEST_RUNS = 5;

    private Stopwatch stopwatch;

    public StringConcatTest() {


    }

    // Get number of concatenations and final string length when concatenating short strings.
    public void testConcatShortStrings() {
        double averageConcatCount = 0;
        double averageStringLength = 0;

        System.out.println("STARTING TEST: Concatenating short strings");

        for (int i = 0; i < NUMBER_TEST_RUNS; i++) {
            String resultString = "";
            int concatCount = 0;

            stopwatch = new Stopwatch();
            stopwatch.start();
            do {
                resultString += SHORT_STRING;
                concatCount++;
            } while (stopwatch.hasTimeLeft());

            averageConcatCount += concatCount;
            averageStringLength += resultString.length();
        }

        System.out.println("FINISHED TEST: Concatenating short strings");
        averageConcatCount /= NUMBER_TEST_RUNS;
        averageStringLength /= NUMBER_TEST_RUNS;
        System.out.printf("Average Concatenations: %f%n", averageConcatCount);
        System.out.printf("Average Final string length: %f%n", averageStringLength);
    }

    // Get number of concatenations and final string length when concatenating long strings.
    public void testConcatLongStrings() {
        double averageConcatCount = 0;
        double averageStringLength = 0;

        System.out.println("STARTING TEST: Concatenating long strings");

        for (int i = 0; i < NUMBER_TEST_RUNS; i++) {
            String resultString = "";
            int concatCount = 0;

            stopwatch = new Stopwatch();
            stopwatch.start();
            do {
                resultString += LONG_STRING;
                concatCount++;
            } while (stopwatch.hasTimeLeft());

            averageConcatCount += concatCount;
            averageStringLength += resultString.length();
        }

        System.out.println("FINISHED TEST: Concatenating long strings");

        averageConcatCount /= NUMBER_TEST_RUNS;
        averageStringLength /= NUMBER_TEST_RUNS;
        System.out.printf("Average Concatenations: %f%n", averageConcatCount );
        System.out.printf("Average Final string length: %f%n", averageStringLength);
    }

    // Get number of concatenations and final string length when appending short strings.
    public void testAppendShortStrings() {
        System.out.println("STARTING TEST: Appending short strings");
        StringBuilder sb = new StringBuilder();
        int concatCount = 0;
        String resultString;

        stopwatch = new Stopwatch();
        stopwatch.start();

        while (true) {
            sb.append(SHORT_STRING);
            concatCount++;

            if (!stopwatch.hasTimeLeft()) {
                resultString = sb.toString();
                break;
            }
        }

        System.out.println("FINISHED TEST: Appending short strings");
        System.out.printf("Average Concatenations: %d%n", concatCount);
        System.out.printf("Average Final string length: %d%n", resultString.length());
    }

    // TODO: Get number of concatenations and final string length when appending long strings.

    private void printTestStatusMessage(String status, String message)
    {
        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String FMT = "[%s] %-15.15s: %s%n";

        if (!status.isEmpty()) {
            status = status.toUpperCase();
        }

        System.out.printf(FMT, dateFormat.format(new Date()), status, message);
    }
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 1: Inheritance, Recursion and Java 1.8
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-01-29.

/*
 *  Exercise 6
 *  ----------
 *  To be submitted:
 *  In the previous course you wrote the program Histogram.java showing a
 *  very primitive bar chart of a number of integers. Change the program to
 *  use XChart to present a bar chart and a pie chart of the same set of data.
 */

package js224eh_assign1.xchart;

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Created by Jonas Sjöberg (js224eh) on 2017-01-07.
 *
 * 1DV506 -- Problemlösning och Programmering, HT2016
 * Laboration 4: Exceptions, IO och interface
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 * Uppgift 1
 * =========
 * Skriv ett program Histogram.java som läser ett godtyckligt antal heltal från
 * en fil och sedan ritar upp ett histogram (stapeldiagram) för de av talen som
 * är mellan 1 och 100. Notera: Alla talen i filen behöver ej vara inom
 * intervallet [1,100]. En körning kan se ut enligt följande:
 *
 *     Läser heltal från filen: C:\Temp\heltal.dat
 *     Antal i intervallet [1,100]: 46
 *     Övriga: 16
 *     Histogram
 *     1  - 10  | ******
 *     11 - 20  | ****
 *     21 - 30  | **
 *     31 - 40  | ***
 *     41 - 50  | *******
 *     51 - 60  | ****
 *     61 - 70  | ***
 *     71 - 80  | *********
 *     81 - 90  | *****
 *     91 - 100 | ***
 *
 * Notera 1: Du måste skapa din egen datafil. Vi förväntar oss en vanlig
 *           textfil med ett heltal per rad.
 * Notera 2: Datafilens sökväg (tex C:\Temp\heltal.dat) skall vara indata till
 *           programmet (via String[] args).
 */

import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Histogram
{
    static int[] buckets               = new int[10];
    static int[] numberFrequency       = new int[101];
    static int   numbersInRange        = 0;
    static int   numbersOutsideOfRange = 0;

    public static void main(String[] args)
    {
        if (args == null || args.length == 0) {
            System.out.println("Usage: Histogram [FILE]");
            System.exit(0);
        }

        int[] stats = calculateFileStatistics(args[0]);
        displayHistogram(stats);
    }

    private static void displayHistogram(int[] data)
    {
        // Create and Customize Chart
        CategoryChart chart = new CategoryChartBuilder().width(800).height(600).title("Histogram").xAxisTitle("Number").yAxisTitle("Frequency").build();
        chart.getStyler().setChartTitleVisible(false);
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideSW);
        chart.getStyler().setMarkerSize(5);

        // Generate data
        List<Double> xData = new ArrayList();
        List<Double> yData = new ArrayList();

        for (int i = 0; i < data.length; i++) {
            xData.add((double) i);
            yData.add((double) data[i]);
        }

        //chart.addSeries("Series", xData, yData);

        chart.addSeries("Number Frequency Series", new ArrayList<String>(Arrays.asList(new String[] { "1-10", "11-20", "21-30", "31-40", "41-50", "51-60", "61-70", "71-80", "81-90", "91-100"})), yData);

        // Display plot
        new SwingWrapper(chart).displayChart();
    }

    private static int[] calculateFileStatistics(String path)
    {
        Scanner scan = null;
        try {
            File file = new File(path);
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.printf("ERROR: %s%n", e.toString());
            System.exit(1);
        }

        int[] intervalCounter = new int[10];
        System.out.printf("Läser heltal från filen: \"%s\"%n", path);
        while (scan.hasNextLine()) {
            /* Match one or more digits, possibly preceded by a dash. */
            String digits = scan.findInLine("-?\\d+");
            if (digits == null) {
                scan.nextLine();
                continue;
            }

            try {
                int number = Integer.parseInt(digits);
                if (number >= 1 && number <= 100) {
                    numberFrequency[number]++;
                    intervalCounter[(number - 1) / 10]++;
                    numbersInRange++;
                } else {
                    numbersOutsideOfRange++;
                }
            } catch (NumberFormatException e) {
                System.out.printf("ERROR: %s%n", e.toString());
            }

            scan.nextLine();
        }
        scan.close();

        System.out.printf("Antal i intervallet [1,100]: %s%n", numbersInRange);
        System.out.printf("Övriga: %s%n", numbersOutsideOfRange);
        System.out.printf("Histogram%n");

        int b = 0;
        for (int i = 1; i < numberFrequency.length; i++) {
            buckets[b] += numberFrequency[i];

            if (i > 0 && i % 10 == 0) {
                if (b < buckets.length - 1) {
                    b++;
                }
            }
        }

        int bucketLow  = 1;
        int bucketHigh = 10;
        for (int i = 0; i < buckets.length; i++) {
            String bar = repeatString("*", buckets[i]);
            System.out.printf("%2d - %3d | %s%n", bucketLow, bucketHigh, bar);

            bucketLow += 10;
            bucketHigh += 10;
        }
        return intervalCounter;
    }

    /**
     * Repeats a given string a specified number of times.
     *
     * @param string  The string to repeat.
     * @param repeats The number of concatenations of the string.
     * @return 'string' repeated 'repeats' times.
     */
    private static String repeatString(String string, int repeats)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < repeats; i++) {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 3: Algorithms, Hashing/BSTs and GUI #2
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-06.

// Exercise 10
// ===========
// In Assignment 1 you used an external library XChart to present a bar and pie
// chart for a set of numbers read from a file. Revisit this task but create a
// graphical user interface that presents the numbers with one or more suitable
// charts using JavaFX. The file should be opened using a file selector and a
// suitable error message should be displayed if an error occurs.

package js224eh_assign3.histogram_fx;


import javafx.geometry.Insets;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import org.knowm.xchart.CategoryChart;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class HistogramFXapp extends BorderPane
{
    private BarChart barChart;

    public HistogramFXapp(File file)
    {
        // Add padding around all elements to window borders.
        setPadding(new Insets(15));

        int[] stats = calculateFileStatistics(file);
        // displayBarChart(file.getName().toString(), stats);
        displayBarChart("histogram_data.txt", stats);
    }



    public static void displayWarningMessage(String header, String content)
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("HistogramFXapp WARNIN");
        alert.setHeaderText("Unable to Read specified File!");
        alert.setContentText(
                "You might not have sufficient permissions to read the selected file.");

        alert.showAndWait();
    }

    public void displayBarChart(String name, int[] data)
    {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Number");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Frequency");

        XYChart.Series dataSeries = new XYChart.Series();
        dataSeries.setName(name);

        barChart = new BarChart(xAxis, yAxis);

        final String[] xAxisLabels = {"1-10", "11-20", "21-30", "31-40", "41-50",
                     "51-60", "61-70", "71-80", "81-90", "91-100"};

        for (int i = 0; i < data.length; i++) {
            String category = xAxisLabels[i % 10];
            dataSeries.getData().add(new XYChart.Data(category, data[i]));
        }
        // dataSeries.getData().add(new XYChart.Data("1-10", 178));
        // dataSeries.getData().add(new XYChart.Data("Desktop", 178));
        // dataSeries.getData().add(new XYChart.Data("Phone", 65));
        // dataSeries.getData().add(new XYChart.Data("Tablet", 23));

        barChart.getData().add(dataSeries);

        setTop(barChart);

        /*
        // Create and Customize Chart
        CategoryChart chart = new CategoryChartBuilder().width(800).height(600)
                                                        .title("Histogram")
                                                        .xAxisTitle("Number")
                                                        .yAxisTitle("Frequency")
                                                        .build();
        chart.getStyler().setChartTitleVisible(false);
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideSW);
        chart.getStyler().setMarkerSize(5);

        // Generate data
        ArrayList yData = new ArrayList();
        for (int i = 0; i < data.length; i++) {
            yData.add((double) data[i]);
        }

        // Hardcoded xData does the job but != pretty ..
        ArrayList<String> xData = new ArrayList<>(Arrays.asList(
                new String[]{"1-10", "11-20", "21-30", "31-40", "41-50",
                             "51-60", "61-70", "71-80", "81-90", "91-100"}));

        chart.addSeries("Number Frequency for file \"" + fileName + "\"",
                        xData, yData);

        // Display plot
        new SwingWrapper(chart).displayChart();
        */
    }

    /**
     * Calculates the distribution of numbers in a specified file.
     *
     * Based on code written for Lab #4 in the course 1DV506, 2017-01-07.
     * With the following modifications:
     *
     * * Modified to return suitable data type.
     * * Now accepts a file instead of a file path as String.
     * * Removed everything related to printing to stdout.
     * * Simplified dividing the numbers up into "buckets".
     *
     * @param file The file on which to calculate statistics.
     * @return The distribution frequency of numbers in the specified file.
     */
    private static int[] calculateFileStatistics(File file)
    {
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.printf("ERROR: %s%n", e.toString());
            System.exit(1);
        }

        int[] intervalNumberFrequency = new int[10];
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
                    int bucket = (number - 1) / 10;
                    intervalNumberFrequency[bucket]++;
                }
            } catch (NumberFormatException e) {
                System.out.printf("ERROR: %s%n", e.toString());
            }

            scan.nextLine();
        }
        scan.close();

        return intervalNumberFrequency;
    }
}

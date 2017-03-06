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
import javafx.scene.chart.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class HistogramFXapp extends BorderPane
{
    private BarChart barChart;
    private PieChart pieChart;
    private Button   buttonBarChart;
    private Button   buttonPieChart;
    private Button   buttonOpenFile;
    private HBox     buttons;
    private Stage    stage;
    private File     dataFile;
    private int[]    statistics;

    public HistogramFXapp(Stage stage)
    {
        this.stage = stage;

        // Add padding around all elements to window borders.
        setPadding(new Insets(15));

        buttonBarChart = new Button("Display Bar Chart");
        buttonPieChart = new Button("Display Pie Chart");
        buttonOpenFile = new Button("Open File..");

        buttons = new HBox(buttonBarChart,
                           buttonPieChart,
                           new Separator(),
                           buttonOpenFile);
        buttons.setPadding(new Insets(5));
        buttons.setSpacing(10);
        setBottom(buttons);


        /* TODO: Fix NullPointerExceptions when no file is selected. */
        buttonOpenFile.setOnAction(event -> {
            File f = openFileWithFileChooserDialog();
            if (f != null) {
                dataFile = f;

                /* Calculate statistics from local file. */
                statistics = calculateFileStatistics(dataFile);
                displayBarChart("Bar Chart Stats for Data", statistics);
            }
        });

        buttonBarChart.setOnAction(event -> {
            if (dataFile != null) {
                displayBarChart("Bar Chart Stats for Data", statistics);
            }
        });

        buttonPieChart.setOnAction(event -> {
            if (dataFile != null) {
                displayPieChart("Pie Chart Stats for Data", statistics);
            }
        });
    }

    /**
     * Opens a file selector dialog for the user to select a file.
     * If the file passes simple verification, it becomes the current dataFile.
     *
     * @return A valid data input file.
     */
    private File openFileWithFileChooserDialog()
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Data File to Visualize");

        // File file = new File("/home/jonas/LNU/1DV507_Datastrukturer/src/1DV507/src/js224eh_assign3/histogram_fx/histogram_data.txt");
        File file = fileChooser.showOpenDialog(stage);

        if (!file.exists()) {
            HistogramFXapp.displayWarningMessage(
                    "Invalid File", "Got NULL/non-existent File ..");
        }
        else if (!file.canRead()) {
            HistogramFXapp.displayWarningMessage(
                    "Unable to Read specified File!",
                    "You might not have sufficient permissions to read the selected file.");
        } else if (file != null) {
            return file;
        }

        return null;
    }

    /**
     * Displays a popup warning message dialog box.
     *
     * @param header The text to display in the dialog box header.
     * @param content The text to display as the dialog box content.
     */
    public static void displayWarningMessage(String header, String content)
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("HistogramFXapp WARNIN");
        alert.setHeaderText("Unable to Read specified File!");
        alert.setContentText(
                "You might not have sufficient permissions to read the selected file.");

        alert.showAndWait();
    }

    /**
     * Calculates the distribution of numbers in a specified file.
     *
     * NOTE (2017-03-06): This was copied AS-IS from Assignment #1.
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

    /**
     * Creates and displays a Bar Chart from an integer array.
     *
     * @param name A name to display with the Bar Chart.
     * @param data Frequency distribution data as an integer array.
     */
    private void displayBarChart(String name, int[] data)
    {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Number");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Frequency");

        XYChart.Series dataSeries = new XYChart.Series();
        dataSeries.setName(name);

        barChart = new BarChart(xAxis, yAxis);

        /* Hardcoded X-axis label .. */
        final String[] xAxisLabels = {"1-10", "11-20", "21-30", "31-40",
                 "41-50", "51-60", "61-70", "71-80", "81-90", "91-100"};

        for (int i = 0; i < data.length; i++) {
            String category = xAxisLabels[i % 10];
            dataSeries.getData().add(new XYChart.Data(category, data[i]));
        }

        barChart.getData().add(dataSeries);
        barChart.setPrefWidth(800);

        setTop(barChart);
    }

    /**
     * Creates and displays a Pie Chart from an integer array.
     *
     * @param name A name to display with the Pie Chart.
     * @param data Frequency distribution data as an integer array.
     */
    private void displayPieChart(String name, int[] data)
    {
        pieChart = new PieChart();

        /* Hardcoded slice labels .. */
        final String[] sliceLabels = {"1-10", "11-20", "21-30", "31-40",
                 "41-50", "51-60", "61-70", "71-80", "81-90", "91-100"};

        for (int i = 0; i < data.length; i++) {
            String category = sliceLabels[i % 10];
            pieChart.getData().add(new PieChart.Data(category, data[i]));
        }

        setTop(pieChart);
    }
}

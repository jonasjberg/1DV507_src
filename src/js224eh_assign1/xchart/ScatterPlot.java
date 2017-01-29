// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 1: Inheritance, Recursion and Java 1.8
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-01-29.

/*
 *  Exercise 6
 *  ----------
 */

package js224eh_assign1.xchart;


import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.Styler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ScatterPlot
{
    public static void main(String[] args)
    {
        // Create and Customize Chart
        XYChart chart = new XYChartBuilder().width(800).height(600).build();
        chart.getStyler().setDefaultSeriesRenderStyle(
                XYSeries.XYSeriesRenderStyle.Scatter);
        chart.getStyler().setChartTitleVisible(false);
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideSW);
        chart.getStyler().setMarkerSize(5);

        // Generate data
        List xData = new ArrayList();
        List yData = new ArrayList();
        Random random = new Random();
        int size = 1000;
        for (int i = 0; i < size; i++) {
            xData.add(random.nextGaussian());
            yData.add(random.nextGaussian());
        }

        // Display scatter plot
        chart.addSeries("Gaussian Blob", xData, yData);
        new SwingWrapper(chart).displayChart();
    }
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 1: Inheritance, Recursion and Java 1.8
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-01-29.

/*
 *  Exercise 6
 *  ----------
 *  To be submitted:
 *  Write a program SinMain.java plotting the curve
 *      y = (1 + x/pi)*cos(x)*cos(40*x) in the range 0 <= x <= 2*pi
 */

package js224eh_assign1.xchart;


import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.Styler;

import java.util.ArrayList;
import java.util.List;


public class SinMain
{
    static final double X_BOUND_LOWER  = 0;
    static final double X_BOUND_UPPER  = 2 * Math.PI;
    static final int    NUMBER_SAMPLES = 1000;

    public static void main(String[] args)
    {
        // Create and Customize Chart
        XYChart chart = new XYChartBuilder().width(800).height(600).build();
        chart.getStyler().setDefaultSeriesRenderStyle(
                XYSeries.XYSeriesRenderStyle.Line);
        chart.getStyler().setChartTitleVisible(false);
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideSW);
        chart.getStyler().setMarkerSize(5);

        // Generate data
        List xData = new ArrayList();
        List yData = new ArrayList();

        double step = Math.abs(X_BOUND_UPPER - X_BOUND_LOWER) / NUMBER_SAMPLES;
        for (double x = X_BOUND_LOWER; x < X_BOUND_UPPER; x += step) {
            xData.add(x);
            yData.add(calculateCurveFunction(x));
        }

        // Display scatter plot
        chart.addSeries("Sine Plot", xData, yData);
        new SwingWrapper(chart).displayChart();
    }

    /**
     * Does the requested calculation.
     *
     * y = (1 + x/pi)*cos(x)*cos(40*x) in the range 0 <= x <= 2*pi
     *
     * @param x Function input value.
     * @return Function output value as a double.
     */
    private static double calculateCurveFunction(double x)
    {
        if (x < 0 || x > 2 * Math.PI) {
            throw new IllegalArgumentException("Legal range:  0 <= x <= 2*pi");
        }

        return (1 + (x / Math.PI)) * Math.cos(x) * Math.cos(40 * x);
    }
}

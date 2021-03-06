// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 2: Data Structures, JUnit, and JavaFX1
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-02-13.

// Exercise 7

package js224eh_assign2.colordisplay;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Main entry point for the ColorDisplay application.
 */
public class ColorDisplayMain extends Application
{
    final static int WINDOW_WIDTH = 320;
    final static int WINDOW_HEIGHT = 300;
    final static String WINDOW_TITLE = "1DV507 Assignment 2 -- Exercise 7";

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        ColorDisplay colorDisplay = new ColorDisplay();
        Scene scene = new Scene(colorDisplay, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setMinWidth(WINDOW_WIDTH);
        stage.setMinHeight(WINDOW_HEIGHT);
        stage.setTitle(WINDOW_TITLE);
        stage.setScene(scene);
        stage.show();
    }
}

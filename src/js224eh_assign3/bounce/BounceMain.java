// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 3: Algorithms, Hashing/BSTs and GUI #2
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-07.

// Exercise 11 (VG)
// ================
// Create a program with JavaFX that displays a bouncing graphics
// (an image of a ball or the head of Darth Vader or anything else).
//
// The object should bounce around in the window.
//
// There should also be a button in the window that releases another object
// (unlimited number should be possible to have in the window,
// but only one new object should be released for each press of the button).
//
// The objects must also bounce on each other when the program is running.

package js224eh_assign3.bounce;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BounceMain extends Application
{
    final int WINDOW_WIDTH = 800;
    final int WINDOW_HEIGHT = 600;
    final static String WINDOW_TITLE = "1DV507 Assignment 3 -- Exercise 10";

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        BounceApp app = new BounceApp();

        Scene scene = new Scene(app, WINDOW_WIDTH, WINDOW_HEIGHT);

        stage.setMinWidth(WINDOW_WIDTH);
        stage.setMinHeight(WINDOW_HEIGHT);
        stage.setTitle(WINDOW_TITLE);
        stage.setScene(scene);
        stage.show();
    }
}

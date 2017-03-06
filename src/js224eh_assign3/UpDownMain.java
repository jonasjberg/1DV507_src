// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 3: Algorithms, Hashing/BSTs and GUI #2
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-06.

// Exercise 8
// ==========
// Design and implement a class UpDownPane where the pane contains a pattern of
// 7x7 smaller panes. The small pane in the middle of the big pane will, once
// the program is started, contain a small icon (or image). When an arrow key is
// pressed, the icon will move a step up/down or right/left, to a neighboring
// small pane. If the icon is moved out of the bigger pane, then the icon will
// appear on the other side of the bigger pane (i.e. if the icon is moved
// upwards when in an uppermost small pane, then it will appear on the
// corresponding small panel in the bottom row). Also write a test program
// UpDownMain.java, starting a window containing an UpDownPanel

package js224eh_assign3;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class UpDownMain extends Application
{
    final int WINDOWS_SIZE = 700;

    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setTitle("1DV507 Assignment 3 -- UpDownPane");

        UpDownPane playField = new UpDownPane(WINDOWS_SIZE / 100);

        Scene scene = new Scene(playField, WINDOWS_SIZE, WINDOWS_SIZE);
        scene.setOnKeyPressed(event -> playField.handleMovementEvent(event));

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 2: Data Structures, JUnit, and JavaFX1
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-02-13.

// Exercise 6

package js224eh_assign2.randompanel;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class RandomMain extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        RandomPanel randomPanel = new RandomPanel();

        Scene scene = new Scene(randomPanel, 320, 200);
        stage.setTitle("1DV507 Assignment 2 -- Exercise 6");
        stage.setScene(scene);
        stage.show();
    }
}

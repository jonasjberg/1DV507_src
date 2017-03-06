// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 3: Algorithms, Hashing/BSTs and GUI #2
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-06.

// Exercise 9
// ==========
// Design and implement an application that plays the game Catch-the-Creature.
// Use an image or icon to represent the creature. Have the creature appear at
// random locations, then disappear and reappear somewhere else. The goal for
// the player is to "catch" the creature by pressing the mouse button while the
// mouse pointer is on the creature image.
//
// Create a separate class to represent the creature, and include in it a method
// that determines if the location of the mouse click corresponds to the current
// location of the creature. Display a count of the number of times the creature
// is caught.

package js224eh_assign3.catch_creature;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class CatchTheCreatureMain extends Application
{
    final int WINDOW_WIDTH = 640;
    final int WINDOW_HEIGHT = 480;

    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setTitle("1DV507 Assignment 3 -- Catch-the-Creature");

        CreaturePlayfield playField = new CreaturePlayfield();

        Scene scene = new Scene(playField, WINDOW_WIDTH, WINDOW_HEIGHT);
        scene.setOnMouseClicked(event -> playField.handleMovementEvent(event));

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}

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

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class BounceApp extends Pane {
    private BallManager ballManager;
    private Button button;

    public BounceApp() {
        ballManager = new BallManager();

        final Timeline loop = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ballManager.updateState(event, getBoundsInLocal());
            }
        }));

        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();

        button = new Button("Add Ball");
        button.setOnAction(event -> {
            ballManager.createNewBall();
            // getChildren().removeAll(getChildren());
            getChildren().addAll(ballManager.getBalls());
        });

        getChildren().addAll(button);
    }
}

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

import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

public class Ball
{
    /* Both the visual representation and in parts the logic for the ball,
       as the "Circle" object keeps track of position and other state. */
    private Circle circle;

    /* Movement vectors/intertia/acceleration forces ..
       Used to update the current position of the ball. */
    private double dx, dy;

    /**
     * Creates a new instance of the 'Ball' class with a certain radius
     * and a random color.
     *
     * @param radius The radius of this instance.
     */
    public Ball(double radius)
    {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be > 0");
        }

        Random rng = new Random();
        Color randomColor = new Color(rng.nextDouble(), rng.nextDouble(),
                                      rng.nextDouble(), 0.0);

        circle = new Circle(radius, randomColor);
    }

    public void updateState()
    {
        circle.setLayoutX(circle.getLayoutX() + dx);
        circle.setLayoutY(circle.getLayoutY() + dy);
    }

    public void checkBorderCollision(Bounds bounds)
    {
        // final Bounds bounds = canvas.getBoundsInLocal();

        boolean atRightBorder = circle.getLayoutX() >= (bounds.getMaxX() - circle.getRadius());
        boolean atLeftBorder = circle.getLayoutX() <= (bounds.getMinX() + circle.getRadius());
        boolean atBottomBorder = circle.getLayoutY() >= (bounds.getMaxY() - circle.getRadius());
        boolean atTopBorder = circle.getLayoutY() <= (bounds.getMinY() + circle.getRadius());

        if (atRightBorder || atLeftBorder) {
            dx *= -1;
        }
        if (atBottomBorder || atTopBorder) {
            dy *= -1;
        }
    }
}

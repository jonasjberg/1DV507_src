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

import java.util.ArrayList;
import java.util.Random;

public class Ball extends Circle
{
    /* Both the visual representation and in parts the logic for the ball,
       as the "Circle" object keeps track of position and other state. */
    //private Circle circle;

    private final double INITIAL_VELOCITY = 10;

    /* Used to randomize initial state. */
    protected final Random rng = new Random();

    /* Movement vectors/intertia/acceleration forces ..
       Used to update the current position of the ball. */
    protected double dx, dy;

    protected Color randomColor;

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

        randomColor = new Color(rng.nextDouble(), rng.nextDouble(),
                                rng.nextDouble(), 1.0);

        dx = rng.nextDouble() * INITIAL_VELOCITY;
        dy = rng.nextDouble() * INITIAL_VELOCITY;

        //circle = new Circle(radius, randomColor);
        setRadius(radius);
        setFill(randomColor);
    }

    public void updateState()
    {
        setLayoutX(getLayoutX() + dx);
        setLayoutY(getLayoutY() + dy);
        // System.out.printf("Ball position: (%f,%f)%n", getLayoutX(), getLayoutY());
    }

    public void checkBorderCollision(Bounds bounds)
    {
        double xPos = getLayoutX();
        double yPos = getLayoutY();
        double radius = getRadius();

        // boolean atRightBorder  = xPos >= (bounds.getMaxX() - radius);
        // boolean atLeftBorder   = xPos <= (bounds.getMinX() + radius);
        // boolean atBottomBorder = yPos >= (bounds.getMaxY() - radius);
        // boolean atTopBorder    = yPos <= (bounds.getMinY() + radius);

        if (((xPos >= (bounds.getMaxX() - radius)) && dx > 0) ||
            ((xPos <= (bounds.getMinX() + radius)) && dx < 0)) {
            dx *= -1;
        }
        if ((yPos >= (bounds.getMaxY() - radius)) && dy > 0) {
            dy *= -1;
        } else if ((yPos <= (bounds.getMaxY() + radius)) && dy < 0) {
            dy *= -1;
        }


        // if (atRightBorder  || atLeftBorder) { dx *= -1; }
        // if (atBottomBorder || atTopBorder)  { dy *= -1; }
    }

    public boolean collidesWith(Ball ball2)
    {
        if (getBoundsInParent().intersects(ball2.getBoundsInParent())) {
            return true;
        }
        return false;
    }

    public void bounce()
    {
        System.out.println("BOUNCE");
        dx *= -1;
        dy *= -1;
    }
}

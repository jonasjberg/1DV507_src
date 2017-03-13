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


import javafx.event.ActionEvent;
import javafx.geometry.Bounds;

import java.util.ArrayList;
import java.util.Random;

public class BallManager
{
    private ArrayList<Ball> balls;
    private ArrayList<Particle> particles;

    public BallManager()
    {
        balls = new ArrayList<>();
        particles = new ArrayList<>();
    }

    public Ball createNewBall()
    {
        Random rng = new Random();
        double randomRadius = rng.nextDouble() * 20;

        Ball newBall = new Ball(randomRadius);
        balls.add(newBall);
        return newBall;
    }

    public void addParticle(double x, double y)
    {

    }

    public ArrayList<Ball> getBalls()
    {
        return balls;
    }

    public void updateState(ActionEvent event, Bounds bounds)
    {
        if (balls.isEmpty()) {
            return;
        }

        /* Keep a list of balls left to check for collisions with other balls.
         * If a ball in this list is tested against all other balls, and no collision
         * is detected, the ball is removed from the list.
         *
         * TODO: Implement above algorithm.
         * For every ball in the set
         *     Compare to all other balls in the set
         *         If no collisions was found, remove from set.
         */

        ArrayList<Ball> ballsToCollisionCheck = (ArrayList<Ball>) balls.clone();

        for (Ball ball1 : balls) {
            for (Ball ball2 : balls) {
                if (ball1.equals(ball2)) {
                    continue;
                }

                if (ball1.collidesWith(ball2)) {
                    ball1.bounce();
                    ball2.bounce();
                }
            }
        }

        for (Ball ball : balls) {
            ball.checkBorderCollision(bounds);
            ball.updateState();
        }

        if (!particles.isEmpty()) {
            for (Particle particle : particles) {
                if (particle.shouldRemove()) {
                    particles.remove(particle);
                } else {
                    particle.updateState();
                }
            }
        }
    }
}

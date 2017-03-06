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


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.Random;

public class Creature
{
    final int SIZE = 100;

    private double     xPos;
    private double     yPos;
    private Image      creatureImage;
    private ImageView  creatureImageView;
    private DropShadow creatureDropShadow;

    public Creature()
    {
        try {
            creatureImage = new Image(
                    getClass().getResourceAsStream("creature.png"));
        } catch (IllegalArgumentException e) {
            System.out.printf("[ERROR] %s%n", e.toString());
        }

        creatureDropShadow = new DropShadow();
        creatureDropShadow.setBlurType(BlurType.GAUSSIAN);
        creatureDropShadow.setSpread(0.5f);
        creatureDropShadow.setRadius(13f);
        creatureDropShadow.setColor(Color.web("#B22222"));

        creatureImageView = new ImageView(creatureImage);
        creatureImageView.setEffect(creatureDropShadow);

        /* Used for continuously repositioning of the creature. */
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(750),
                ae -> timedRandomizedPosition()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    /**
     * Update the creature position.
     * @param x The new X-position.
     * @param y The new Y-position.
     */
    private void setPosition(double x, double y)
    {
        xPos = x;
        yPos = y;
        redraw();
    }

    /**
     * Test if the mouse pointer is over the creature.
     *
     * @param mouseX The X coordinate of the mouse pointer.
     * @param mouseY The Y coordinate of the mouse pointer.
     * @return True if the mouse pointer overlaps the creature, otherwise False.
     */
    public boolean checkMouseOverlap(double mouseX, double mouseY)
    {
        // System.out.printf("Creature coords: (%f,%f) (%f,%f)%n", xPos, yPos, xPos + SIZE, yPos + SIZE);
        // System.out.printf("Mouse clicked at: (%f,%f)%n", mouseX, mouseY);

        if (((mouseX >= xPos) && (mouseX <= xPos + SIZE)) &&
            ((mouseY >= yPos) && (mouseY <= yPos + SIZE))) {
            return true;
        }

        return false;
    }

    /**
     * Continuously called by a Timer, returns early by random to make
     * things more interesting.
     */
    private void timedRandomizedPosition()
    {
        Random rng = new Random();
        if (rng.nextBoolean()) {
            return;
        }

        randomizePosition();
    }

    /**
     * Randomizes new X,Y coordinates and updates the creature position to
     * this random position.
     */
    public void randomizePosition()
    {
        Random rng = new Random();
        double randomX = (rng.nextDouble() * CreaturePlayfield.PLAYFIELD_WIDTH) - SIZE / 2;
        double randomY = (rng.nextDouble() * CreaturePlayfield.PLAYFIELD_HEIGHT) - SIZE / 2;

        // System.out.printf("Randomized position: (%f,%f)%n", randomX, randomY);
        setPosition(randomX, randomY);
    }

    /**
     * Redraw the creature.
     */
    public void redraw()
    {
        creatureImageView.setLayoutX(xPos);
        creatureImageView.setLayoutY(yPos);
    }

    /**
     * @return The creature ImageView.
     */
    public Node getImageView()
    {
        return creatureImageView;
    }
}

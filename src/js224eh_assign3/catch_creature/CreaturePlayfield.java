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


import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.Group;


/**
 * Created by Jonas Sjöberg (js224eh) on 2017-03-06.
 */
public class CreaturePlayfield extends Pane
{
    public static double PLAYFIELD_WIDTH;
    public static double PLAYFIELD_HEIGHT;
    private Group        group;

    private Creature creature;

    private int score;

    /**
     * Creates a new instance of a CreaturePlayfield.
     *
     * @param width The width of the playfield.
     * @param height The height of the playfield.
     */
    public CreaturePlayfield(double width, double height)
    {
        PLAYFIELD_WIDTH = width;
        PLAYFIELD_HEIGHT = height;

        creature = new Creature();
        creature.randomizePosition();
        group = new Group(creature.getImageView());

        score = 0;
        getChildren().removeAll(getChildren());
        getChildren().add(group);
        redraw();
    }

    /**
     * Handles left-click MouseEvents.
     *
     * @param mouseEvent The MouseEvent to handle.
     */
    public void handleMouseEvent(MouseEvent mouseEvent)
    {
        double mouseX = mouseEvent.getX();
        double mouseY = mouseEvent.getY();

        if (creature.checkMouseOverlap(mouseX, mouseY)) {
            score++;
            creature.randomizePosition();
            redraw();
        }
    }

    /**
     * Redraw the playfield.
     */
    private void redraw()
    {
        creature.redraw();

        // getChildren().removeAll(getChildren());
        // getChildren().add(group);
    }
}

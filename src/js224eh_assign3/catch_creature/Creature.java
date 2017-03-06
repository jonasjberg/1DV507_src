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


public class Creature
{
    final int SIZE = 100;

    private double xPos;
    private double yPos;

    public Creature() { }

    public void setPosition(double x, double y)
    {
        xPos = x;
        yPos = y;
    }

    public double getXpos()
    {
        return xPos;
    }

    public double getYpos()
    {
        return yPos;
    }

    public boolean checkMouseOverlap(double mouseX, double mouseY)
    {
        if (((mouseX >= xPos) && (mouseX <= xPos + SIZE)) &&
            ((mouseY >= yPos) && (mouseY <= yPos + SIZE))) {
                return true;
        }
        return false;
    }
}

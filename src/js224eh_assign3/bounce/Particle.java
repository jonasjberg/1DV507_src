// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 3: Algorithms, Hashing/BSTs and GUI #2
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-13.

// Exercise 11 (VG)
// ================

package js224eh_assign3.bounce;

import javafx.scene.paint.Color;


public class Particle extends Ball {
    double lifetime;
    /**
     * Creates a new instance of the 'Ball' class with a certain radius
     * and a random color.
     *
     * @param radius The radius of this instance.
     */
    public Particle(double radius) {
        super(radius / 2);

        lifetime = 1;
    }

    public void updateState()
    {
        setLayoutX(getLayoutX() + dx);
        setLayoutY(getLayoutY() + dy);

        if (lifetime > 0) {
            lifetime -= 0.01;
        }

        if (lifetime == 0) {
            return;
        }

        double r = randomColor.getRed();
        double g = randomColor.getGreen();
        double b = randomColor.getBlue();

        Color color = new Color(r, g, b, lifetime);
        setFill(color);
    }

    public boolean shouldRemove()
    {
        return lifetime <= 0;
    }
}

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


import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.util.Random;


public class Creature
{
    private int        xPos;
    private int        yPos;
    private Image      image;
    private ImageView  imageView;
    private DropShadow dropShadow;
    private Group      group;


    public Creature()
    {
        dropShadow = new DropShadow();
        dropShadow.setBlurType(BlurType.GAUSSIAN);
        dropShadow.setSpread(0.2f);
        dropShadow.setRadius(13f);
        dropShadow.setColor(Color.web("#B22222"));

        image = new Image(getClass().getResourceAsStream("UpDownImage.png"));
        imageView = new ImageView(image);
        imageView.setEffect(dropShadow);

        group = new Group(imageView);

        randomizePosition();
        // renderState();
    }

    private void randomizePosition()
    {
        Random rng = new Random();

        // TODO: ..
    }

    public boolean atMouseLocation()
    {
        // TODO: ..

        return false;
    }


    /**
     * @deprecated
     * @param baseBounds
     * @param baseTransform
     */
    @Override public BaseBounds impl_computeGeomBounds(BaseBounds baseBounds,
                                                       BaseTransform baseTransform)
    { return null; }

    /**
     * @deprecated
     * @param v
     * @param v1
     */
    @Override protected boolean impl_computeContains(double v, double v1)
    { return false; }

    /**
     * @deprecated
     * @param mxNodeAlgorithm
     * @param mxNodeAlgorithmContext
     */
    @Override public Object impl_processMXNode(MXNodeAlgorithm mxNodeAlgorithm,
                                               MXNodeAlgorithmContext mxNodeAlgorithmContext)
    { return null; }

    /**
     * @deprecated
     */
    @Override protected NGNode impl_createPeer()
    { return null; }
}

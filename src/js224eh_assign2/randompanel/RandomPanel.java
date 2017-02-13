// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 2: Data Structures, JUnit, and JavaFX1
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-02-13.

// Exercise 6

package js224eh_assign2.randompanel;


import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Random;


/**
 * The "RandomPanel" class displays a simple UI that allows the user to click
 * a button to display a random number within a predefined range.
 */
public class RandomPanel extends BorderPane
{
    /* Sets the range of possible numbers. */
    final private int RANDOM_NUMBER_MIN = 1;
    final private int RANDOM_NUMBER_MAX = 100;

    /* Dynamic text resizing solution is based on the following:
     *  - "JavaFX 8 Introduction by Example" 2nd Ed. Apress 2014. Chapter 6.
     *  - "Learn JavaFX 8", 1st Ed. Apress 2015. Chapter 2.
     */
    private ObjectProperty<Font>
            fontTracking = new SimpleObjectProperty<>(Font.getDefault());
    private Button button;
    private Text   randomNumberText;
    private Random rng;

    public RandomPanel()
    {
        rng = new Random();

        // Add padding around all elements to window borders.
        setPadding(new Insets(0, 0, 10, 0));

        /* Create the text that displays the randomized number. */
        randomNumberText = new Text("100");
        setTop(randomNumberText);
        setAlignment(randomNumberText, Pos.CENTER);

        /* Bind the text font size to the size of this container. */
        randomNumberText.fontProperty().bind(fontTracking);
        widthProperty().addListener(
                (observableValue, oldWidth, newWidth) ->
                        fontTracking.set(Font.font(newWidth.doubleValue() / 2)));

        /* Create the button that triggers randomization. */
        button = new Button("New Random");
        setBottom(button);
        setAlignment(button, Pos.CENTER);

        /* Setup event listener that randomizes and displays a new number. */
        button.setOnAction((ActionEvent actionEvent) -> {
            int n = rng.nextInt((RANDOM_NUMBER_MAX - RANDOM_NUMBER_MIN + 1))
                    + RANDOM_NUMBER_MIN;
            randomNumberText.setText(String.valueOf(n));
        });
    }
}

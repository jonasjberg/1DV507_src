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
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Random;


public class RandomPanel extends BorderPane
{
    final private int RANDOM_NUMBER_MIN = 1;
    final private int RANDOM_NUMBER_MAX = 100;

    private Button button;
    private Text   randomNumber;
    private Random random;

    private ObjectProperty<Font>
            fontTracking = new SimpleObjectProperty<Font>(Font.getDefault());

    public RandomPanel()
    {
        random = new Random();

        /* Setup the text displaying the randomized number. */
        randomNumber = new Text();
        setBottom(randomNumber);
        setAlignment(randomNumber, Pos.CENTER);

        /* Bind font size to this containers size. */
        randomNumber.fontProperty().bind(fontTracking);
        widthProperty().addListener(
                (observableValue, oldWidth, newWidth) ->
                        fontTracking.set(Font.font(newWidth.doubleValue() / 4)));


        /* Setup the button that triggers randomization. */
        button = new Button("New Random");
        setTop(button);
        setAlignment(button, Pos.CENTER);

        button.setOnAction((ActionEvent actionEvent) -> {
            int n = random.nextInt((RANDOM_NUMBER_MAX - RANDOM_NUMBER_MIN + 1))
                    + RANDOM_NUMBER_MIN;
            randomNumber.setText(String.valueOf(n));
        });
    }
}

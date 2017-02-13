// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 2: Data Structures, JUnit, and JavaFX1
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-02-13.

// Exercise 6

package js224eh_assign2.randompanel;


import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import java.util.Random;


public class RandomPanel extends BorderPane
{
    final private int RANDOM_NUMBER_MIN = 1;
    final private int RANDOM_NUMBER_MAX = 100;

    private Button button;
    private Text   randomNumber;
    private Random random;

    public RandomPanel()
    {
        random = new Random();

        button = new Button("New Random");
        setTop(button);

        randomNumber = new Text();
        setBottom(randomNumber);


        button.setOnAction(actionEvent -> {
            int n = random.nextInt((RANDOM_NUMBER_MAX - RANDOM_NUMBER_MIN + 1))
                    + RANDOM_NUMBER_MIN;
            randomNumber.setText(String.valueOf(n));
        });

    }
}

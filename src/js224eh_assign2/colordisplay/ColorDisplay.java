// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 2: Data Structures, JUnit, and JavaFX1
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-02-13.

// Exercise 7

package js224eh_assign2.colordisplay;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.Random;


/**
 * The main class for the ColorDisplay application.
 */
public class ColorDisplay extends BorderPane
{
    private Pane         topPane;
    private TextFieldRGB red;
    private TextFieldRGB green;
    private TextFieldRGB blue;

    public ColorDisplay()
    {
        // Add padding around all elements to window borders.
        setPadding(new Insets(15));

        // Dynamically resize the color display pane.
        topPane = new Pane();
        topPane.prefWidthProperty().bind(widthProperty());
        topPane.prefHeightProperty().bind(heightProperty().divide(2));
        setTop(topPane);

        // Create the center pane with fields for user entry.
        setCenter(createColorEntryPane());

        // Create and add the button to the lower region.
        Button displayButton = new Button("Display Color");
        setAlignment(displayButton, Pos.CENTER);
        setBottom(displayButton);

        // Setup event listener for displaying current RGB values.
        displayButton.setOnAction(e -> updateColorDisplay());

        /* Do an initial redraw at first launch. */
        updateColorDisplay();
    }

    /**
     * Updates the top region background color to the values entered in the
     * "red", "green" and "blue" input fields.
     */
    private void updateColorDisplay()
    {
        int r = red.getColorValue();
        int g = green.getColorValue();
        int b = blue.getColorValue();

        System.out.printf("[DEBUG] RGB: %03d %03d %03d%n", r, g, b);
        Background bg = new Background(new BackgroundFill(Color.rgb(r, g, b),
                                                          new CornerRadii(0),
                                                          new Insets(5)));
        topPane.setBackground(bg);
    }

    /**
     * Creates a GridPane for entering R, G, B values in custom text fields.
     *
     * @return A GridPane with the appropriate fields.
     */
    private GridPane createColorEntryPane()
    {
        GridPane pane = new GridPane();

        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(5));
        pane.setHgap(30);
        pane.setVgap(5);

        ColumnConstraints colCon = new ColumnConstraints(50, 100, 150);
        pane.getColumnConstraints().addAll(colCon, colCon, colCon);

        // Default to randomized color value entries at startup.
        Random random = new Random();

        // Create and add the text input fields.
        pane.add(new Label("Red"), 0, 0);
        red = new TextFieldRGB(random.nextInt(256));
        pane.add(red, 0, 1);

        pane.add(new Label("Green"), 1, 0);
        green = new TextFieldRGB(random.nextInt(256));
        pane.add(green, 1, 1);

        pane.add(new Label("Blue"), 2, 0);
        blue = new TextFieldRGB(random.nextInt(256));
        pane.add(blue, 2, 1);

        return pane;
    }
}

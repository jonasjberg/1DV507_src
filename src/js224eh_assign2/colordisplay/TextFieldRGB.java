// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 2: Data Structures, JUnit, and JavaFX1
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-02-13.

// Exercise 7

package js224eh_assign2.colordisplay;


import javafx.scene.control.TextField;


/**
 * Custom class for entering RGB color values.
 */
public class TextFieldRGB extends TextField
{
    private int colorValue;

    /**
     * Creates a new RGB TextField with an initial value.
     *
     * @param initialValue The initial value to display in the text field.
     */
    public TextFieldRGB(int initialValue)
    {
        super();
        setColorValue(clampValueToByte(initialValue));

        // Logic for rejecting non-numeric entries is heavily inspired by the
        // following post: http://stackoverflow.com/a/30796829
        // Main thread:    http://stackoverflow.com/questions/7555564/what-is-the-recommended-way-to-make-a-numeric-textfield-in-javafx
        textProperty().addListener(
                (observableValue, valueOld, valueNew) -> {
                    // Regex matches zero or more digits.
                    if (!valueNew.matches("\\d*")) {
                        // Remove non-digits.
                        setText(valueNew.replaceAll("[^\\d]", ""));
                    } else {
                        // Handle exceptions thrown by negative numbers and
                        // clamp the value to the range 0-255.
                        try {
                            int value = Integer.parseInt(valueNew);
                            setColorValue(clampValueToByte(value));
                        } catch (NumberFormatException e) {
                            // TODO: Print warning/error message ..
                            setColorValue(0);
                        }
                    }
                });

        // Select the text when clicked to make it easier/faster to use.
        setOnMouseClicked(mouseEvent -> selectAll());
    }

    /**
     * Returns the current value entered in this text fields. The value is
     * guaranteed to be a valid integer betweeen 0 and 255.
     *
     * @return The current value as an integer.
     */
    public int getColorValue()
    {
        return colorValue;
    }

    /**
     * Sets the current value to a specified integer and updates the textField.
     *
     * @param colorValue The new value.
     */
    private void setColorValue(int colorValue)
    {
        this.colorValue = colorValue;
        this.setText(String.valueOf(colorValue));
    }

    /**
     * Utlity method clamps an integer to the range 0-255.
     *
     * @param value The value to clamp.
     * @return The provided value, limited to the range 0-255.
     */
    private int clampValueToByte(int value)
    {
        if (value <= 0) {
            return 0;
        } else if (value >= 255) {
            return 255;
        } else {
            return value;
        }
    }
}

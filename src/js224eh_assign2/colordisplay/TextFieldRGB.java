package js224eh_assign2.colordisplay;


import javafx.scene.control.TextField;


/**
 * Created by Jonas Sjöberg (js224eh) on 2017-02-13.
 */
public class TextFieldRGB extends TextField
{
    private int colorValue;

    public TextFieldRGB(String initalValue)
    {
        super(initalValue);
        colorValue = Integer.parseInt(initalValue);

        // Logic for rejecting non-numeric entries is heavily inspired by the
        // following post: http://stackoverflow.com/a/30796829
        // Main thread:    http://stackoverflow.com/questions/7555564/what-is-the-recommended-way-to-make-a-numeric-textfield-in-javafx
        this.textProperty().addListener(
                (observableValue, valueOld, valueNew) -> {
                    // Regex matches zero or more digits.
                    if (!valueNew.matches("\\d*")) {
                        // Remove non-digits.
                        this.setText(valueNew.replaceAll("[^\\d]", ""));
                    } else {
                        // Handle exceptions thrown by negative numbers and
                        // clamp the value to the range 0-255.
                        try {
                            int value = Integer.parseInt(valueNew);
                            if (value < 0) {
                                value = 0;
                            } else if (value > 255) {
                                value = 255;
                            }
                            this.setText(String.valueOf(value));
                            colorValue = value;
                        } catch (NumberFormatException e) {
                            // TODO: Print warning/error message ..
                            this.setText("0");
                            colorValue = 0;
                        }
                    }
                });
    }

    public int getColorValue()
    {
        return colorValue;
        // Integer.parseInt(this.textProperty().getValue());
    }
}

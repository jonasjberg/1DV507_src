package js224eh_assign2.colordisplay;


import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


/**
 * Created by Jonas Sjöberg (js224eh) on 2017-02-13.
 */
public class ColorDisplay extends BorderPane
{
    private Label     topLabel;
    private Button    displayButton;
    private TextField red;
    private TextField green;
    private TextField blue;

    private int r, g, b;

    public ColorDisplay()
    {
        topLabel = new Label("Color Display");
        topLabel.setFont(Font.font("Sans Serif", FontWeight.BOLD, 42));
        setAlignment(topLabel, Pos.CENTER);
        setTop(topLabel);

        setCenter(createColorEntryPane());

        displayButton = new Button("Display Color");
        setAlignment(displayButton, Pos.CENTER);
        setBottom(displayButton);

        setupTextFieldListeners(red, green, blue);

        /* Setup event listener that displays the current RGB values. */
        displayButton.setOnAction((ActionEvent actionEvent) -> {
            r = Integer.parseInt(red.textProperty().getValue());
            g = Integer.parseInt(red.textProperty().getValue());
            b = Integer.parseInt(red.textProperty().getValue());

            topLabel.setBackground(
                    new Background(new BackgroundFill(Color.rgb(r, g, b, 1.0f),
                                                      CornerRadii.EMPTY,
                                                      Insets.EMPTY)));

            //           topLabel.setStyle("-fx-background-color: " +
            // COLOR_WHITE + ";");
        });
    }

    /**
     * Attaches listeners to the text fields.
     *
     * Logic for rejecting non-numeric entries is heavily inspired by the
     * following post: http://stackoverflow.com/a/30796829
     * Main thread:    http://stackoverflow
     * .com/questions/7555564/what-is-the-recommended-way-to-make-a-numeric
     * -textfield-in-javafx
     */
    private void setupTextFieldListeners(TextField... textFields)
    {
        for (TextField textField : textFields) {
            textField.textProperty().addListener(
                    (observableValue, valueOld, valueNew) -> {
                        // Regex matches zero or more digits.
                        if (!valueNew.matches("\\d*")) {
                            // Remove non-digits.
                            textField.setText(
                                    valueNew.replaceAll("[^\\d]", ""));
                        } else {
                            // Handle exceptions thrown by negative numbers,
                            // etc.
                            // Clamp the value to 0-255.
                            try {
                                int value = Integer.parseInt(valueNew);
                                if (value < 0) {
                                    value = 0;
                                } else if (value > 255) {
                                    value = 255;
                                }
                                textField.setText(String.valueOf(value));
                            } catch (NumberFormatException e) {
                            }
                        }
                    });
        }
    }

    private GridPane createColorEntryPane()
    {
        GridPane pane = new GridPane();

        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(5));
        pane.setHgap(10);
        pane.setVgap(5);

        ColumnConstraints colCon = new ColumnConstraints(50, 100, 150);
        pane.getColumnConstraints().addAll(colCon, colCon, colCon);

        pane.add(new Label("Red"), 0, 0);
        red = new TextField();
        pane.add(red, 0, 1);

        pane.add(new Label("Green"), 1, 0);
        green = new TextField();
        pane.add(green, 1, 1);

        pane.add(new Label("Blue"), 2, 0);
        blue = new TextField();
        pane.add(blue, 2, 1);

        return pane;
    }
}

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

import java.util.Random;


/**
 * Created by Jonas Sjöberg (js224eh) on 2017-02-13.
 */
public class ColorDisplay extends BorderPane
{
    private Label     topLabel;
    private Pane topPane;
    private Button    displayButton;
    private TextFieldRGB red;
    private TextFieldRGB green;
    private TextFieldRGB blue;

    public ColorDisplay()
    {
        topLabel = new Label("Color Display");
        topLabel.setFont(Font.font("Sans Serif", FontWeight.BOLD, 42));
        setAlignment(topLabel, Pos.CENTER);
        //setTop(topLabel);

        topPane = new Pane();
        topPane.setPrefSize(640, 200);
        setTop(topPane);

        setCenter(createColorEntryPane());

        displayButton = new Button("Display Color");
        setAlignment(displayButton, Pos.CENTER);
        setBottom(displayButton);

        /* Setup event listener that displays the current RGB values. */
        displayButton.setOnAction((ActionEvent actionEvent) -> {
            updateColorDisplay();
        });

        updateColorDisplay();
    }

    private void updateColorDisplay()
    {
        int r = red.getColorValue();
        int g = green.getColorValue();
        int b = blue.getColorValue();

        System.out.printf("[DEBUG] Setting background to (RGB): %2d %2d %2d%n", r, g, b);
        Background bg = new Background(new BackgroundFill(Color.rgb(r, g, b),
                                                          new CornerRadii(0),
                                                          new Insets(0)));
        //topLabel.setBackground(bg);
        topPane.setBackground(bg);
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

        // Start with randomized color value entries.
        Random random = new Random();

        pane.add(new Label("Red"), 0, 0);
        red = new TextFieldRGB(String.valueOf(random.nextInt(256)));
        pane.add(red, 0, 1);

        pane.add(new Label("Green"), 1, 0);
        green = new TextFieldRGB(String.valueOf(random.nextInt(256)));
        pane.add(green, 1, 1);

        pane.add(new Label("Blue"), 2, 0);
        blue = new TextFieldRGB(String.valueOf(random.nextInt(256)));
        pane.add(blue, 2, 1);

        return pane;
    }
}

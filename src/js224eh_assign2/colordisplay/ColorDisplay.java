package js224eh_assign2.colordisplay;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


/**
 * Created by Jonas Sjöberg (js224eh) on 2017-02-13.
 */
public class ColorDisplay extends BorderPane
{
    private Label topLabel;
    private Button displayButton;

    public ColorDisplay()
    {
        init();
    }

    private void init()
    {
        topLabel = new Label("Color Display");
        topLabel.setFont(Font.font("Sans Serif", FontWeight.BOLD, 42));
        topLabel.setAlignment(Pos.CENTER);
        setTop(topLabel);

        setCenter(createColorEntryPane());

        displayButton = new Button("Display Color");
        displayButton.setAlignment(Pos.CENTER);
        setBottom(displayButton);
    }

    private GridPane createColorEntryPane()
    {
        GridPane pane = new GridPane();

        pane.setAlignment(Pos.CENTER);
        // pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.4));
        pane.setPadding(new Insets(5));
        pane.setHgap(10);
        pane.setVgap(5);
        ColumnConstraints constraints = new ColumnConstraints(50, 100, 150);
        pane.getColumnConstraints().addAll(constraints, constraints, constraints);


        pane.add(new Label("Red"), 0, 0);
        pane.add(new Label("Green"), 1, 0);
        pane.add(new Label("Blue"), 2, 0);

        final TextField red = new TextField();
        pane.add(red, 0, 1);

        final TextField green = new TextField();
        pane.add(green, 1, 1);

        final TextField blue = new TextField();
        pane.add(blue, 2, 1);

        return pane;
    }
}

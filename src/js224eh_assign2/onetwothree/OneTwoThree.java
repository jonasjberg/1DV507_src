// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 2: Data Structures, JUnit, and JavaFX1
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-02-11.

package js224eh_assign2.onetwothree;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class OneTwoThree extends Application
{
    final String COLOR_BLUE  = "#5588EE";
    final String COLOR_GRAY  = "#2B2B2B";
    final String COLOR_WHITE = "#DBDBDB";
    final String COLOR_RED   = "#B22222";

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        // Top-level container which will hold three stacked BorderPanes.
        VBox root = new VBox();

        // Create the first text label.
        Label labelOne = createTextLabel("One",
                                         Color.web(COLOR_WHITE),
                                         Color.web(COLOR_RED));

        // Create the first of the three horizontal slices.
        BorderPane borderPaneTop = new BorderPane();
        borderPaneTop.setTop(labelOne);
        borderPaneTop.setAlignment(labelOne, Pos.TOP_LEFT);
        borderPaneTop.setStyle("-fx-background-color: " + COLOR_GRAY + ";");


        // Create the second text label.
        Label labelTwo = createTextLabel("Two",
                                         Color.web(COLOR_WHITE),
                                         Color.web(COLOR_GRAY));

        // Create the second of the three horizontal slices.
        BorderPane borderPaneMiddle = new BorderPane();
        borderPaneMiddle.setCenter(labelTwo);
        borderPaneMiddle.setAlignment(labelTwo, Pos.CENTER);
        borderPaneMiddle.setStyle("-fx-background-color: " + COLOR_RED + ";");

        // Create the third text label.
        Label labelThree = createTextLabel("Three",
                                           Color.web(COLOR_GRAY),
                                           Color.web(COLOR_RED));

        // Create the third of the three horizontal slices.
        BorderPane borderPaneBottom = new BorderPane();
        borderPaneBottom.setBottom(labelThree);
        borderPaneBottom.setAlignment(labelThree, Pos.BOTTOM_RIGHT);
        borderPaneBottom.setStyle("-fx-background-color: " + COLOR_WHITE + ";");

        // Dynamically resize the BorderPanes to each take up one third of the
        // total window height, I.E. continuously calculate and set the height
        // of all three panes.
        borderPaneTop.prefHeightProperty().bind(
                root.heightProperty().divide(3.0));
        borderPaneMiddle.prefHeightProperty().bind(
                root.heightProperty().divide(3.0));
        borderPaneBottom.prefHeightProperty().bind(
                root.heightProperty().divide(3.0));

        root.setPadding(new Insets(10, 10, 10, 10));
        root.setSpacing(5.0);
        root.getChildren().addAll(borderPaneTop, borderPaneMiddle,
                                  borderPaneBottom);

        Scene scene = new Scene(root, 320, 200);
        stage.setTitle("1DV507 Assignment 2 -- Exercise 5");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * COnvenience method for creating a JavaFX text "Label" with a specified
     * text color and dropshadow color.
     *
     * @param labelText   The text to use in the label.
     * @param labelColor  The text color.
     * @param shadowColor The shadow color.
     * @return A JavaFX Label object.
     */
    private Label createTextLabel(String labelText, Color labelColor,
                                  Color shadowColor)
    {
        final Font LABEL_FONT = Font.font("Mono", 18);

        Label label = new Label(labelText);

        label.setFont(LABEL_FONT);
        label.setTextFill(labelColor);

        DropShadow shadow = new DropShadow();
        shadow.setOffsetX(2.0f);
        shadow.setOffsetY(2.0f);
        shadow.setColor(shadowColor);
        label.setEffect(shadow);

        return label;
    }
}

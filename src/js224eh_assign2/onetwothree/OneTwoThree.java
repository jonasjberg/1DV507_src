package js224eh_assign2.onetwothree;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;


/**
 * Created by Jonas Sjöberg (js224eh) on 2017-02-11.
 */
public class OneTwoThree extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
/*        HBox hboxTop    = new HBox();
        HBox hboxMiddle = new HBox();
        HBox hboxBottom = new HBox();

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        gridPane.add(new Label("One"), 0, 0);
        gridPane.add(new Label("Top Mid"), 1, 0);
        gridPane.add(new Label("Top Right"), 2, 0);
        gridPane.add(new Label("Mid Left"), 0, 1);
        gridPane.add(new Label("Mid Mid"), 1, 1);
        gridPane.add(new Label("Mid Right"), 2, 1);
        gridPane.add(new Label("Bottom Left"), 0, 2);
        gridPane.add(new Label("Bottom Mid"), 1, 2);
        gridPane.add(new Label("Bottom Right"), 2, 2);

        hboxTop.getChildren().add(gridPane);*/

        /*
         *  BorderPane
         *     ___________________________
         *    | (One)     Top             |
         *    |---------------------------|
         *    |      |            |       |
         *    | Left |   Center   | Right |
         *    |      |   (Two)    |       |
         *    |---------------------------|
         *    |          Bottom   (Three) |
         *    '---------------------------'
         */

        VBox root = new VBox();

        final Font font = Font.font("Mono", 18);

        Label labelOne = new Label("One");
        labelOne.setFont(font);
        labelOne.setTextFill(Color.rgb(255, 255, 255, 1));

        DropShadow dsOne = new DropShadow();
        dsOne.setOffsetX(2.0f);
        dsOne.setOffsetY(2.0f);
        // dsOne.setColor(Color.rgb(178, 34, 34, .988));
        dsOne.setColor(Color.rgb(255, 34, 34, .988));
        labelOne.setEffect(dsOne);

        BorderPane borderPaneTop = new BorderPane();
        borderPaneTop.setAlignment(labelOne, Pos.TOP_LEFT);
        borderPaneTop.setTop(labelOne);
        borderPaneTop.setStyle("-fx-background-color: black;");
        borderPaneTop.prefHeightProperty().bind(root.heightProperty().divide(3.0));
        // circle.centerXProperty().bind(pane.widthProperty().divide(2.0));

        Label labelTwo = new Label("Two");
        labelTwo.setFont(font);
        // labelTwo.setStyle("-fx-color: black");
        BorderPane borderPaneMiddle = new BorderPane();
        borderPaneMiddle.setAlignment(labelTwo, Pos.CENTER);
        borderPaneMiddle.setCenter(labelTwo);
        borderPaneMiddle.setStyle("-fx-background-color: #b22222;");
        borderPaneMiddle.prefHeightProperty().bind(root.heightProperty().divide(3.0));

        Label labelThree = new Label("Three");
        labelThree.setFont(font);
        // labelThree.setStyle("-fx-color: black");
        BorderPane borderPaneBottom = new BorderPane();
        borderPaneBottom.setAlignment(labelThree, Pos.BOTTOM_RIGHT);
        borderPaneBottom.setBottom(labelThree);
        borderPaneBottom.setStyle("-fx-background-color: ghostwhite;");
        borderPaneBottom.prefHeightProperty().bind(root.heightProperty().divide(3.0));

        root.setPadding(new Insets(10, 10, 10, 10));
        root.setSpacing(5.0);
        root.getChildren().addAll(borderPaneTop, borderPaneMiddle,
                                  borderPaneBottom);

        Scene scene = new Scene(root, 320, 200);
        stage.setScene(scene);
        stage.show();

        /*
         *  BorderPane
         *     ___________________________
         *    |           Top             |
         *    |---------------------------|
         *    |      |            |       |
         *    | Left |   Center   | Right |
         *    |      |            |       |
         *    |---------------------------|
         *    |          Bottom           |
         *    '---------------------------'
         *
         *  HBox
         *     ___________________________
         *    |      |            |       |
         *    | Node |    Node    | Node  |
         *    |      |            |       |
         *    '---------------------------'
         *
         *  Place one HBox in BorderPane "Top" and another HBox in BorderPane
         *  "Bottom". This allows diagonal placement.
         *
         *    .---------------------------.  <-.
         *    | Node |    Node    | Node  |    | HBox #1
         *    |---------------------------|  <-'
         *    |      |            |       |
         *    | Left |   Center   | Right |
         *    |      |            |       |
         *    |---------------------------|  <-.
         *    | Node |    Node    | Node  |    | HBox #2
         *    '---------------------------'  <-'
         *
         *  Three of these will be placed in one HBox each.
         *
         *
         *
         *
         *
         * */



    }
}

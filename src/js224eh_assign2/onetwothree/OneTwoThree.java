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
        // Top-level container which will hold three stacked BorderPanes.
        VBox root = new VBox();


        // Label labelOne = new Label("One");
        // labelOne.setFont(font);
        // labelOne.setTextFill(Color.rgb(255, 255, 255, 1));

        // DropShadow dsOne = new DropShadow();
        // dsOne.setOffsetX(2.0f);
        // dsOne.setOffsetY(2.0f);
        // // dsOne.setColor(Color.rgb(178, 34, 34, .988));
        // dsOne.setColor(Color.rgb(255, 34, 34, .988));
        // labelOne.setEffect(dsOne);

        //final Color COLOR_BLUE = Color.rgb(85, 136, 238, 1);
        final String COLOR_BLUE = "#5588EE";
        //final Color COLOR_GRAY = Color.web("#2B2B2B");
        final String COLOR_GRAY = "#2B2B2B";
        //final Color COLOR_WHITE = Color.rgb(219, 219, 219);
        final String COLOR_WHITE = "#DBDBDB";
        final String COLOR_RED = "#B22222";

        Label labelOne = createTextLabel("One",
                                         Color.web(COLOR_WHITE),
                                         Color.web(COLOR_RED));

        BorderPane borderPaneTop = new BorderPane();
        borderPaneTop.setAlignment(labelOne, Pos.TOP_LEFT);
        borderPaneTop.setTop(labelOne);
        //borderPaneTop.setStyle("-fx-background-color: black;");
        borderPaneTop.setStyle("-fx-background-color: " + COLOR_GRAY + ";");
        borderPaneTop.prefHeightProperty().bind(root.heightProperty().divide(3.0));
        // circle.centerXProperty().bind(pane.widthProperty().divide(2.0));


        Label labelTwo = createTextLabel("Two",
                                         Color.web(COLOR_WHITE),
                                         Color.web(COLOR_GRAY));

        BorderPane borderPaneMiddle = new BorderPane();
        borderPaneMiddle.setAlignment(labelTwo, Pos.CENTER);
        borderPaneMiddle.setCenter(labelTwo);
        //borderPaneMiddle.setStyle("-fx-background-color: #b22222;");
        borderPaneMiddle.setStyle("-fx-background-color: " + COLOR_RED + ";");

        borderPaneMiddle.prefHeightProperty().bind(root.heightProperty().divide(3.0));


        Label labelThree = createTextLabel("Three",
                                           Color.web(COLOR_GRAY),
                                           Color.web(COLOR_RED));
                                           //Color.rgb(0, 0, 0, 1),
                                           //Color.rgb(0, 0, 0, 1));

        BorderPane borderPaneBottom = new BorderPane();
        borderPaneBottom.setAlignment(labelThree, Pos.BOTTOM_RIGHT);
        borderPaneBottom.setBottom(labelThree);
        borderPaneBottom.setStyle("-fx-background-color: " + COLOR_WHITE + ";");
        borderPaneBottom.prefHeightProperty().bind(root.heightProperty().divide(3.0));

        root.setPadding(new Insets(10, 10, 10, 10));
        root.setSpacing(5.0);
        root.getChildren().addAll(borderPaneTop, borderPaneMiddle,
                                  borderPaneBottom);

        Scene scene = new Scene(root, 320, 200);
        stage.setScene(scene);
        stage.show();
    }

    private Label createTextLabel(String labelText, Color labelColor,
                                  Color shadowColor)
    {
        final Font LABEL_FONT = Font.font("Mono", 18);

        Label label = new Label(labelText);;

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

package js224eh_assign2.onetwothree;


import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


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
        VBox hboxTop    = new HBox();
        VBox hboxMiddle = new HBox();
        VBox hboxBottom = new HBox();

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
         *
         *
         *
         *
         * */


    }
}

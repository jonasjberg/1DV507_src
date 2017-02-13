package js224eh_assign2.colordisplay;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Created by Jonas Sjöberg (js224eh) on 2017-02-13.
 */
public class ColorDisplayMain extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        ColorDisplay colorDisplay = new ColorDisplay();

        Scene scene = new Scene(colorDisplay, 640, 480);
        stage.setTitle("1DV507 Assignment 2 -- Exercise 7 - ColorDisplay");
        stage.setScene(scene);
        stage.show();
    }
}

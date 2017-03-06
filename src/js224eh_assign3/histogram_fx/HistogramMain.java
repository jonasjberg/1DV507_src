// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 3: Algorithms, Hashing/BSTs and GUI #2
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-06.

// Exercise 10
// ===========
// In Assignment 1 you used an external library XChart to present a bar and pie
// chart for a set of numbers read from a file. Revisit this task but create a
// graphical user interface that presents the numbers with one or more suitable
// charts using JavaFX. The file should be opened using a file selector and a
// suitable error message should be displayed if an error occurs.

package js224eh_assign3.histogram_fx;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class HistogramMain extends Application
{
    final int WINDOW_WIDTH = 800;
    final int WINDOW_HEIGHT = 600;
    final static String WINDOW_TITLE = "1DV507 Assignment 3 -- Exercise 10";

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        HistogramFXapp app = new HistogramFXapp(stage);

        Scene scene = new Scene(app, WINDOW_WIDTH, WINDOW_HEIGHT);

        stage.setMinWidth(WINDOW_WIDTH);
        stage.setMinHeight(WINDOW_HEIGHT);
        stage.setTitle(WINDOW_TITLE);
        stage.setScene(scene);
        stage.show();
    }
}

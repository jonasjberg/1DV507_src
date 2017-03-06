// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// 1DV507 -- Programming and Data Structures, VT2017
// Assignment 3: Algorithms, Hashing/BSTs and GUI #2
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// Created by Jonas Sjöberg (js224eh) on 2017-03-06.

// Exercise 8
// ==========
// Design and implement a class UpDownPane where the pane contains a pattern of
// 7x7 smaller panes. The small pane in the middle of the big pane will, once
// the program is started, contain a small icon (or image). When an arrow key is
// pressed, the icon will move a step up/down or right/left, to a neighboring
// small pane. If the icon is moved out of the bigger pane, then the icon will
// appear on the other side of the bigger pane (i.e. if the icon is moved
// upwards when in an uppermost small pane, then it will appear on the
// corresponding small panel in the bottom row). Also write a test program
// UpDownMain.java, starting a window containing an UpDownPanel

package js224eh_assign3;


import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class UpDownPane extends GridPane
{
    private int size;
    private int xPos;
    private int yPos;

    private final int SMALLER_PANE_SIZE = 100;

    private Image image = new Image(
            getClass().getResourceAsStream("UpDownImage.png"));
    private ImageView imageView = new ImageView(image);
    private Group group = new Group(imageView);

    public UpDownPane(int size)
    {
        this.size = size;
        xPos = this.size / 2;
        yPos = this.size / 2;

        renderState();
    }

    private UpDownPane renderState()
    {
        this.setStyle("-fx-background-color: firebrick");

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (xPos == i && yPos == j) {
                    this.add(group, i, j);

                } else {
                    Rectangle rectangle = new Rectangle();
                    rectangle.setWidth(SMALLER_PANE_SIZE);
                    rectangle.setHeight(SMALLER_PANE_SIZE);
                    rectangle.setFill(Color.BLACK);
                    this.add(rectangle, i, j);
                }
            }
        }

        return this;
    }

    public void handleMovementEvent(KeyEvent keyEvent)
    {
        switch (keyEvent.getCode()) {
            case LEFT:
            case H:
                System.out.println("LEFT");
                xPos -= 1;
                keyEvent.consume();
                break;
            case DOWN:
            case J:
                System.out.println("DOWN");
                yPos -= 1;
                keyEvent.consume();
                break;
            case UP:
            case K:
                System.out.println("UP");
                yPos += 1;
                keyEvent.consume();
                break;
            case RIGHT:
            case L:
                System.out.println("RIGHT");
                xPos += 1;
                keyEvent.consume();
                break;
            default:
                break;
        }

        /* Wrap the position if leaving the "area". */
        if (xPos < 0) {
            xPos = size - 1;
        } else if (xPos == size) {
            xPos = 0;
        }

        if (yPos < 0) {
            yPos = size - 1;
        } else if (yPos == size) {
            yPos = 0;
        }

        this.getChildren().removeAll(this.getChildren());
        renderState();
    }
}

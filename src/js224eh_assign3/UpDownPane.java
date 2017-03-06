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
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class UpDownPane extends GridPane
{
    private final int SMALLER_PANE_SIZE = 100;

    private int size;
    private int xPos;
    private int yPos;
    private Image image;
    private ImageView imageView;
    private DropShadow dropShadow;
    private Group group;

    /**
     * Instantiates a new UpDownPane with "size" number of panes;
     * a grid of "size" x "size" rectangles.
     *
     * @param size The number of smaller panes in this UpDownPane.
     */
    public UpDownPane(int size)
    {
        this.size = size;
        xPos = this.size / 2;
        yPos = this.size / 2;

        image = new Image(getClass().getResourceAsStream("UpDownImage.png"));
        imageView = new ImageView(image);

        dropShadow = new DropShadow();
        dropShadow.setBlurType(BlurType.GAUSSIAN);
        dropShadow.setSpread(0.2f);
        dropShadow.setRadius(13f);
        dropShadow.setColor(Color.web("#B22222"));

        group = new Group(imageView);
        imageView.setEffect(dropShadow);

        renderState();
    }

    /**
     * Clears and redraws the pane to reflect the current position.
     */
    private void renderState()
    {
        getChildren().removeAll(getChildren());
        setStyle("-fx-background-color: #2B2B2B");

        /* Loop through all grid positions and place the group of the
        *  image and drop shadow when at the current position, otherwise
        *  place transparent rectangles to maintain alignment. */
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (xPos == i && yPos == j) {
                    add(group, i, j);

                } else {
                    Rectangle rectangle = new Rectangle();
                    rectangle.setWidth(SMALLER_PANE_SIZE);
                    rectangle.setHeight(SMALLER_PANE_SIZE);
                    rectangle.setFill(Color.TRANSPARENT);
                    add(rectangle, i, j);
                }
            }
        }
    }

    /**
     * Handles a keyboard event.
     *
     * Tests which key was hit and updates the current position.
     * Use either the arrow keys, Quake-style "WASD"-keys or Vi-style "hjkl".
     *
     * @param keyEvent The KeyEvent to handle.
     */
    public void handleMovementEvent(KeyEvent keyEvent)
    {
        /* Update current position. */
        switch (keyEvent.getCode()) {
            case LEFT:
            case H:
            case A:
                xPos -= 1;
                break;
            case DOWN:
            case J:
            case S:
                yPos += 1;
                break;
            case UP:
            case K:
            case W:
                yPos -= 1;
                break;
            case RIGHT:
            case L:
            case D:
                xPos += 1;
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

        /* Clear and redraw all nodes. */
        renderState();
    }
}

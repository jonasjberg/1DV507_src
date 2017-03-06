package js224eh_assign3.catch_creature;


import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.Group;


/**
 * Created by Jonas Sjöberg (js224eh) on 2017-03-06.
 */
public class CreaturePlayfield extends Pane
{
    public static double PLAYFIELD_WIDTH;
    public static double PLAYFIELD_HEIGHT;
    private Group        group;

    private Creature creature;

    private int score;

    public CreaturePlayfield(double width, double height)
    {
        PLAYFIELD_WIDTH = width;
        PLAYFIELD_HEIGHT = height;

        creature = new Creature();
        creature.randomizePosition();
        group = new Group(creature.getImageView());

        score = 0;
        getChildren().removeAll(getChildren());
        getChildren().add(group);
        redraw();
    }

    /**
     * Handles left-click MouseEvents.
     *
     * @param mouseEvent The MouseEvent to handle.
     */
    public void handleMouseEvent(MouseEvent mouseEvent)
    {
        double mouseX = mouseEvent.getX();
        double mouseY = mouseEvent.getY();

        if (creature.checkMouseOverlap(mouseX, mouseY)) {
            score++;
            creature.randomizePosition();
            redraw();
        }
    }

    /**
     * Redraw the playfield.
     */
    private void redraw()
    {
        creature.redraw();

        // getChildren().removeAll(getChildren());
        // getChildren().add(group);
    }
}

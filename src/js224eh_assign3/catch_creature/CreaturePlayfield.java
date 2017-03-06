package js224eh_assign3.catch_creature;


import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.Group;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.util.Random;


/**
 * Created by Jonas Sjöberg (js224eh) on 2017-03-06.
 */
public class CreaturePlayfield extends Pane
{
    private double playfieldWidth;
    private double playfieldHeight;

    private Image      creatureImage;
    private ImageView  creatureImageView;
    private DropShadow creatureDropShadow;
    private Group      group;

    private Creature creature;

    private int score;

    public CreaturePlayfield(double width, double height)
    {
        playfieldWidth = width;
        playfieldHeight = height;

        try {
            creatureImage = new Image(
                    getClass().getResourceAsStream("creature.png"));
        } catch (IllegalArgumentException e) {
            System.out.printf("[ERROR] %s%n", e.toString());
        }

        creatureDropShadow = new DropShadow();
        creatureDropShadow.setBlurType(BlurType.GAUSSIAN);
        creatureDropShadow.setSpread(0.2f);
        creatureDropShadow.setRadius(13f);
        creatureDropShadow.setColor(Color.web("#B22222"));

        creatureImageView = new ImageView(creatureImage);
        creatureImageView.setEffect(creatureDropShadow);

        group = new Group(creatureImageView);

        creature = new Creature();
        score = 0;
    }

    public void handleMouseEvent(MouseEvent mouseEvent)
    {
        double mouseX = mouseEvent.getX();
        double mouseY = mouseEvent.getY();

        if (creature.checkMouseOverlap(mouseX, mouseY)) {
            System.out.println("SCORE++");
            score++;
            randomizePosition();
            redraw();
        }
    }

    private void redraw()
    {
        creatureImageView.setLayoutX(creature.getXpos());
        creatureImageView.setLayoutY(creature.getYpos());

        getChildren().removeAll(getChildren());
        getChildren().add(group);
    }

    private void randomizePosition()
    {
        Random rng = new Random();

        double randomX = (rng.nextDouble() * playfieldWidth) - creature.SIZE;
        double randomY = (rng.nextDouble() * playfieldHeight) - creature.SIZE;

        System.out.printf("Randomized position: (%f,%f)%n", randomX, randomY);

        creature.setPosition(randomX, randomY);
    }
}

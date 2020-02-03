package GUI;

import GameUnits.GameUnit;
import Main.GameWorld;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

/*
This is our controller for our middle pane that renders all the graphics.
It has zoom capability with the mouse wheel and also has drag capability
with the mouse click and hold.
 */
public class CenterPaneController {
    final double SCALING_AMOUNT = 0.1;
    private double scaleFactor = 1;

    //Higher rate to further slow dragging so its smoother.
    private double dragSlowRate = 4;

    //Values to hold how far we need to/have done X and Y translations.
    private double dragX = 1;
    private double dragY = 1;

    //Values to hold the last X and Y position for dragging.
    private double lastXPos = 0;
    private double lastYPos = 0;

    @FXML private Pane centerPane; // Value injected by FXMLLoader

    @FXML    // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        initZoom();
        initDrag();
        initBorder();
        clipChildren(centerPane,12);
    }

    // See Project:SelectingAndUI #4
    public void update(GameWorld gameWorld) {
        Group group = new Group();
        group.getChildren().addAll(gameWorld.getDrawables());
        group.setTranslateX(dragX);
        group.setTranslateY(dragY);
        group.setScaleX(group.getScaleX() * scaleFactor);
        group.setScaleY(group.getScaleY() * scaleFactor);
        centerPane.getChildren().clear();
        centerPane.getChildren().addAll(group);

    }

    /*
    Creates a clipping pane
     */
    private void clipChildren(Region region, double arc){
        final Rectangle outputClip = new Rectangle();
        outputClip.setArcWidth(arc);
        outputClip.setArcHeight(arc);
        region.setClip(outputClip);
        region.layoutBoundsProperty().addListener((ov, oldValue, newValue) -> {
            outputClip.setWidth(newValue.getWidth());
            outputClip.setHeight(newValue.getHeight());
        });
    }

    private void initBorder(){
        Border border = new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
                new CornerRadii(4), BorderStroke.THIN));
        centerPane.setBorder(border);
    }

    private void initZoom(){
        centerPane.setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                event.consume();;
                if (event.getDeltaY() > 0){
                    scaleFactor += SCALING_AMOUNT;
                }
                else if (event.getDeltaY() < 0){
                    scaleFactor -= SCALING_AMOUNT;
                    if (scaleFactor <= 0) {
                        scaleFactor = 0.1;
                    }
                }
            }
        });
    }
    private void initDrag() {
            /*When mouse is clicked we record the cursor is so we know
            where to start the dragging point from.*/
            centerPane.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    centerPane.getScene().setCursor(Cursor.HAND);
                    lastXPos = event.getX();
                    lastYPos = event.getY();
                }
            });

            //When the mouse click is released we change the cursor back
            centerPane.setOnMouseReleased(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    centerPane.getScene().setCursor(Cursor.DEFAULT);
                }
            });

            /*When the mouse is dragged we used the location we recorded from the initial click
              and calculate where it is from where our event was fired off from and uses
              the difference to save how much we need to translate in dragX and dragY*/
            centerPane.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    centerPane.getScene().setCursor(Cursor.CLOSED_HAND);
                    // Moving the mouse right also moves the images right.
                    if (lastXPos < event.getX()) {
                        dragX += (event.getX() - lastXPos)/dragSlowRate;
                        lastXPos = event.getX();
                    } // Moving the mouse left also moves the images left.
                    else if (lastXPos > event.getX()) {
                        dragX += (event.getX() - lastXPos)/dragSlowRate;
                        lastXPos = event.getX();
                    }
                    // Moving the mouse down also moves the images down
                    if (lastYPos < event.getY()) {
                        dragY += (event.getY() - lastYPos)/dragSlowRate;
                        lastYPos = event.getY();
                        // Moving the mouse up also moves the images up
                    } else if (lastYPos > event.getY()) {
                        dragY += (event.getY() - lastYPos)/dragSlowRate;
                        lastYPos = event.getY();
                    }
                }
            });
        }

}

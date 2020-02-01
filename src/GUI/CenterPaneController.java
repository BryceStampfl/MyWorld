package GUI;

import Main.GameWorld;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;


public class CenterPaneController {
    final double SCALING_AMOUNT = 0.1;
    private double scaleFactor = 1;

    //Higher rate to further slow dragging so its smoother.
    private double dragSlowRate = 4;
    //
    private double dragX = 1;
    private double dragY = 1;
    //
    private double lastXPos = 0;
    private double lastYPos = 0;


    
    @FXML // fx:id="centerPane"
    private Pane centerPane; // Value injected by FXMLLoader

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        initZoom();
        initDrag();
        assert centerPane != null : "fx:id=\"centerPane\" was not injected: check your FXML file 'CenterPane.fxml'.";
    }

    public void update(GameWorld gameWorld) {
        Group group = new Group();
        group.getChildren().addAll(gameWorld.getDrawables());
        group.setScaleX(group.getScaleX() * scaleFactor);
        group.setScaleX(group.getScaleY() * scaleFactor);
        group.setTranslateX(dragX);
        group.setTranslateY(dragY);

        centerPane.getChildren().clear();
        centerPane.getChildren().addAll(group);

    }
    public CenterPaneController(){
        assert centerPane != null : "fx:id=\"centerPane\" was not injected: check your FXML file 'CenterPane.fxml'.";
    }

    private void initZoom(){
        centerPane.setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                event.consume();;

                if (event.getDeltaY() > 0){
                    scaleFactor += 0.25;
                }
                else if (event.getDeltaY() < 0){
                    scaleFactor -= 0.25;
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
                    System.out.println("MouseExited");
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

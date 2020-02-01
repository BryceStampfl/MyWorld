package GUI;

import Main.GameWorld;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;


public class CenterPaneController {
    final double SCALING_AMOUNT = 0.1;
    private double scaleFactor = 1;
    private double dragX = 0;
    private double lastXPos = 0;
    private double lastYPos = 0;
    private double dragY = 0;




    @FXML // fx:id="centerPane"
    private Pane centerPane; // Value injected by FXMLLoader

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        initZoom();
        initDrag();
        assert centerPane != null : "fx:id=\"centerPane\" was not injected: check your FXML file 'CenterPane.fxml'.";
        System.out.println("CenterPaneController init funct");
    }

    public void update(GameWorld gameWorld) {
        ArrayList<ImageView> listOfDrawables = gameWorld.getDrawables();


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
        System.out.println("CenterPaneController constructor start");
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

    private void initDrag(){

        centerPane.setOnMouseDragEntered(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                lastXPos = event.getX();
                lastYPos = event.getY();
            }
        });

        centerPane.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // dragX = 0;
                // dragY = 0;

                // Moving the mouse right also moves the images right.
                if (lastXPos < event.getX()) {
                    dragX += (event.getX() - lastXPos) / 10;
                    if (dragX > 1000) {
                        dragX = 1000;
                    }
                    lastXPos = event.getX();
                } // Moving the mouse left also moves the images left.
                else if (lastXPos > event.getX()) {
                    dragX += (event.getX() - lastXPos) / 10;
                    if (dragX > 1000) {
                        dragX = 1000;
                    }
                    lastXPos = event.getX();
                }

                // Moving the mouse down also moves the images down
                if (lastYPos < event.getY()) {
                    dragY += (event.getY() - lastYPos) / 5;
                    if (dragY > 1000) {
                        dragY = 1000;
                    }
                    lastYPos = event.getY();
                // Moving the mouse up also moves the images up
                }else if (lastYPos > event.getY()) {
                    dragY += ( event.getY() - lastYPos)/5;
                    if (dragY > 1000) {
                        dragY = 1000;
                    }
                    lastYPos = event.getY();
                }
            }
        });
/*
        centerPane.setOnMouseDragExited(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                dragX = 0;
                dragY = 0;
            }
        });
        */
    }
}

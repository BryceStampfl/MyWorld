package GUI;

import Main.GameWorld;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class CenterPaneController {


    @FXML // fx:id="centerPane"
    private Pane centerPane; // Value injected by FXMLLoader

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert centerPane != null : "fx:id=\"centerPane\" was not injected: check your FXML file 'CenterPane.fxml'.";
        System.out.println("CenterPaneController init funct");
    }

    public void update(GameWorld gameWorld) {
        System.out.println(centerPane.getHeight());
        System.out.println(centerPane.getWidth());

        centerPane.getChildren().clear();
        centerPane.getChildren().addAll(gameWorld.getDrawables());
    }
    public CenterPaneController(){
        System.out.println("CenterPaneController constructor start");
        assert centerPane != null : "fx:id=\"centerPane\" was not injected: check your FXML file 'CenterPane.fxml'.";

    }
}

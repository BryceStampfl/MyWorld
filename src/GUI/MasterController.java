package GUI;

import Main.GameWorld;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;


public class MasterController {

    @FXML private StackPane mapPane;
    @FXML private Pane centerPane;
    @FXML private BorderPane masterPane;

    @FXML private CenterPaneController centerPaneController;
    @FXML private MapPaneController mapPaneController;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

    }

    public void update(GameWorld gameWorld){
        centerPaneController.update(gameWorld);
    }
}

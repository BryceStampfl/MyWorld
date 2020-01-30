/**
 * Sample Skeleton for 'MapPane.fxml' Controller Class
 */

package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;

public class MapPaneController {

    @FXML
    public StackPane mapPane;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;


    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert mapPane != null : "fx:id=\"MapPane\" was not injected: check your FXML file 'MapPane.fxml'.";

    }
}

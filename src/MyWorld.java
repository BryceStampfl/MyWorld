import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MyWorld extends Application {

    public static void main(String[] args) {
        launch(args);
    }
// Stage -> Scene(Base class is Node)


    //Main entry point for JavaFX
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("My World");
        /*
        Image heroImage = new Image("/LightBandit_Spritesheet.png");
        Node hero = new ImageView(heroImage);
        StackPane root = new StackPane();
        root.getChildren().add(hero);
        primaryStage.setScene(new Scene(root, 1300, 250));
        primaryStage.show();
        */


    }
}

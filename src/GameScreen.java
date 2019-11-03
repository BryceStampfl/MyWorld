import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GameScreen extends Application {
    private Stage stage;
    private Group group;
    private Scene scene;

    private MyWorld world;

    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage stage) throws Exception {
        world = new MyWorld();

        stage = initStage();
        //Rectangle r = new Rectangle(10, 10, 15, 15);
        Group group = initGroup(r);
        Scene scene = new Scene(group);
        stage.setScene(scene);
        stage.show();



           /*
        Image heroImage = new Image("/LightBandit_Spritesheet.png");
        Node hero = new ImageView(heroImage);
        StackPane root = new StackPane();
        root.getChildren().add(hero);
        stage.setScene(new Scene(root, 1300, 250));
        stage.show();
        */

    }


    private Stage initStage() {
        stage = new Stage(StageStyle.DECORATED);
        stage.setHeight(800);
        stage.setWidth(1500);
        stage.setTitle("My World");
        return stage;
    }

    private Group initGroup(Rectangle r) {
        Group group = new Group(r);
        return group;
    }


}

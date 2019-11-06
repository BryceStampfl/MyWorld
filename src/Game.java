import javafx.application.Application;
import javafx.stage.Stage;

public class Game extends Application {
    private GameWorld myWorld;
    private GameScreen myScreen;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        myWorld = new GameWorld();

        myScreen = new GameScreen();

        // Sends the Sprites to myScreen so they can be added to the Group later.
        myScreen.setDrawables(myWorld.getDrawables());
        myScreen.init();

        // 1.Prepares a Stage.
        // 2.Prepares the Scene Graph w/ the required nodes.
        // 3.Prepares a Scene w/ the required dimensions and adds a scene graph to it.
        // 4.Prepares a stage and adds the Scene to the Stage.
        myScreen.showScreen();

    }
}

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Game extends Application {
    private GameWorld myWorld;
    private GameScreen myScreen;
    private Timeline timeline;


    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        myWorld = new GameWorld();
        myScreen = new GameScreen();
        timeline = initTimeline();

        // Sends the Sprites to myScreen so they can be added to the Group later.
        myScreen.setDrawables(myWorld.getDrawables());
        myScreen.init();

        timeline.play();
        myScreen.showScreen();

    }


    public Timeline initTimeline(){
        //One Frame
        KeyFrame kf = new KeyFrame(Duration.millis(1000 / 30), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateSprites();
               // checkCollisions();
                //cleanupSprites();
            }
        }); //One Frame
        timeline = new Timeline(kf);
        timeline.setCycleCount(Timeline.INDEFINITE);
        return (timeline);
    }

    private void updateSprites(){
        myWorld.update();

    }
}

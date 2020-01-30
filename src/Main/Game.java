package Main;/*
                                                                                   */
import GUI.CenterPaneController;
import GUI.ImageManager;
import GUI.MasterController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;


public class Game extends Application {
    private Timeline timeline;
    public ImageManager imageManager;
    private GameWorld gameWorld;
    private MasterController masterController;

    private Parent masterRoot;

    @Override
    public void start(Stage stage) throws Exception {
        imageManager = new ImageManager();
        gameWorld = new GameWorld();
        try{
            FXMLLoader masterLoader = new FXMLLoader();
            masterLoader.setLocation(getClass().getResource("/fxml/MasterPane.fxml"));
            masterRoot = masterLoader.load();
            masterController = masterLoader.getController();


        }catch (Exception e){
            e.printStackTrace();
        }
        stage = initStage();
        stage.show();
        timeline = initTimeline();
        timeline.play();


    }


    public Timeline initTimeline(){
        KeyFrame kf = new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent kf) {
                gameWorld.update();
                masterController.update(gameWorld);
            }
        });
        timeline = new Timeline(kf);
        timeline.setCycleCount(Timeline.INDEFINITE);
        return (timeline);
    }

    public static void main(String[] args) {
        launch(args);
    }


    private Stage initStage() {
        Scene scene = new Scene(masterRoot);
        Stage stage = new Stage();
        Rectangle2D primaryScreen = Screen.getPrimary().getVisualBounds();
        stage = new Stage(StageStyle.DECORATED);
        stage.setWidth(primaryScreen.getWidth());
        stage.setHeight(primaryScreen.getHeight());
        stage.setTitle("My World");
        stage.setScene(scene);
        return stage;
    }
}

import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.util.ArrayList;


public class GameScreen{

    private Stage stage;
    private Scene scene;
    private Group group;
    private Rectangle2D primaryScreen;
    private ArrayList<? extends Drawable> objectsToDraw;


    public void init(){
        this.group = initGroup();
        this.scene = initScene();
        this.stage = initStage();
    }

    private Group initGroup(){
        group = new Group();
        for (int i = 0; i < objectsToDraw.size(); i++) {
            group.getChildren().add(objectsToDraw.get(i).getImageView());
        }
        return group;
    }
    private Scene initScene(){
        scene = new Scene(group);
        return scene;
    }
    private Stage initStage() {
        this.primaryScreen = Screen.getPrimary().getVisualBounds();
        stage = new Stage(StageStyle.DECORATED);
        stage.setWidth(primaryScreen.getWidth());
        stage.setHeight(primaryScreen.getHeight());
        stage.setTitle("My World");
        stage.setScene(scene);
        return stage;
    }

    public void setDrawables(ArrayList<? extends Drawable> objectsToDraw){
        this.objectsToDraw = objectsToDraw;
    }

    public void showScreen(){
        stage.show();
    }



}

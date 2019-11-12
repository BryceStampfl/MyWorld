import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.util.ArrayList;

public class GameScreen{

    private Stage stage;
    private Scene scene;
    private Group group;
    private ArrayList<ImageView> objectsToDraw1;


    public void init(){
        this.group = initGroup();
        this.scene = initScene();
        this.stage = initStage();
    }

    private Group initGroup(){
        group = new Group();
        for (int i = 0; i < objectsToDraw1.size(); i++) {
            group.getChildren().add(objectsToDraw1.get(i));
        }
        return group;
    }
    private Scene initScene(){
        scene = new Scene(group);
        return scene;
    }
    private Stage initStage() {
        Rectangle2D primaryScreen = Screen.getPrimary().getVisualBounds();
        stage = new Stage(StageStyle.DECORATED);
        stage.setWidth(primaryScreen.getWidth());
        stage.setHeight(primaryScreen.getHeight());
        stage.setTitle("My World");
        stage.setScene(scene);
        return stage;
    }



    public void setDrawables(ArrayList<? extends Drawable> objectsToDraw){
        objectsToDraw1 = new ArrayList<ImageView>();
        for (int i = 0; i < objectsToDraw.size();i++){
            this.objectsToDraw1.add(objectsToDraw.get(i).getImageView());
        }
    }

    public void showScreen(){
        stage.show();
    }

}

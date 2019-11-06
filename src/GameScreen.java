import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.util.ArrayList;

public class GameScreen{
    private final int stageWidth = 1500;
    private final int stageHeight = 800;

    private Stage stage;
    private Scene scene;
    private Group group;
    private ImageView imageView;
    private ArrayList<? extends Drawable> objectsToDraw;

    public GameScreen(){

    }
    public void init(){
        this.group = initGroup();
        this.scene = initScene();
        this.stage = initStage();
    }

    private Stage initStage() {
        stage = new Stage(StageStyle.DECORATED);
        stage.setWidth(stageWidth);
        stage.setHeight(stageHeight);
        stage.setTitle("My World");
        return stage;
    }


    private Group initGroup(){
        group = new Group();
        for (int i = 0; i < objectsToDraw.size(); i++) {
            imageView = new ImageView(objectsToDraw.get(i).getImage());
            group.getChildren().add(imageView);
        }
        return group;
    }

    private Scene initScene(){
        scene = new Scene(group, stageWidth,stageHeight);
        return scene;
    }

    public void setDrawables(ArrayList<? extends Drawable> objectsToDraw){
        this.objectsToDraw = objectsToDraw;
    }

    public void showScreen(){
        stage.show();
    }



}

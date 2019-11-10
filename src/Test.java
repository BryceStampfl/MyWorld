import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

// Testing class
public class Test extends Application {


    public static void main(String args[]) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception{

        Nation nation = new Nation("Test Nation");
        ImageView myCastle = nation.getCastle().getImageView();
        Group group = new Group(myCastle);
        Scene scene = new Scene(group, 1000, 1000);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }


}

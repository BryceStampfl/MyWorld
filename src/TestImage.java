import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class TestImage extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        //Creating an image
        Image image = new Image("/res/Castle1.png");

        //Setting the image view
        ImageView imageView = new ImageView(image);
        ImageView imageView2 = new ImageView(image);


        //Setting the position of the image
        imageView.setX(50);
        imageView.setY(25);

        imageView2.setX(333);
        imageView2.setY(333);

        //setting the fit height and width of the image view
        imageView.setFitHeight(50);
        imageView.setFitWidth(50);
        imageView2.setFitHeight(50);
        imageView2.setFitWidth(50);

        //Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);
        imageView2.setPreserveRatio(true);

        //Creating a Group object
        Group root = new Group(imageView);
        root.getChildren().add(imageView2);

        //Creating a scene object
        Scene scene = new Scene(root, 1000,1000);

        Stage stage = new Stage();
        //Setting title to the Stage
        stage.setTitle("Loading an image");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }
    public static void main(String args[]) {
        launch(args);
    }
}


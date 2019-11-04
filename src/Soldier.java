import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Soldier extends GameUnit {

    public Soldier(){

    }




    public String getPathToImage(){
        return "";
    }
    public Shape getShape(){
        return (new Rectangle(10, 10, 3, 3));
    }
}

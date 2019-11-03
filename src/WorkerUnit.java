import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class WorkerUnit extends GameUnit implements Drawable{

    public WorkerUnit(){
        hp = 1;
        att = 1;
        def = 1;
    }

    public String getPathToImage(){
        return "";
    }

    public Shape getShape(){
        Rectangle r = new Rectangle(10, 10, 15, 15);
        return r;
    }


}

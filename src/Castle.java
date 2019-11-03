import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Castle extends Structure implements Drawable {
    private final String imagePath = "";


    public Castle (){
        hp += 100;
        att += 10;
        def += 10;
    }


    public String getPathToImage(){
        return imagePath;
    }
    public Shape getShape(){
        Rectangle r = new Rectangle(10, 10, 15, 15);
        return r;
    }
}

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Castle extends Structure implements Drawable {
    private final String imagePath = "";

    public Castle (){
        setAtt(10);
        setDef(100);
        setHp(100);
    }


    public Image getImage(){
        return (new Image(""));
    }
}

